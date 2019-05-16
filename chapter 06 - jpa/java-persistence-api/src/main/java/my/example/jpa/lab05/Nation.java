package my.example.jpa.lab05;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name="nation")
@Data
@ToString(exclude="footballers")
@EqualsAndHashCode(of="id")
@NamedQueries({
    @NamedQuery(name = "Nation.findByName", query = "SELECT n FROM Nation n WHERE n.name = :name")})
public class Nation {
	
	public Nation(){
		
	}
	
	public Nation(String _name){
		this.name = _name;
	} 
	
	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	protected String name;
	
	@OneToMany(targetEntity=Footballer.class,
			cascade=CascadeType.ALL,mappedBy="nation")
    private List<Footballer> footballers;
 
}
