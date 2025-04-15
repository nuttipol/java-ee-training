package my.example.chapter04.view;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.annotation.PostConstruct;
import jakarta.faces.model.SelectItem;
import jakarta.faces.model.SelectItemGroup;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import my.example.chapter04.model.Continent;
import my.example.chapter04.service.EarthServiceable;

@Slf4j
@Getter
@Setter
@Named
@ViewScoped
public class SelectOneMenuView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String countryGroup;
	private List<SelectItem> countriesGroup;
	private List<Continent> continents;

	@Inject
	private EarthServiceable earthServiceable;
	
	@PostConstruct
	public void init() {

		continents = earthServiceable.listContinent();

		countriesGroup = continents.stream()
									.map(continents -> {
										SelectItemGroup group = new SelectItemGroup(continents.getName());
										group.setSelectItems(continents.getCountries().stream()
																						.map(country -> new SelectItem(country.getCode(), country.getName())).toArray(SelectItem[]::new));
										return group;
		}).collect(Collectors.toList());

	}
}
