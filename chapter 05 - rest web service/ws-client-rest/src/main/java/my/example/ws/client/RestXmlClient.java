package my.example.ws.client;

import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;

public class RestXmlClient {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws JAXBException 
	 */
	public static void main(String[] args) throws IOException, JAXBException {
		Client client = ClientBuilder.newClient();
		WebTarget  webResource = client.target("http://localhost:8080/ws-server-rest/webapi/users");

		Response response = webResource
				.request(MediaType.APPLICATION_XML)
				.get();

		if (response.getStatus() == 200) {
			System.out.println(response.readEntity(String.class));
		}
	}

}
