package my.example.ws;

import java.net.URISyntaxException;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import my.example.dao.UserDao;
import my.example.entities.User;

@Slf4j
@Path("/notifies")
public class NotifyResource {

	@Inject
	private UserDao userDao;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addNotify(User user) throws  URISyntaxException {
    	log.debug("addNotify entering");
    	
		// check user == null  is not effect in this case.
    	if(user.getUid()!=null){
    		return Response.status(Response.Status.BAD_REQUEST).build();
    	}
    	
		User resUser = userDao.addUser(user);
		
		return Response.status(Response.Status.OK)
				.entity(resUser)
				.build();
    }
}