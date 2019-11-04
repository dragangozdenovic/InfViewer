package infviewer.editor.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import infviewer.constants.JSONConstants;

public class JSONValidatorTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		JSONValidator jsonValidator = new JSONValidator();
		
		//Ocekujemo false na izlazu jer nije postavljena metasema u odnosu na koju treba vrsiti validaciju
		assertEquals(false, jsonValidator.validate(JSONConstants.JSONOBJECT_VALID));
		
		jsonValidator.setMetaSchema(JSONConstants.getMetaSchema());
		
		//Ocekujemo true na izlazu jer sada jeste postavljena metasema 
		assertEquals(true, jsonValidator.validate(JSONConstants.JSONOBJECT_VALID));
		
		//Ocekujemo false na izlazu jer jedna od tabela ne sadrzi nijednu kolonu, sto prema nasoj metasemi nije validno
		assertEquals(false, jsonValidator.validate(JSONConstants.JSONOBJECT_INVALID2));
		
		//Kada posaljemo null na ulazu, metoda vraca false, jer null vrednost smatra nevalidnom
		assertEquals(false, jsonValidator.validate(null));
		
		//Kada posaljemo objekat koji uopste nije odgovarajuceg tipa (JSONObject), validator to takodje smatra nevalidnim
		assertEquals(false, jsonValidator.validate(new String("OBJEKAT KOJI NIJE JSONObject")));
	}
}