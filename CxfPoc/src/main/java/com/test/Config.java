package com.test;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

/**
 * Created by raphaelmonteiro on 5/20/15.
 */

@Configuration
public class Config extends ResourceConfig {

    public Config(){
        register(Hello.HelloImpl.class);
    }
}