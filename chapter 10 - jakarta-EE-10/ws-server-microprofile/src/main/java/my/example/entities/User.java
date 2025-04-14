package my.example.entities;

import java.util.List;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD) 
public class User {
	
	public User() {
		super();
	}
	
	public User(String userId, String name, Department department, List<Role> roles) {
		super();
		this.userId = userId;
		this.name = name;
		this.department = department;
		this.roles = roles;
	}
	
	public User(String uid,String userId,  String name, Department department, List<Role> roles) {
		super();
		this.uid = uid;
		this.userId = userId;
		this.name = name;
		this.department = department;
		this.roles = roles;
	}
	
	private String uid;
	
	private String userId;
	
	private String name;
	
	@XmlElement(name="department") // for User
	private Department department;
	
	@XmlElementWrapper(name="roles")
	@XmlElement(name="role")
	@JsonbProperty("roles")
	private List<Role> roles;

}
