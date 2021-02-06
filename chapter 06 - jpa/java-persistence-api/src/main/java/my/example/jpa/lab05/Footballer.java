package my.example.jpa.lab05;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import my.example.jpa.lab03.Person;


@Entity 
@Table(name="footballer")
@Data
@ToString
@EqualsAndHashCode(callSuper=true)
@NamedQueries({
    @NamedQuery(name = "Footballer.findByNumber", query = "SELECT f FROM Footballer f WHERE f.number = :numberId")})
public class Footballer extends Person {
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Footballer(){
		
	}
	
	public Footballer(int _number,String _name){
		this.name = _name;
		this.number = _number;
	} 

	@Column(name="number",unique=true)
	private int number;
	
	@ManyToOne
	@JoinColumn(name="nation_id",nullable=false)
	private Nation nation;

	@ManyToOne
	private Agent agent;
 
}
