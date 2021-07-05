package my.example.ws;

import java.util.Date;

import lombok.Data;

@Data
public class Person {
	private int id;
	private String name;
	private Date birthDate;
}
