package my.example.jpa.lab02;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="parent")
@Getter
@Setter
@ToString
public class Parent {

	@EmbeddedId
	private ParentId id;
	
	private String name;
 
}
