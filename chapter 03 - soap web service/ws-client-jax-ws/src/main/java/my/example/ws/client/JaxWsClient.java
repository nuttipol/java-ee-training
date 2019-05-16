package my.example.ws.client;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import my.example.ws.client.jaxws.Calculator;
 

public class JaxWsClient {
	
/**
 * C:\Program Files\Java\jdk1.8.0_101\bin>wsimport -keep -p my.example.ws.client.jaxws -d C:/dev/workspaces/trainning/Eclipse/ws-client-jax-ws/src/main/java http://localhost:8080/ws-server-jax-ws/Calculator?wsdl
 * C:\Program Files\Java\jdk1.8.0_101\bin>wsimport -keep -p my.example.ws.client.axis -d C:/dev/workspaces/trainning/Eclipse/ws-client-jax-ws/src/main/java http://localhost:8080/ws-server-axis/services/Calculator?wsdl
 * @param args
 */
	public static void main(String[] args) {
		String endPoint = "http://localhost:8080/ws-server-jax-ws/Calculator?wsdl";
		URL url;
		try {
			url = new URL(endPoint);
			
//			code for jaxws 
			QName qName = new QName("http://my.example.com/", "CalculatorService");
	        Service service = Service.create(url, qName);
	        Calculator hello = service.getPort(Calculator.class);
			
	        System.out.println("2 + 3 = "+hello.add(new BigDecimal("2"), new BigDecimal("3")));

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}


	}
}
