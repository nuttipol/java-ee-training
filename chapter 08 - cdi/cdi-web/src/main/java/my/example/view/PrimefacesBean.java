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
@Named("pfBean")
@ViewScoped
public class PrimefacesBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private NameServiceable service;
	
	private Person person= new Person();
	private String fullName;
	
	public void submitButtonOnClick() {
		this.fullName = service.display(person);
	}
 
}

