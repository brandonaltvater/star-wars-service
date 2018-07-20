package starwars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = {"classpath:${basedir}/application.properties"})
public class StarWarsService {

	public static void main(String[] args) {
		SpringApplication.run(StarWarsService.class, args);
	}
}
