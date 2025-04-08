package my.example.chapter02.view.df;

import org.primefaces.PrimeFaces;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
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
