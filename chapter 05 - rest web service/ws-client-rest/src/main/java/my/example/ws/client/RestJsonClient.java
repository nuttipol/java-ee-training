package my.example.ws.client;

import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import my.example.json.User;

public class RestJsonClient {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		Client client = ClientBuilder.newClient();
		WebTarget  webResource = client.target("http://localhost:8080/ws-server-rest/webapi/users/17");

		Response response = webResource
				.request(MediaType.APPLICATION_JSON)
				.get();

		ObjectMapper mapper = new ObjectMapper();
		
		System.out.println("response.getStatus()="+response.getStatus());
		
		if (response.getStatus() == 200) {
			User users = mapper.readValue((InputStream)response.getEntity() , User.class);
			System.out.println(users);
		}
	}

}
