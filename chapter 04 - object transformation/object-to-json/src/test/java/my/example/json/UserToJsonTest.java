package my.example.json;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import org.json.JSONException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import my.example.json.Department;
import my.example.json.Role;
import my.example.json.User;

/**
 *  
 * @author Nuttipol
 *
 */
public class UserToJsonTest {

	private User user;
	
	@Before
	public void setUp() {
	    user = new User(1,"Nuttipol",new Department(1, "SDD"),new ArrayList<>(Arrays.asList(new Role(1, "Admin"),new Role(2, "User"))));
	}
	
	@After
	public void tearDown() {
		user = null; 
	}
	
	@Test
	public void testObjectToJson() throws IOException, JSONException {
        ObjectMapper mapper = new ObjectMapper(); 
  
        String jsonStr = mapper.writeValueAsString(user); 
  
        System.out.println(jsonStr); 
        
        JSONAssert.assertEquals(new String(Files.readAllBytes(Paths.get("src/test/user.json"))), jsonStr,JSONCompareMode.LENIENT);
	}
	
	@Test
	public void testJsonToObject() throws JsonParseException, JsonMappingException, IOException  {
		ObjectMapper mapper = new ObjectMapper();

		User userTest = mapper.readValue(new String(Files.readAllBytes(Paths.get("src/test/user.json"))) , User.class);
		
		System.out.println(userTest.toString()); 
		
		Assert.assertEquals(user, userTest);
	}
}
