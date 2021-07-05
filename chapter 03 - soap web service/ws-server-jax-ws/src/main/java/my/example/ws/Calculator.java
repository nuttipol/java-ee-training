package my.example.ws;

import java.math.BigDecimal;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface Calculator {

	@WebMethod(operationName = "add") 
	public BigDecimal add(BigDecimal a,BigDecimal b);
	
	@WebMethod(operationName = "create")
	public void create(Person p) ;
	
	@WebMethod(operationName = "update")
	public void update(Person p) ;
	
	@WebMethod(operationName = "search")
	public List<Person> search(String name) ;
	
	@WebMethod(operationName = "get")
	public Person get(int id);
	
	@WebMethod(operationName = "delete")
	public void delete(int id);
	
}
