package my.example.ws.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/hello")
public class HelloResource {

    @GET
    public String sayHello() {
        return "Hello from MicroProfile and Jakarta!";
    }
}
