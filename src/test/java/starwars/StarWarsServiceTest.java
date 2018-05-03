package starwars;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import starwars.controllers.StarWarsController;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = StarWarsServiceTestApplication.class)
@ActiveProfiles("test")
public class StarWarsServiceTest {

	@Autowired
	private StarWarsController starWarsController;

	@Test
	public void test_getCharacteristics() {
		Assert.assertTrue(starWarsController.getCharacteristics("luke").getName().equals("Luke Skywalker"));
	}

	// TODO: Finish creating tests
}
