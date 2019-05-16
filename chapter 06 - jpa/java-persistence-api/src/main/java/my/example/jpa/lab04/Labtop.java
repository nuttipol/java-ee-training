package my.example.jpa.lab04;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity 
@Table(name="labtop")
@Data
@ToString(exclude="student")
@EqualsAndHashCode(of="id")
public class Labtop {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id")
	private int id;
	
	@Column(name="brand")
	private String brand;
	
	@OneToOne(mappedBy="computer")		// null on JPA
	private Student student;
	
	public Labtop(){
	}
	
	public Labtop(String _brand){
		this.brand = _brand;
	}
}
