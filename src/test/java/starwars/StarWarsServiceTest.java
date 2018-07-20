package starwars;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import starwars.controllers.StarWarsController;
import starwars.exceptions.RestException;
import starwars.objects.CharacterDetails;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = StarWarsServiceTestApplication.class)
@ActiveProfiles("test")
public class StarWarsServiceTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	private MockMvc mockMvc;
	
	@Autowired
	private StarWarsController starWarsController;

	@Before
	public void setup() {

		this.mockMvc = MockMvcBuilders.standaloneSetup(starWarsController)
				.build();
	}

	@Test
	public void controller_getCharacteristics_notNull_anakin() {

		CharacterDetails characterDetails = starWarsController.getCharacterDetails("anakin");
		Assert.assertNotNull(characterDetails);
	}

	@Test
	public void controller_getCharacteristics_notNull_leia() {

		CharacterDetails characterDetails = starWarsController.getCharacterDetails("leia");
		Assert.assertNotNull(characterDetails);
	}

	@Test
	public void controller_getCharacteristics_notNull_luke() {

		CharacterDetails characterDetails = starWarsController.getCharacterDetails("luke");
		Assert.assertNotNull(characterDetails);
	}

	@Test/*(expected = RestException.class)*/
	public void controller_getCharacteristics_exception() {

		expectedException.expect(RestException.class);
		expectedException.expectMessage("Unknown character requested");
		starWarsController.getCharacterDetails("null");
	}

	@Test
	public void controller_getCharacteristics_testEnpoint200() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/starwars/character/anakin")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
}
