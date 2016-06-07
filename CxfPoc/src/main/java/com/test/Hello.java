package com.test;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by raphaelmonteiro on 5/20/15.
 */
@Component
@Path("/hello")
public interface Hello {

    @GET
    @Produces("application/json")
    public String sayHello();

    public class HelloImpl implements Hello {
        @Override
        public String sayHello() {
            return "hello";
        }
    }
}

