package my.example.jpa.lab05;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name="agent")
@Data
@ToString(exclude="footballers")
@EqualsAndHashCode(of="id")
public class Agent {
	
	public Agent(){
		
	}
	
	public Agent(String _name){
		this.name = _name;
	} 
	
	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	protected String name;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinTable(name="agent_footballer",
		joinColumns={@JoinColumn(name="agent_id")},
		inverseJoinColumns={@JoinColumn(name="footballer_id")})
    private List<Footballer> footballers;

	public void addFootballer(Footballer footballer){
		if (this.footballers == null){
			this.footballers = new ArrayList<Footballer>();
		}
		this.footballers.add(footballer);
	}
	
	public void removeFootballer(Footballer footballer){
		if (this.footballers == null){
			this.footballers = new ArrayList<Footballer>();
		}
		
		if (this.footballers.indexOf(footballer)>-1){
			this.footballers.remove(this.footballers.indexOf(footballer));
		}
	}
	 
}
