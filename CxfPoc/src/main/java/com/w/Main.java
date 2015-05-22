package com.w;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;

/**
 * Created by raphaelmonteiro on 5/20/15.
 */
public class Main {

    public static void main(String[]args){
        Hello hello = JAXRSClientFactory.create("http://localhost:8080", Hello.class);
        System.out.println(hello.sayHello());
    }
}
