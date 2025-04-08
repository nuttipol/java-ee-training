package my.example.chapter02.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Member extends Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Address workAddress;
	private List<Children> childrens;
	private List<ContactPerson> contactPersons;
	
	public Member() {
		workAddress = new Address();
		childrens = new ArrayList<>();
		contactPersons = new ArrayList<>();
	}
}
