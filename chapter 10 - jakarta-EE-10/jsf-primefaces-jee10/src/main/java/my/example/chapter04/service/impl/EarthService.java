package my.example.chapter04.service.impl;

import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import my.example.chapter04.model.Continent;
import my.example.chapter04.model.Country;
import my.example.chapter04.service.EarthServiceable;

@ApplicationScoped
public class EarthService implements EarthServiceable {

	@Override
	public List<Continent> listContinent() {
		List<Continent> continents = new ArrayList<>();
		Continent europe = Continent.builder().name("europe").build();
		europe.add(Country.builder().code("GER").name("Germany").build());
		europe.add(Country.builder().code("FRA").name("France").build());
		europe.add(Country.builder().code("ESP").name("Spain").build());
		europe.add(Country.builder().code("TUR").name("Turkey").build());

		Continent america = Continent.builder().name("america").build();
		america.add(Country.builder().code("US").name("United States").build());
		america.add(Country.builder().code("CAN").name("Canada").build());
		america.add(Country.builder().code("MEX").name("Mexico").build());

		continents.add(europe);
		continents.add(america);
		return continents;
	}

}
