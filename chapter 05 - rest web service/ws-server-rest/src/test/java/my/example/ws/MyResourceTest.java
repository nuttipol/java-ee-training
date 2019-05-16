package my.example.ws;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import my.example.entities.Department;
import my.example.entities.Role;
import my.example.entities.User;

@Slf4j
public class MyResourceTest {
	 
    private HttpServer server;
    private WebTarget target;
 
    @Before
    public void setUp() throws Exception {
        server = Main.startServer();
 
        Client c = ClientBuilder.newClient();
        
       log.info("BASE_URI : {}",Main.BASE_URI);
        target = c.target(Main.BASE_URI);
    }
 
	@After
    public void tearDown() throws Exception {
        server.shutdown();
    }
	
//	@Test
	public void testGetIt() {
        String responseMsg = target.path("myresource").request().get(String.class);
        assertEquals("Got it!", responseMsg);
    }
    
    @Test
    public void testListUsers() {
    	log.trace("testListUsers===================================================");
    	String responseMsg = target.path("users").request().get(String.class);
        log.debug("undefined={}",responseMsg);
    	responseMsg = target.path("users").request(MediaType.APPLICATION_JSON).get(String.class);
        log.debug("json={}",responseMsg);
        responseMsg = target.path("users").request(MediaType.APPLICATION_XML).get(String.class);
        log.debug("xml={}",responseMsg);
    }
    
    @Test
    public void testAddUser() throws IOException {
    	log.trace("testAddUser===================================================");
    	User user = new User("nuttipol.ch","Nuttipol",new Department(2, "dep2"),new ArrayList<>(Arrays.asList(new Role(3, "role3"))));
    	
    	String usrString = new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(user);
    	log.debug("user = {}",usrString);
    	
        Response response = target.path("users")
        		.request()
        		.post(Entity.json(usrString));
        
        log.debug("response status = {}",response.getStatus());
        log.debug("response location = {}",response.getLocation()); 
        
        response =  target.path(response.getLocation().getPath().substring(7))
        			.request().accept(MediaType.APPLICATION_JSON).get();
        
        log.debug("response status={}",response.getStatus());
        log.debug("json={}",response.readEntity(String.class));
    }

    @Test
    public void testUpdateUser() throws IOException {
    	log.trace("testUpdateUser===================================================");
    	User user = new User("1","nuttipol.ch","Nuttipol",new Department(2, "dep2"),new ArrayList<>(Arrays.asList(new Role(3, "role3"))));
    	
    	String usrString = new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(user);
    	log.debug("user = {}",usrString);
    	
        Response response = target.path("users/1")
        		.request()
        		.put(Entity.json(usrString));

        log.debug("response status={}",response.getStatus());

        response =  target.path("users/1").request().accept(MediaType.APPLICATION_JSON).get();
        
        log.debug("response status={}",response.getStatus());
        log.debug("json={}",response.readEntity(String.class));
    }
    
    @Test
    public void testGetUser() throws IOException {
    	log.trace("testGetUser===================================================");
    	User user = new User("2","nuttipol.ch","Nuttipol",new Department(2, "dep2"),new ArrayList<>(Arrays.asList(new Role(3, "role3"))));
    	
    	String usrString = new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(user);
    	log.debug("user = {}",usrString);
    	
        Response response = target.path("users/2")
        		.request() 
        		.put(Entity.json(usrString));
        
        log.debug("response put status={}",response.getStatus());
        
        response = target.path("users/2").request().accept(MediaType.APPLICATION_XML).get();
		
        log.debug("response get status={}",response.getStatus());
        log.debug("xml={}",response.readEntity(String.class));

    }
    
    @Test
    public void testDeleteUser() throws IOException, JAXBException {
    	log.trace("testDeleteUser===================================================");
    	User user = new User("3","nuttipol.ch","Nuttipol",new Department(3, "dep3"),new ArrayList<>(Arrays.asList(new Role(3, "role3"))));
    	
//    	String usrString = new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(user);
    	
    	ByteArrayOutputStream userBaos = new ByteArrayOutputStream();
	    JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
	    Marshaller marshaller = jaxbContext.createMarshaller();
	    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
   	    marshaller.marshal(user, userBaos);
    	String usrString = userBaos.toString();
    	
    	log.debug("user = {}",usrString);
    	
        Response response = target.path("users/3")
        		.request() 
        		.put(Entity.xml(usrString));
        
        log.debug("response status={}",response.getStatus());
 
        
        response = target.path("users/3").request().delete();
        log.debug("response status={}",response.getStatus());
        
        response = target.path("users/3").request().get();
        log.debug("response status={}",response.getStatus());
        
    }
     
}