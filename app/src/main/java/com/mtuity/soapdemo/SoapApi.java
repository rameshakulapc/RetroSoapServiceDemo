package com.mtuity.soapdemo;

import android.util.Log;

import com.sncr.xmlutils.SimpleXmlUtils;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import retrofit.RestAdapter;
import retrofit.http.Body;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.mime.TypedInput;

public class SoapApi {
    //http://www.w3schools.com/xml/tempconvert.asmx?op=FahrenheitToCelsius
    private static final String BASE_URL = "http://www.w3schools.com";

    public SoapApi() {

    }

    public SoapService getSoapService() {
        final Serializer serializer = new Persister();
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(new SimpleXmlConverter(serializer))
                .build();
        return adapter.create(SoapService.class);
    }

    public FahrenheitToCelsiusResponse calcFahrenheitToCelsius(String value) {
        FahrenheitToCelsius fahrenheitToCelsius = new FahrenheitToCelsius();
        fahrenheitToCelsius.setFahrenheit(value);
        String s = SimpleXmlUtils.persist(fahrenheitToCelsius);
        TypedInput typedInput = Util.buildBody(s);
        FahrenheitToCelsiusResponse response = getSoapService().calcFahrenheitToCelsius(typedInput);
        Log.e("TAG", "calcFahrenheitToCelsius:" + response.result);
        return response;
    }


    public interface SoapService {
        @POST("/xml/tempconvert.asmx")
        @Headers({"Content-Type: text/xml; charset=utf-8", "SOAPAction: \"http://www.w3schools.com/xml/FahrenheitToCelsius\""})
        FahrenheitToCelsiusResponse calcFahrenheitToCelsius(@Body TypedInput typedInput);
    }


}
