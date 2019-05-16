package my.example.jpa.lab02;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name="parent")
@Data
@ToString
public class Parent {

	@EmbeddedId
	private ParentId id;
	
	private String name;
 
}
