package infviewer.tree.controller;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.json.JSONException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import infviewer.constants.JSONConstants;

public class JSONParserTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception { }

	@AfterClass
	public static void tearDownAfterClass() throws Exception { }

	@Before
	public void setUp() throws Exception { } 

	@After
	public void tearDown() throws Exception { }

	@Test
	public void testParse() 
	{
		JSONParser parser = new JSONParser();
		JSONParser parserMock = mock(JSONParser.class);
		
		when(parserMock.getJSONForParsing(JSONConstants.SCHEMA_PATH_VALID)).thenReturn(JSONConstants.JSONOBJECT_VALID);
		when(parserMock.getJSONForParsing(JSONConstants.SCHEMA_PATH_INVALID1)).thenReturn(JSONConstants.JSONOBJECT_INVALID1);
		when(parserMock.getJSONForParsing(JSONConstants.SCHEMA_PATH_INVALID2)).thenReturn(JSONConstants.JSONOBJECT_INVALID2);
		when(parserMock.getJSONForParsing(JSONConstants.SCHEMA_NOT_FOUND)).thenReturn(null);
		
		//Ocekujemo da se valid sema u potpunosti poklopi sa ocekivanim izlazom
		assertEquals(JSONConstants.TESTING_PACKAGE, parser.parse(parserMock.getJSONForParsing(JSONConstants.SCHEMA_PATH_VALID)));
		
		//Ocekujemo da se invalid1 sema ne poklopi sa ocekivanim izlazom zbog toga sto se naziv glavnog paketa ne poklapa sa ocekivanim
		assertNotEquals(JSONConstants.TESTING_PACKAGE, parser.parse(parserMock.getJSONForParsing(JSONConstants.SCHEMA_PATH_INVALID1)));
		
		//Ocekujemo JSONException jer invalid2 sema u jednoj od tabela uopste nema kolona, sto po metasemi nije dozvoljeno
		try {
			parser.parse(parserMock.getJSONForParsing(JSONConstants.SCHEMA_PATH_INVALID2));						
		} catch (Exception e) {
			assertThat(e, anyOf(instanceOf(JSONException.class)));
		}
		
		//Ocekujemo NullPointerException jer sema not found ne postoji, a parser nema internu zastitu od ulaznog parametra sa null vrednoscu
		try {
			parser.parse(parserMock.getJSONForParsing(JSONConstants.SCHEMA_NOT_FOUND));						
		} catch (Exception e) {
			assertThat(e, anyOf(instanceOf(NullPointerException.class)));
		}
	}
	
	@Test
	public void testGetJSONForParsing() 
	{
		JSONParser parser = new JSONParser();
		
		assertNotNull(parser.getJSONForParsing(JSONConstants.SCHEMA_PATH_VALID));
		assertNotNull(parser.getJSONForParsing(JSONConstants.SCHEMA_PATH_INVALID1));
		assertNotNull(parser.getJSONForParsing(JSONConstants.SCHEMA_PATH_INVALID2));
		
		assertNull(parser.getJSONForParsing(JSONConstants.SCHEMA_NOT_FOUND));
		
		thrown.expect(anyOf(instanceOf(JSONException.class)));
		parser.getJSONForParsing(JSONConstants.SCHEMA_PATH_NOT_JSON);
	}
}