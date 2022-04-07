package my.example.entities;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
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
	@JsonProperty("roles")
	private List<Role> roles;

}
