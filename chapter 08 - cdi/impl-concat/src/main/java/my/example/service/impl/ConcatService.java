package my.example.service.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import lombok.extern.slf4j.Slf4j;
import my.example.model.Person;
import my.example.service.NameServiceable;

@Slf4j
@ApplicationScoped
public class ConcatService implements NameServiceable,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String display(Person person) {
		log.info("String Concatenation by concat() method");
		return person.getFirstName()
				.concat(" ")
				.concat(person.getLastName());
	}
}

	
