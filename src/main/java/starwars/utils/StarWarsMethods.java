package starwars.utils;

import org.springframework.http.HttpStatus;
import starwars.exceptions.RestException;
import starwars.objects.CharacterDetails;

import static starwars.data.Fields.*;

public class StarWarsMethods {

	public CharacterDetails getCharacterDetails(String characterName) {

		CharacterDetails characterDetails = new CharacterDetails();

		switch (characterName) {
			case ANAKIN:
				characterDetails.setName("Anakin Skywalker, aka Darth Vader	");
				characterDetails.setHeight("6 ft 2 in						");
				characterDetails.setWeight("196 lbs							");
				return characterDetails;
			case LEIA:
				characterDetails.setName("Princess Leia						");
				characterDetails.setHeight("5 ft 1 in						");
				characterDetails.setWeight("126 lbs							");
				return characterDetails;
			case LUKE:
				characterDetails.setName("Luke Skywalker					");
				characterDetails.setHeight("5 ft 6 in						");
				characterDetails.setWeight("161 lbs							");
				return characterDetails;
			default:
				throw new RestException(HttpStatus.BAD_REQUEST, "Unknown character requested");
		}
	}
}
