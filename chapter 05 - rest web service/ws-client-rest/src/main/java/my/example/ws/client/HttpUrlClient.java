package my.example.ws.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
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
				System.out.print("Failed : HTTP error code : " + conn.getResponseCode());
				return;
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
