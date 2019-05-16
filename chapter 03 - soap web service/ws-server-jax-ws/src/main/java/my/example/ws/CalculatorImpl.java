package my.example.ws;

import java.math.BigDecimal;

import javax.jws.WebService;

@WebService(serviceName = "CalculatorService", 
portName = "CalculatorPort", 
targetNamespace = "http://ws.summitthai.com/", 
endpointInterface = "my.example.ws.Calculator")
public class CalculatorImpl implements Calculator {

	@Override
	public BigDecimal add(BigDecimal a,BigDecimal b){
		return a.add(b);
	}
}
