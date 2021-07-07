package my.example.ws.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpUrlClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			URL url = new URL("http://localhost:8080/ws-server-rest/webapi/users");
//			URL url = new URL("http://localhost:8080/ws-server-rest/webapi/users/nuttipol");
//			URL url = new URL("https://api.fifa.com/api/v1/picture/flags-fwc2018-4/rus");

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			String a = "[{\"uid\":\"58\",\"userId\":null,\"name\":\"Nuttipol\",\"department\":{\"id\":1,\"name\":\"SDD\"},\"roles\":[{\"id\":1,\"name\":\"Admin\"},{\"id\":2,\"name\":\"User\"}]},{\"uid\":\"36\",\"userId\":null,\"name\":\"Su\",\"department\":{\"id\":1,\"name\":\"SDD\"},\"roles\":[{\"id\":2,\"name\":\"User\"}]},{\"uid\":\"92\",\"userId\":null,\"name\":\"Kong\",\"department\":{\"id\":1,\"name\":\"SDD\"},\"roles\":[{\"id\":2,\"name\":\"User\"}]}]";
			conn.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
