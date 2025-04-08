package my.example.chapter00.service;

import my.example.chapter00.model.Person;

public class NameService {
	public String display(Person person) {
		return person.getFirstName()
				.concat(" ")
				.concat(person.getLastName());
	}
}

	
