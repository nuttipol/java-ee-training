package my.example.jpa.lab07;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name="privilege")
@Data
@ToString
@EqualsAndHashCode(of="id")
public class Privilege {

	public Privilege(){
		
	}
	
	public Privilege(String name){
		this.name = name;
	}
	
	@Id	
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="privilege_id")
	private int id;

	@Column(name="name",length=100)
	private String name;
 
}
