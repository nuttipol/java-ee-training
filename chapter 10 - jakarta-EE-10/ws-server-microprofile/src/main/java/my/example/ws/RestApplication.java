package my.example.ws;

import java.util.HashSet;
import java.util.Set;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import my.example.ws.resources.HelloResource;
import my.example.ws.resources.NotifyResource;
import my.example.ws.resources.UserResource;

@ApplicationPath("/webapi")
public class RestApplication  extends Application {
	
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(HelloResource.class); // Register resource
        resources.add(NotifyResource.class); // Register resource
        resources.add(UserResource.class); // Register resource
        return resources;
    }

}
