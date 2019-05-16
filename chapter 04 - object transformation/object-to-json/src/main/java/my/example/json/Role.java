package my.example.json;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Role {
	
	public Role() {
		super();
	}

	public Role(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	private int id;
	
	private String name;
}
