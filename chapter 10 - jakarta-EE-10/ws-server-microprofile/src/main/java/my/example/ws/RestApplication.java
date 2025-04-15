package my.example.ws;

import java.util.HashSet;
import java.util.Set;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import my.example.ws.mp.ConfigResource;
import my.example.ws.mp.FaultToleranceResource;
import my.example.ws.mp.MetricsResource;
import my.example.ws.mp.OpenApiResource;
import my.example.ws.mp.SecureResource;
import my.example.ws.resources.HelloResource;
import my.example.ws.resources.NotifyResource;
import my.example.ws.resources.UserResource;

@ApplicationPath("/webapi")
public class RestApplication  extends Application {
	
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(HelloResource.class); 
        resources.add(NotifyResource.class); 
        resources.add(UserResource.class);  
        resources.add(ConfigResource.class); 
//        resources.add(AppHealthCheck.class); 
        resources.add(MetricsResource.class); 
        resources.add(SecureResource.class); 
        resources.add(FaultToleranceResource.class); 
        resources.add(OpenApiResource.class); 
        return resources;
    }

}
