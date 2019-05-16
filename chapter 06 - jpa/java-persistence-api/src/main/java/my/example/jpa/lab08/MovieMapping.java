package my.example.jpa.lab08;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MovieMapping {

	public MovieMapping(String movieName, String superHeroName) {
		super();
		this.movieName = movieName;
		this.superHeroName = superHeroName;
	}

	private String movieName;
	private String superHeroName;
 
}
