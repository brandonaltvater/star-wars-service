package starwars.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import starwars.mappers.StarWarsMapper;
import starwars.objects.CharacterDetails;
import starwars.utils.StarWarsMethods;
import starwars.utils.trim.annotation.TrimWhitespace;

@RestController
@RequestMapping("/starwars")
@Validated
public class StarWarsController {

	private final StarWarsMapper starWarsMapper;

	public StarWarsController(StarWarsMapper starWarsMapper) {
		this.starWarsMapper = starWarsMapper;
	}

	@GetMapping(value = "/character/{characterName}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@TrimWhitespace
	public CharacterDetails getCharacterDetails(@PathVariable(value = "characterName") String characterName) {

		CharacterDetails characterDetails;
		StarWarsMethods starWarsMethods = new StarWarsMethods();

		characterDetails = starWarsMethods.getCharacterDetails(characterName);

		return characterDetails;
	}

	@PutMapping(value = "/planet/{planetName}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void putPlanetDetails(@PathVariable(value = "planetName") String planetName,
								 @RequestBody() String postingOperatorId) {



		starWarsMapper.insertPlanetDetails(planetName, postingOperatorId);
	}
}
