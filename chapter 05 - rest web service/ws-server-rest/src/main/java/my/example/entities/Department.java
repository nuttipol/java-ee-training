package my.example.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement(name = "department") // for return Department
@XmlAccessorType(XmlAccessType.FIELD)
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
