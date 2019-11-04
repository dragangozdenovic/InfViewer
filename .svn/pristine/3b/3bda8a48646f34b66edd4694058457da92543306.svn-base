package infviewer.workspace.miscellaneous;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import infviewer.constants.SQLGeneratorConstants;

public class SQLGeneratorTest {
    
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
    public void testSelect() {
        //ocekujemo da se select upit potpuno poklapa sa ocekivanim izlazom
        assertEquals(SQLGeneratorConstants.SELECT_STATEMENT, SQLGenerator.selectQuery(SQLGeneratorConstants.TABLE_NAME, SQLGeneratorConstants.VALID_TEST_MAP));
        //ocekujemo da se select upit ne poklapa sa ocekivanim izlazom jer prosledjena hashmapa nije validna(nedostaju nazivi i vrednosti obelezja)
        assertNotEquals(SQLGeneratorConstants.SELECT_STATEMENT, SQLGenerator.selectQuery(SQLGeneratorConstants.TABLE_NAME, SQLGeneratorConstants.INVALID_TEST_MAP1));
        //ocekujemo da se select upit ne poklapa sa ocekivanim izlazom jer prosledjena hashmapa nije validna(pomesan redosled parova naziva i vrednosti obelezja)
        assertNotEquals(SQLGeneratorConstants.SELECT_STATEMENT, SQLGenerator.selectQuery(SQLGeneratorConstants.TABLE_NAME, SQLGeneratorConstants.INVALID_TEST_MAP2));
        //ocekujemo da se select upit ne poklapa sa ocekivanim izlazom jer prosledjena hashmapa nije validna(pogresne vrednosti obelezja)
        assertNotEquals(SQLGeneratorConstants.SELECT_STATEMENT, SQLGenerator.selectQuery(SQLGeneratorConstants.TABLE_NAME, SQLGeneratorConstants.INVALID_TEST_MAP3));
    }
    
    @Test
    public void testInsert() {
        //ocekujemo da se insert upit potpuno poklapa sa ocekivanim izlazom
        assertEquals(SQLGeneratorConstants.INSERT_STATEMENT, SQLGenerator.insert(SQLGeneratorConstants.VALID_TEST_TABLE));
        //ocekujemo da se select upit ne poklapa sa ocekivanim izlazom jer prosledjena tabela nije validna(pogresan naziv tabele)
        assertNotEquals(SQLGeneratorConstants.INSERT_STATEMENT, SQLGenerator.insert(SQLGeneratorConstants.INVALID_TEST_TABLE1));
        //ocekujemo da se select upit ne poklapa sa ocekivanim izlazom jer prosledjena tabela nije validna(nedostaju kolone u tabeli)
        assertNotEquals(SQLGeneratorConstants.INSERT_STATEMENT, SQLGenerator.insert(SQLGeneratorConstants.INVALID_TEST_TABLE2));
    }
    
    @Test
    public void testUpdate() {
        //ocekujemo da se update upit potpuno poklapa sa ocekivanim izlazom
        assertEquals(SQLGeneratorConstants.UPDATE_STATEMENT, SQLGenerator.update(SQLGeneratorConstants.VALID_TEST_TABLE).toString());
        //ocekujemo da se update upit ne poklapa sa ocekivanim izlazom jer prosledjena tabela nije validna(pogresan naziv tabele)
        assertNotEquals(SQLGeneratorConstants.UPDATE_STATEMENT, SQLGenerator.update(SQLGeneratorConstants.INVALID_TEST_TABLE1).toString());
        //ocekujemo da se update upit ne poklapa sa ocekivanim izlazom jer prosledjena tabela nije validna(nedostaju kolone u tabeli)
        assertNotEquals(SQLGeneratorConstants.UPDATE_STATEMENT, SQLGenerator.update(SQLGeneratorConstants.INVALID_TEST_TABLE2).toString());
    }
    
    @Test
    public void testDelete() {//
        //ocekujemo da se delete upit potpuno poklapa sa ocekivanim izlazom
        assertEquals(SQLGeneratorConstants.DELETE_STATEMENT, SQLGenerator.delete(SQLGeneratorConstants.VALID_TEST_TABLE, SQLGeneratorConstants.VALID_TEST_ROW));
        //ocekujemo da se delete upit ne poklapa sa ocekivanim izlazom jer prosledjen red nije validan(nedostaju polja)
        assertNotEquals(SQLGeneratorConstants.DELETE_STATEMENT, SQLGenerator.delete(SQLGeneratorConstants.VALID_TEST_TABLE, SQLGeneratorConstants.INVALID_TEST_ROW));
        //ocekujemo da se update upit ne poklapa sa ocekivanim izlazom jer je prosledjena pogresna tabela
        assertNotEquals(SQLGeneratorConstants.DELETE_STATEMENT, SQLGenerator.delete(SQLGeneratorConstants.INVALID_TEST_TABLE3, SQLGeneratorConstants.VALID_TEST_ROW).toString());
    }
    
    @Test
    public void testSearch() {
        //ocekujemo da se search upit potpuno poklapa sa ocekivanim izlazom
        assertEquals(SQLGeneratorConstants.SEARCH_STATEMENT, SQLGenerator.search(SQLGeneratorConstants.VALID_TEST_TABLE, SQLGeneratorConstants.VALID_LIST_DIALOG_ELEMENTS));
        //ocekujemo da se search upit ne poklapa sa ocekivanim izlazom jer prosledjena tabela nije odgovarajuca
        assertNotEquals(SQLGeneratorConstants.SEARCH_STATEMENT, SQLGenerator.search(SQLGeneratorConstants.INVALID_TEST_TABLE3, SQLGeneratorConstants.VALID_LIST_DIALOG_ELEMENTS));
    }

}
