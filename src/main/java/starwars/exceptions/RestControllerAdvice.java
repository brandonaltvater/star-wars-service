package starwars.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import starwars.controllers.StarWarsController;

@ControllerAdvice(basePackageClasses = StarWarsController.class)
public class RestControllerAdvice {

	private RestControllerAdvice() {
		// Empty
	}

	@ExceptionHandler({RestException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public static ResponseEntity handleConnectionErrorResponse(RestException ex) {

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	}
}
