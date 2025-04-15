package my.example.chapter04.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Continent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private List<Country> countries;
	
	public void add(Country country) {
		if (countries==null) {
			countries = new ArrayList<Country>();
		}
		countries.add(country);
	}
}
