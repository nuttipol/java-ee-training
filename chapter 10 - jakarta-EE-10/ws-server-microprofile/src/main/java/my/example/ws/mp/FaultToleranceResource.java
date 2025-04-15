package my.example.ws.mp;

import org.eclipse.microprofile.faulttolerance.Retry;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/fault")
public class FaultToleranceResource {

    private int counter = 0;

    @GET
    @Retry(maxRetries = 3)
    public String unstableEndpoint() {
        counter++;
        if (counter < 3) {
            throw new RuntimeException("Simulated failure");
        }
        return "Success after retries";
    }
}
