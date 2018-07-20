package starwars.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import starwars.objects.Details;
import starwars.utils.StarWarsMethods;
import starwars.utils.trim.annotation.TrimWhitespace;

@RestController
@RequestMapping("/starwars")
@Validated
public class StarWarsController {

	@GetMapping(value = "/character/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@TrimWhitespace
	public Details getCharacteristics(@PathVariable(value = "name") String name) {

		Details details;
		StarWarsMethods starWarsMethods = new StarWarsMethods();

		details = starWarsMethods.getCharacterDetails(name);

		return details;
	}
}
