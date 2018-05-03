package starwars.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import starwars.exceptions.RestException;
import starwars.objects.Characteristics;

@RestController
@RequestMapping("/starwars")
public class StarWarsController {

	private static final String DARTH_VADER = "darthvader";
	private static final String LEIA = "leia";
	private static final String LUKE = "luke";

	@RequestMapping(value = "/character/{name}")
	public Characteristics getCharacteristics(@PathVariable(value = "name") String name) {

		Characteristics characteristics;
		characteristics = getValues(name);
		return characteristics;
	}

	private Characteristics getValues(String name) {

		Characteristics characteristics = new Characteristics();

		switch (name) {
			case DARTH_VADER:
				characteristics.setName("Anakin Skywalker");
				characteristics.setHeight("6 ft 2 in");
				characteristics.setWeight("196 lbs");
				return characteristics;
			case LEIA:
				characteristics.setName("Princess Leia");
				characteristics.setHeight("5 ft 1 in");
				characteristics.setWeight("126 lbs");
				return characteristics;
			case LUKE:
				characteristics.setName("Luke Skywalker");
				characteristics.setHeight("5 ft 6 in");
				characteristics.setWeight("161 lbs");
				return characteristics;
			default:
				throw new RestException(HttpStatus.INTERNAL_SERVER_ERROR, "Unknown character requested");
		}
	}
}
