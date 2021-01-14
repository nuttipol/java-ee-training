package my.example.view.df;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import lombok.Data;
import my.example.data.Person;

@RequestScoped
@ManagedBean
@Data 
public class PersonDialog {

	private Person person;
	
    @PostConstruct
    public void init() {
    	String data = FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("data1");
    	
    	person = new Person();
    	person.setFirstName(data);
    	
    }
     
	public void choosePerson() {
		FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> parameter = 
           fc.getExternalContext().getRequestParameterMap();
        
		Map<	String, Object> options = new HashMap<>();
		options.put("resizable", false);
		options.put("draggable", false);
		options.put("width", 640);
		options.put("height", 400);
		options.put("modal", true);
		 
		Map<String, List<String>> params = new HashMap<>();
	    params.put("data1", Arrays.asList(parameter.get("param1")));
	      
		PrimeFaces.current().dialog().openDynamic("add-person", options, params);
	}
	

	public void addPersonFromDialog() {
		PrimeFaces.current().dialog().closeDynamic(person);
	}
 
}
