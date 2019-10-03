package my.example.view.df;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.PrimeFaces;

import lombok.Data;
import my.example.data.Person;

@ViewScoped
@ManagedBean
@Data
public class PersonDialog {

	private Person person;

    @PostConstruct
    public void init() {
    	person = new Person();
    }
     
	public void choosePerson() {
		Map<String, Object> options = new HashMap<>();
		options.put("resizable", false);
		options.put("draggable", false);
		options.put("width", 640);
		options.put("height", 400);
		options.put("modal", true);
		PrimeFaces.current().dialog().openDynamic("add-person", options, null);
	}
	

	public void addPersonFromDialog() {
		PrimeFaces.current().dialog().closeDynamic(person);
	}
 
}
