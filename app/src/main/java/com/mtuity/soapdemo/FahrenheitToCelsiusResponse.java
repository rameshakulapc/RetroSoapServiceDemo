package com.mtuity.soapdemo;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/**
 * Created by Ramesh on 15/2/16.
 */
@Root(name = "soap:Envelope", strict = false)
@NamespaceList({@Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope", prefix = "soap"),
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema", prefix = "xsd"),
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema-instance", prefix = "xsi")})

public class FahrenheitToCelsiusResponse {
    @Element(name = "FahrenheitToCelsiusResult", required = false)
    @Path("soap:Body/FahrenheitToCelsiusResponse")
    String result;

}
