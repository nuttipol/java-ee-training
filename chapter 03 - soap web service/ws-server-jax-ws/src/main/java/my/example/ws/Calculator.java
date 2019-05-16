package my.example.ws;

import java.math.BigDecimal;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface Calculator {

	@WebMethod(operationName = "add") 
	public BigDecimal add(BigDecimal a,BigDecimal b);
}
