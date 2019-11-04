package infviewer.constants;

import java.util.ArrayList;

import infviewer.app.ApplicationSingleton;
import infviewer.tree.model.FKPairs;
import infviewer.tree.model.ForeignKey;
import infviewer.tree.model.Table;
import infviewer.workspace.model.Column;
import infviewer.workspace.model.Row;

public class RDBCRUDConstants {
	
	
	public static Row getStation1ToCreate() {
		Row row = new Row();
		row.addField(31);
		row.addField("Naziv1Test");
		row.addField("mail1@mail.com");
		row.addField("063357753");
		
		return row;
	}
	
	public static Row getStationToUpdate() {
		Row row = new Row();
		row.addField(32);
		row.addField("ZaMenjanjeTest");
		row.addField("mail2@mailPROMENJEN.com");
		row.addField("06534553");
		
		return row;
	}
	
	public static Row getStationNotExisting() {
		Row row = new Row();
		row.addField(35);
		row.addField("Naziv3Test");
		row.addField("mail3@mail.com");
		row.addField("069999999");
		
		return row;
	}
	
	public static Row getStationToRead() {
		Row row = new Row();
		row.addField(39);
		row.addField("UvekJeTuTest");
		row.addField("mail4@mail.com");
		row.addField("0644449999");
		
		return row;
	}
	
	public static Row getStationToDelete() {
		Row row = new Row();
		row.addField(55);
		row.addField("ZaBrisanjeTest");
		row.addField("mail444@mail.com");
		row.addField("0643457999");
		return row;	
	}
	
	
	public static Row getStationToSearch() {
		Row row = new Row();
		row.addField("MNE");
		row.addField("Crna Gora");
		row.addField(81001);
		return row;	
	}
	
	
	public static Row getIncompatibleRow() {
		Row row = new Row();
		row.addField("SWE");
		row.addField("Sweden");
		row.addField(31313);
		row.addField("extra");
		row.addField(true);
		return row;	
	}

	public static Table testingTable()
	{
		Table table1 = new Table("STANICA", "Stanica", "07_TRANSPORT");
		
		Column column11 = new Column("OZNAKA_STANICE", "Oznaka stanice", "int", 0, 0, true, true, null, "07_TRANSPORT");
		Column column12 = new Column("NAZIV", "Naziv", "varchar", 0, 60, true, false, null, "07_TRANSPORT");
		Column column13 = new Column("E_MAIL", "E-Mail", "varchar", 0, 30, false, false, null, "07_TRANSPORT");
		Column column14 = new Column("BROJ_TELEFONA", "Broj telefona", "varchar", 0, 20, false, false, null, "07_TRANSPORT");
		table1.addColumns(column11);
		table1.addColumns(column12);
		table1.addColumns(column13);
		table1.addColumns(column14);

		return table1;
	}
	
	
	
}
