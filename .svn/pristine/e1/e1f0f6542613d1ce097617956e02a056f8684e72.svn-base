package infviewer.workspace.controller;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import infviewer.constants.RDBCRUDConstants;
import infviewer.database.DBConnection;
import infviewer.tree.model.Table;
import infviewer.workspace.miscellaneous.SQLGenerator;
import infviewer.workspace.model.Row;
import infviewer.workspace.view.DialogElementInterface;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "infviewer.*")
public class RDBCRUDTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		//initialise();
	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreate() {

		RDBCRUD rdbCrud = new RDBCRUD();
		
		mockStatic(SQLGenerator.class);
	    when(SQLGenerator.insert(RDBCRUDConstants.testingTable())).thenReturn("INSERT INTO STANICA (OZNAKA_STANICE, NAZIV, E_MAIL, BROJ_TELEFONA) VALUES (?, ?, ?,?);");
		
		mockStatic(DBConnection.class);
		DBConnection mockDB = mock(DBConnection.class);
		
		try {
			when(mockDB.getConnection()).thenReturn(DriverManager.getConnection("jdbc:jtds:sqlserver://"+"147.91.175.155"+"/"+"psw-2018-tim9-1", "psw-2018-tim9-1", "tim9-16273409"));
		} catch (SQLException e) {
			fail("Not yet implemented");
		}
		
		when(DBConnection.getInstance()).thenReturn(mockDB);

		
		//testiranje dodavanja validnog reda u tabelu
		assertTrue(rdbCrud.create(RDBCRUDConstants.getStation1ToCreate(), RDBCRUDConstants.testingTable()));
        
		//testiranje bacanja izuzetkaza dodavanje u tabelu reda koji vec postoji
		try {
			rdbCrud.create(RDBCRUDConstants.getStation1ToCreate(), RDBCRUDConstants.testingTable());
		} catch (Exception e) {
			assertThat(e, anyOf(instanceOf(SQLException.class)));
		}
		
		//testiranje bacanje izuzetka za dodavanje reda u tabelu koji ne odgovara semi relacije
		try {
			rdbCrud.create(RDBCRUDConstants.getIncompatibleRow(), RDBCRUDConstants.testingTable());
		} catch (Exception e) {
			assertThat(e, anyOf(instanceOf(SQLException.class)));
		}
		
	}

	@Test
	public void testUpdate() {
		
		RDBCRUD rdbCrud = new RDBCRUD();
		Row r = RDBCRUDConstants.getStationToUpdate();
		Row r2 = RDBCRUDConstants.getStationNotExisting();
		Table t = RDBCRUDConstants.testingTable();

		mockStatic(SQLGenerator.class);
	    when(SQLGenerator.update(t))
	    .thenReturn(new StringBuilder("UPDATE STANICA SET OZNAKA_STANICE = ?, NAZIV = ?, E_MAIL = ?, BROJ_TELEFONA = ? WHERE OZNAKA_STANICE = ?;"));
		
	    when(SQLGenerator.update(t))
	    .thenReturn(new StringBuilder("UPDATE STANICA SET OZNAKA_STANICE = ?, NAZIV = ?, E_MAIL = ?, BROJ_TELEFONA = ? WHERE OZNAKA_STANICE = ?;"));
	    
		mockStatic(DBConnection.class);
		DBConnection mockDB = mock(DBConnection.class);
		
		try {
			when(mockDB.getConnection()).thenReturn(DriverManager.getConnection("jdbc:jtds:sqlserver://"+"147.91.175.155"+"/"+"psw-2018-tim9-1", "psw-2018-tim9-1", "tim9-16273409"));
		} catch (SQLException e) {
			fail("Not yet implemented");
		}
		
		when(DBConnection.getInstance()).thenReturn(mockDB);
		
		//testiranje update reda koji vec postoji u bazi
		assertTrue(rdbCrud.update(r,t));
		
		//testiranje update reda koji ne postoji u bazi
		try {
			rdbCrud.update(r2, RDBCRUDConstants.testingTable());
		} catch (Exception e) {
			assertThat(e, anyOf(instanceOf(SQLException.class)));
		}
        
	}

	@Test
	public void testRead() {  

		RDBCRUD rdbCrud = new RDBCRUD();
		Row r = RDBCRUDConstants.getStationToRead();
		Row r2 = RDBCRUDConstants.getStationNotExisting();
		Table t = RDBCRUDConstants.testingTable();

		List<Row> expectedReturn = new ArrayList<Row>();
		expectedReturn.add(r);
		
		HashMap<String,Object> key = new HashMap<String,Object>();
		key.put("OZNAKA_STANICE", 39);
		
		HashMap<String,Object> key2 = new HashMap<String,Object>();
		key.put("OZNAKA_STANICE", 35);

		mockStatic(SQLGenerator.class);
	    when(SQLGenerator.selectQuery(t.getName(),key)).thenReturn("SELECT * FROM STANICA WHERE OZNAKA_STANICE = 39;");
	    when(SQLGenerator.selectQuery(t.getName(),key2)).thenReturn("SELECT * FROM STANICA WHERE OZNAKA_STANICE = 35;");
		
	    
		mockStatic(DBConnection.class);
		DBConnection mockDB = mock(DBConnection.class);
		
		try {
			when(mockDB.getConnection()).thenReturn(DriverManager.getConnection("jdbc:jtds:sqlserver://"+"147.91.175.155"+"/"+"psw-2018-tim9-1", "psw-2018-tim9-1", "tim9-16273409"));
		} catch (SQLException e) {
			fail("Not yet implemented");
		}
		
		when(DBConnection.getInstance()).thenReturn(mockDB);
		
		//testiranje citanja reda koji postoji u bazi, prosledjivanjem kljuca
		List<Row> returnedList = rdbCrud.read(t, key);
		boolean allGood = true;
		
		if(returnedList.size() != expectedReturn.size()) {
			fail("fail");
		} else {
			for(int i = 0 ; i < returnedList.size() ; i++) { //za svaki red
				for(int j = 0 ; j < returnedList.get(i).getFields().size() ; j++) { //za svako polje
					if(t.getColumns().get(j).isPrimaryKey()) {
						
						System.out.println("1");
						if(!returnedList.get(i).getFields().get(j).equals(expectedReturn.get(i).getFields().get(j))) {
							allGood = false;
						}
					
					}
					
				}
			}
		}
	
		assertTrue(allGood);
		
		//testiranje bacanja exceptiona koda citanja reda koji ne postoji u bazi
		try {
			List<Row> returnedList2 = rdbCrud.read(t, key2);
		} catch (Exception e) {
			assertThat(e, anyOf(instanceOf(SQLException.class)));
		}
	}

	@Test
	public void testDelete() {

		RDBCRUD rdbCrud = new RDBCRUD();

		mockStatic(SQLGenerator.class);
		Row r = RDBCRUDConstants.getStationToDelete();
		Row r2 = RDBCRUDConstants.getStationNotExisting();
		Table t = RDBCRUDConstants.testingTable();
	    
		when(SQLGenerator.delete(t,r)  )
	    .thenReturn("DELETE FROM STANICA WHERE OZNAKA_STANICE = 55");
		when(SQLGenerator.delete(t,r2)  )
	    .thenReturn("DELETE FROM STANICA WHERE OZNAKA_STANICE = 35");
		
		mockStatic(DBConnection.class);
		DBConnection mockDB = mock(DBConnection.class);
		
		try {
			when(mockDB.getConnection()).thenReturn(DriverManager.getConnection("jdbc:jtds:sqlserver://"+"147.91.175.155"+"/"+"psw-2018-tim9-1", "psw-2018-tim9-1", "tim9-16273409"));
		} catch (SQLException e) {
			fail("Not yet implemented");
		}
		
		when(DBConnection.getInstance()).thenReturn(mockDB);
		
		//testiranje brisanja reda koji postoji u bazi
		assertTrue(rdbCrud.delete(r, t));
		
		//testiranje brisanja reda koji ne postoji u bazi
		try {
			boolean success = rdbCrud.delete(r2,t);
		} catch (Exception e) {
			assertThat(e, anyOf(instanceOf(SQLException.class)));
		}
	}

	@Test
	public void testSearch() {

		RDBCRUD rdbCrud = new RDBCRUD();

		Row r = RDBCRUDConstants.getStationToRead();
		Table t = RDBCRUDConstants.testingTable();

		List<Row> expectedReturn = new ArrayList<Row>();
		expectedReturn.add(r);
		
		List<DialogElementInterface> zaKljuc = new ArrayList<>();
		List<List<DialogElementInterface>> param = new ArrayList<List<DialogElementInterface>>();
		param.add(zaKljuc);

		mockStatic(SQLGenerator.class);
	    when(SQLGenerator.search(t,param)).thenReturn("SELECT * FROM STANICA WHERE BROJ_TELEFONA LIKE '%64444999%';");
		
		mockStatic(DBConnection.class);
		DBConnection mockDB = mock(DBConnection.class);
		
		try {
			when(mockDB.getConnection()).thenReturn(DriverManager.getConnection("jdbc:jtds:sqlserver://"+"147.91.175.155"+"/"+"psw-2018-tim9-1", "psw-2018-tim9-1", "tim9-16273409"));
		} catch (SQLException e) {
			fail("Not yet implemented");
		}
		
		when(DBConnection.getInstance()).thenReturn(mockDB);
		
		//testiranje search-a koji vraca ocekivan rezultat
		List<Row> returnedList = rdbCrud.search(t, param);
		boolean allGood = true;
		
		if(returnedList.size() != expectedReturn.size()) {
			fail("fail");
		} else {
			for(int i = 0 ; i < returnedList.size() ; i++) { //za svaki red
				for(int j = 0 ; j < returnedList.get(i).getFields().size() ; j++) { //za svako polje
					if(t.getColumns().get(j).isPrimaryKey()) {
						if(!returnedList.get(i).getFields().get(j).equals(expectedReturn.get(i).getFields().get(j))) {
							allGood = false;
							break;
						}
					}
				}
			}
		}
	
		assertTrue(allGood);
	}

}
