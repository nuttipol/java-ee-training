package my.example.chapter02.data;

import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
public class Person {
 
	private String id;
	private String firstName;
	private String lastName;
	private Address homeAddress;
	
	public Person() {
		id = UUID.randomUUID().toString();
		homeAddress = new Address();
	}
	
}
