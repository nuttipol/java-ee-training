package my.example.jpa.lab06;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
//import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import my.example.jpa.lab08.MovieMapping;

@Entity
@Table(name="movie")
@Data
@ToString
@EqualsAndHashCode(of="id")
@NamedQueries({
    @NamedQuery(name = "Movie.findBySuperHero", query = "SELECT m FROM Movie m join m.superHeros s on s.name = :name")})
@SqlResultSetMapping(name = "NameMapping",  classes = {
	    @ConstructorResult(targetClass = MovieMapping.class, 
	    	    columns = {
	    	    		@ColumnResult(name="movieName"), 
	    	    		@ColumnResult(name="superHeroName")})
	    	})
public class Movie{
	
	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	protected String name;
	
	@ManyToMany
	@JoinTable(name="movie_superhero",
	        joinColumns=
	            @JoinColumn(name="movie_id" ),
	        inverseJoinColumns=
	            @JoinColumn(name="superhero_id" ))
	private List<SuperHero> superHeros;

	public void addSuperHero(SuperHero superHero){
		if (this.superHeros == null){
			this.superHeros = new ArrayList<SuperHero>();
		}
		this.superHeros.add(superHero);
	}
	
	public void removeSuperHero(SuperHero superHero){
		if (this.superHeros == null){
			this.superHeros = new ArrayList<SuperHero>();
		}

		if (this.superHeros.indexOf(superHero)>-1){
			this.superHeros.remove(this.superHeros.indexOf(superHero));
		}
	}
	
	public Movie(){
		
	}
	
	public Movie(String _name){
		this.name = _name;
	}  
	
}
