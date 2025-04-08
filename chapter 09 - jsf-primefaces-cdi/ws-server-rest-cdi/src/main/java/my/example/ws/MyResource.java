package my.example.ws;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import lombok.extern.slf4j.Slf4j;
import my.example.dao.UserDao;

@Slf4j
@Path("/myresource")
public class MyResource {

	@Inject
	private UserDao userDao;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		try {
			log.debug("userDao : {}",userDao);
			
			ClientConfig clientConfig= new ClientConfig();
			Client client = ClientBuilder.newClient(clientConfig);
			WebTarget webTarget = client.target(
					"https://virtserver.swaggerhub.com/nuttipol/itp_x_lw_rs/1.0.0/resources/getBatchInformation2/pitpos/bln/%E0%B8%A0%E0%B8%87%E0%B8%9491010010100100101011125650622010006");

			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response response = invocationBuilder.get();

			if (response.getStatus() == 200) {
				return response.readEntity(String.class);
			} else {
				return "";
			}
		} catch (Exception e) {
			log.error("Exception ...", e);
			return "Exception";
		}
	}
}