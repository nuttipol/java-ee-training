package my.example.jpa.lab06;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import my.example.jpa.lab03.Person;


@Entity
@Table(name="superhero")
@Data
@ToString(exclude="movies")
@EqualsAndHashCode(callSuper=true)
@NamedQueries({
    @NamedQuery(name = "SuperHero.findByName", query = "SELECT s FROM SuperHero s WHERE s.name = :name")})
public class SuperHero extends Person{
	
	@Column(name="hero_name",unique=true)
	private String heroName;

	@ManyToMany(mappedBy="superHeros")
	private List<Movie> movies;				//	NULL on JPA
	

	public SuperHero(){
		
	}
	
	public SuperHero(String _name,String _heroName){
		this.name = _name;
		this.heroName = _heroName;
	}
	
}
