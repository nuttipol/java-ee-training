package my.example.json;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Department {
	 
	public Department() {
		super();
	}

	public Department(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	private int id;
	
	private String name;
}
