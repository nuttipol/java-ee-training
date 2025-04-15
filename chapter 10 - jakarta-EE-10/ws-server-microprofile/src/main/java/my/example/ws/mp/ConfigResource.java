package my.example.ws.mp;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/config")
public class ConfigResource {

    @Inject
    @ConfigProperty(name = "app.greeting", defaultValue = "Hello")
//    @ConfigProperty(name = "app.greeting")
    private String greeting;

    @GET
    public String getGreeting() {
        return greeting + ", MicroProfile!";
    }
}
