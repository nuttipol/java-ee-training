package my.example.ws;

import java.math.BigDecimal;
import java.util.List;

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

	@Override
	public void create(Person p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Person p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Person> search(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person get(int id) {
		Person p = new Person();
		p.setId(id);
		p.setName("A");
		return p;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
}
