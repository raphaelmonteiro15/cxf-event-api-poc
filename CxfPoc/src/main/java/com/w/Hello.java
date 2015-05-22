package com.w;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by raphaelmonteiro on 5/20/15.
 */
@Path("/hello")
public interface Hello {

    @GET
    @Produces("application/json")
    String sayHello();

    public class HelloImpl implements Hello {
        public String sayHello() {
            return "";
        }
    }
}
