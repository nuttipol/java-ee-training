package my.example.ws.mp;

import org.eclipse.microprofile.jwt.Claim;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/secure")
public class SecureResource {

    @Claim("preferred_username")
    String username;

    @GET
    @RolesAllowed("user")
    public String securedHello() {
        return "Hello " + username + ", you are authenticated.";
    }
}
