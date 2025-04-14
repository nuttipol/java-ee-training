package my.example.ws.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import lombok.extern.slf4j.Slf4j;
import my.example.dao.UserDao;
import my.example.data.Error;
import my.example.entities.User;


/**
 * 1. Use nouns but no verbs 
 * 3. Use plural nouns [/users]
 * 
 * @author Nuttipol
 * @see https://blog.mwaysolutions.com/2014/06/05/10-best-practices-for-better-restful-api/
 * @see https://blog.inslash.com/10-best-practices-for-better-restful-api-restful-api-checklist-1acfe1761f07
 * @see https://medium.com/hashmapinc/rest-good-practices-for-api-design-881439796dc9
 */
@Path("/users")
@Slf4j
public class UserResource {
	
	@Context
	private UriInfo uriInfo;
	
	@Inject
	private UserDao userDao;
	
	/**
	 * 7. Provide filtering, sorting, field selection and paging for collections [filter:name]
	 * 
	 * 7.1 filtering 
	 * - GET /users?name=xxx
	 * - GET /users?name<=xxx
	 * 
	 * 7.2 sorting
	 * - GET /users?sort=-name,+id,-userId
	 * 
	 * 7.3 field selection
	 * - GET /users?fields=userId,name
	 * 
	 * 7.4 paging
	 * - GET /users?offset=10&limit=5
	 * 
	 */
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response listUsers(@QueryParam("name") String name)  {
    	log.debug("listUsers entering");
    	List<User>  userList = new ArrayList<>();
    	
		if (name!=null){
			userList = userDao.findUsersByName(name);
		}else{
			userList = userDao.listUsers();
		}
		
    	//https://www.logicbig.com/tutorials/java-ee-tutorial/jax-rs/generic-entity.html
    	GenericEntity<List<User>> genericEntity = new GenericEntity<List<User>>(userList){}; 
    	
    	log.debug("userList.size() : {}",userList.size());
		return Response.ok().entity(genericEntity).build();
    }

    /**
     * 2. GET method and query parameters should not alter the state
	 * 5. Use HTTP headers for serialization formats [client call Accept for defines the response] 
     */
    @GET
    @Path("/{uid}")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response getUser(@PathParam("uid") String uid) {
    	User user =  userDao.getUser(uid);
    	if (user != null){
    		return Response.ok().entity(user).build();
    	}else{
    		return Response.status(Response.Status.NOT_FOUND).build();
    	}
    }
    
    /**
     * 4. Use sub-resources for relations [GET /user/1/departments/]
     */
    @GET
    @Path("/{uid}/departments")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response getDepartments(@PathParam("uid") String uid) {
    	User user =  userDao.getUser(uid);
    	if (user != null){
    		return Response.ok().entity(user.getDepartment()).build();
    	}else{
    		return Response.status(Response.Status.NOT_FOUND).build();
    	}
    }
    
    /**
     * 6. Use HATEOAS
     * @see  https://howtodoinjava.com/resteasy/hateoas-jaxrs20-uriinfo-uribuilder-link-examples/
     */
    @POST
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response addNewUser(User user) throws  URISyntaxException {
    	log.debug("addNewUser entering");
    	
		// check user == null  is not effect in this case.
    	if(user.getUid()!=null){
    		return Response.status(Response.Status.BAD_REQUEST).build();
    	}
    	
		User resUser = userDao.addUser(user);
		
		return Response.status(Response.Status.CREATED).location(new URI(uriInfo.getPath() + "/" + resUser.getUid())).build();
    }
    
    /**
     * 9. Handle Errors with HTTP status codes
     *  
     * 9.1 Use error payloads
     * @see https://code-maze.com/top-rest-api-best-practices/ 
     */
    @PUT
    @Path("/{uid}")
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response updateUser(@PathParam("uid") String uid, User user)  {
    	if (!uid.equals(user.getUid())){
    		return Response.status(Response.Status.BAD_REQUEST).entity(new Error("001", "UID is invalid")).build();
    	}
		
    	userDao.updateUser(user);
    	
		return Response.status(Response.Status.NO_CONTENT).build();
    }
     
    @DELETE
    @Path("/{uid}")
    public Response removeUser(@PathParam("uid") String uid) {
    	User user =  userDao.getUser(uid);
    	 
		if (user == null){
			return Response.status(Response.Status.NOT_FOUND).build();
		}else{
			userDao.deleteUser(uid);
			return Response.status(Response.Status.NO_CONTENT).build();
		}
    }
    
    /**
     * 8. Version your API
     * 
     * 8.1 URIs ('/v1.1/nav')	Facebook
     * 8.2 Media Type Header ('Accept:application/my.example.v2+json')
     * 8.3 Custom Header ('api-version: 2')
     * 8.4 Query String ('/user?v=1.1') Google
     * 
     * @see https://blog.finnomena.com/api-versioning-แบ่งเวอร์ชันให้-api-สำคัญไฉน-f4688af3066a
     */
}
