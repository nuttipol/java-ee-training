package my.example.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
	
	public User() {
		super();
	}

	public User(int id, String name, Department department, List<Role> roles) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.roles = roles;
	}
	
	private int id;
	
	private String name;
	
	@XmlElement(name="department") // for User
	private Department department;
	
	@XmlElementWrapper(name="roles")
	@XmlElement(name="role")
	private List<Role> roles;

}
