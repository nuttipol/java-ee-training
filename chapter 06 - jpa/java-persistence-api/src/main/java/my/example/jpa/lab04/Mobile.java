package my.example.jpa.lab04;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity 
@Table(name="mobile")
@Data
@ToString
@EqualsAndHashCode(of="id")
public class Mobile {
	@Id 
	@Column(name="id")
	private int id;
	
	@Column(name="brand")
	private String brand;

	public Mobile(){
	}
	
	public Mobile(String _brand){
		this.brand = _brand;
	}
	 

}
