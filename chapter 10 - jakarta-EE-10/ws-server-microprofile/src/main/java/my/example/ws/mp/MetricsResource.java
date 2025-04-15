package my.example.ws.mp;

import org.eclipse.microprofile.metrics.annotation.Counted;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/metrics-demo")
public class MetricsResource {

    @GET
    @Counted(name = "helloRequests", description = "How many times hello was called")
    public String hello() {
        return "Hello from metrics!";
    }
}
