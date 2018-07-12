package starwars.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import starwars.objects.Details;
import starwars.utils.StarWarsMethods;
import starwars.utils.trim.annotation.TrimWhitespace;

@RestController
@RequestMapping("/starwars")
@Validated
public class StarWarsController {

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE,
			value = "/character/{name}")
	@ResponseStatus(HttpStatus.OK)
	@TrimWhitespace
	public Details getCharacteristics(@PathVariable(value = "name") String name) {

		Details details;
		StarWarsMethods starWarsMethods = new StarWarsMethods();

		details = starWarsMethods.getCharacterDetails(name);

		return details;
	}
}
