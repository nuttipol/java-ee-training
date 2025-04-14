package my.example.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Person {
	
	private String id;
	private String firstName;
	private String lastName;
	
	public Person() {
		id = UUID.randomUUID().toString();
	}
	
}
