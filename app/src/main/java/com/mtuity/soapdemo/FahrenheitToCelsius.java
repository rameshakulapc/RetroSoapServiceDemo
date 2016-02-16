package com.mtuity.soapdemo;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/**
 * Created by Ramesh on 15/2/16.
 */
@Root(name = "FahrenheitToCelsius")
@NamespaceList({@Namespace(reference = "http://www.w3schools.com/xml/")})
public class FahrenheitToCelsius {

    @Element(name = "Fahrenheit")
    private String Fahrenheit;

    public String getFahrenheit() {
        return Fahrenheit;
    }

    public void setFahrenheit(String fahrenheit) {
        Fahrenheit = fahrenheit;
    }
}
