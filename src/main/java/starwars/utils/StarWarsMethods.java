package starwars.utils;

import org.springframework.http.HttpStatus;
import starwars.exceptions.RestException;
import starwars.objects.Details;

import static starwars.utils.StarWarsConstants.*;

public class StarWarsMethods {

	public Details getCharacterDetails(String name) {

		Details details = new Details();

		switch (name) {
			case ANAKIN:
				details.setName("Anakin Skywalker, aka Darth Vader	");
				details.setHeight("6 ft 2 in						");
				details.setWeight("196 lbs							");
				return details;
			case LEIA:
				details.setName("Princess Leia						");
				details.setHeight("5 ft 1 in						");
				details.setWeight("126 lbs							");
				return details;
			case LUKE:
				details.setName("Luke Skywalker						");
				details.setHeight("5 ft 6 in						");
				details.setWeight("161 lbs							");
				return details;
			default:
				throw new RestException(HttpStatus.BAD_REQUEST, "Unknown character requested");
		}
	}
}
