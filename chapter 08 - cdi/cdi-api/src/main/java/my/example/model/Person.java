package my.example.model;

import java.util.UUID;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of="id")
public class Person {
	
	private String id;
	private String firstName;
	private String lastName;
	
	public Person() {
		id = UUID.randomUUID().toString();
	}
	
}
