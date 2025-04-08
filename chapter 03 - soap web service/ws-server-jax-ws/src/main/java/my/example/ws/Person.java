package my.example.ws;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
	private int id;
	private String name;
	private Date birthDate;
}
