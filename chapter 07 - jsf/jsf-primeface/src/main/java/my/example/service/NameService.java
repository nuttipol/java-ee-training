package my.example.service;

import my.example.model.Person;

public class NameService {
	public String display(Person person) {
		return person.getFirstName()
				.concat(" ")
				.concat(person.getLastName());
	}
}

	
