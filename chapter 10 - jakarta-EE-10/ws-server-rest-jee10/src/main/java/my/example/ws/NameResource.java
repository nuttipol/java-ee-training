package my.example.ws;

import java.net.URISyntaxException;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import my.example.model.Person;
import my.example.model.Result;

 
@Path("/names")
@Slf4j
public class NameResource {
	
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response concat(@QueryParam("fname") String fname,@QueryParam("lname") String lname)  {
    	log.debug("concat entering");
    	if (fname == null || lname == null){
    		return Response.status(Response.Status.BAD_REQUEST).build();
    	}else{
    		return Response.ok().entity(new Result(fname.concat(" ").concat(lname))).build();
    	}
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response concat(Person person) throws  URISyntaxException {
    	log.debug("concat entering");
    	
    	if (person.getFirstName() == null || person.getLastName() == null){
    		return Response.status(Response.Status.BAD_REQUEST).build();
    	}else{
    		return Response.status(Response.Status.OK)
				.entity(new Result(person.getFirstName().concat(" ").concat(person.getLastName()))).build();
    	}
    }
}
