package my.example.chapter00.view;

import java.io.Serializable;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import my.example.chapter00.model.Person;
import my.example.chapter00.service.NameService;

@ViewScoped
@Named(value = "pfBean")
public class PrimefacesBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Person person= new Person();
	private NameService service = new NameService();
	private String fullName;
	private String contact;
	
	public void submitButtonOnClick() {
		this.fullName = service.display(person);
	}
	
	public void changeContact() {
		System.out.println("changeContact ....");
		System.out.println("contact="+contact);
		if (contact.equals("M")) {
			person.setPhone(null);
		}else {
			person.setEmail(null);
		}
	}

	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public String getFullName() {
		return this.fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
}

