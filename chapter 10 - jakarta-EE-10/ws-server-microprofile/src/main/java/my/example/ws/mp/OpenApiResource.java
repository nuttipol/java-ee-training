package my.example.ws.mp;

import org.eclipse.microprofile.openapi.annotations.Operation;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/api-docs-demo")
public class OpenApiResource {

    @GET
    @Operation(summary = "Simple API", description = "Returns a simple message")
    public String message() {
        return "This is documented!";
    }
}
