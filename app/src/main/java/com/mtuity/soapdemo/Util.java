package com.mtuity.soapdemo;

import java.io.UnsupportedEncodingException;

import retrofit.mime.TypedByteArray;
import retrofit.mime.TypedInput;

/**
 * Created by Ramesh on 15/2/16.
 */
public class Util {

    public static String formatSoapBodyAsStr(String s) {
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?><soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"><soap:Body>SOAPBODY</soap:Body></soap:Envelope>"
                .replaceAll("SOAPBODY", s.replaceFirst("<\\?xml version=\"1.0\" encoding=\"UTF-8\"\\?>", "")
                        .replaceFirst("<\\?xml version=\"1.0\" encoding=\"utf-8\"\\?>", ""));
    }

    public static TypedInput formatTypedBody(final String body) {
        try {
            TypedInput in = new TypedByteArray("application/xml", body.getBytes("UTF-8"));
            return in;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static TypedInput buildBody(String s) {
        return formatTypedBody(formatSoapBodyAsStr(s));
    }


}
