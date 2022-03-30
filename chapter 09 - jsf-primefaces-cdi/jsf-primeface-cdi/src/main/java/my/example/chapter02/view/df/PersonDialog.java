package my.example.chapter02.view.df;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import lombok.Data;
import my.example.chapter02.data.Person;

@RequestScoped
@Named
@Data 
public class PersonDialog {

	private Person person;

	@Inject
    private ExternalContext externalContext;
	
	@PostConstruct
    public void init() {
    	String data = externalContext.getRequestParameterMap().get("data1");
    	
    	person = new Person();
    	person.setFirstName(data);
    	
    }
	

	public void addPersonFromDialog() {
		PrimeFaces.current().dialog().closeDynamic(person);
	}
 
}
