package my.example.view;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;
import my.example.model.Person;
import my.example.service.NameServiceable;

@Getter
@Setter
@Named
@ViewScoped
public class JsfBean  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Person person= new Person();
	
	private String fullName;
	
	@Inject
	private NameServiceable service;
	
	public String returnPage() {
		this.fullName = service.display(person);
		return "form-04-result";
	}
	
}
