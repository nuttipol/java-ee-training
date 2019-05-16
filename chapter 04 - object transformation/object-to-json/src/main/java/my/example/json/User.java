package my.example.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "uid","name" })
public class User {
	
	public User() {
		super();
	}

	public User(int id, String name, Department department, List<Role> roles) {
		super();
		this.uid = id;
		this.name = name;
		this.department = department;
		this.roles = roles;
	}

	@JsonProperty("uid")
	private int uid;
	
	@JsonProperty("userId")
	private String userId;
	
	@JsonProperty("name")
	private String name;
	
	private Department department;
	
	private List<Role> roles;

}
