package my.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {

	public static void main(String[] args) throws IOException {
		
		URL url = new URL("http://localhost:8080/dynamic-web-project/myservlet/a/b;c=123?a=1&b=2");
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestProperty("Content-Type","plan/text");  

		conn.setUseCaches(false);
		conn.setDoInput(true);
		conn.setDoOutput(true);
		
		String str =  "data input";
		byte[] outputInBytes = str.getBytes("UTF-8");
		OutputStream os = conn.getOutputStream();
		os.write( outputInBytes );    
		os.close();

		
		System.out.println("Response Code: "+conn.getResponseCode());
		System.out.println("Response Message: "+conn.getResponseMessage());
		
		if (conn.getResponseCode() != 200) {
			System.out.println("Failed : HTTP error code : " + conn.getResponseCode());
		}else{
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
	
			String output;
			System.out.println("Body ...........................................................................................");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
		}
		conn.disconnect();
	}
}
