package my.example.jpa.lab04;

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
@Table(name="locker")
@Data
@ToString
@EqualsAndHashCode(of="id")
public class Locker {
	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id")
	private int id;
	
	@Column(name="location")
	private String location;

	public Locker(){
	}
	
	public Locker(String _location){
		this.location = _location;
	}

}
