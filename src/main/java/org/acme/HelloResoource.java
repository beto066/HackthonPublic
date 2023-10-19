package org.acme;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/ola")
public class HelloResoource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "sfgfjd";
    }
}
