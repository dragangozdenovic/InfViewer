package infviewer.constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import infviewer.tree.model.FKPairs;
import infviewer.tree.model.ForeignKey;
import infviewer.tree.model.Table;
import infviewer.workspace.model.Column;
import infviewer.workspace.model.Row;
import infviewer.workspace.view.DialogElementInterface;
import infviewer.workspace.view.IntegerElement;
import infviewer.workspace.view.VarcharElement;

public class SQLGeneratorConstants {

    public static final String SELECT_STATEMENT = "SELECT * FROM DRZAVA WHERE DR_OZNAKA = 'SRB' AND DR_STANOVNISTVO = '7000000' AND DR_NAZIV = 'Srbija' AND DR_DATUM = '05-Dec-2006' AND DR_CLAN_EU = 'false';";
    public static final String INSERT_STATEMENT = "INSERT INTO DRZAVA (DR_OZNAKA, DR_NAZIV, NM_PB) VALUES (?, ?, ?)";
    public static final String UPDATE_STATEMENT = "UPDATE DRZAVA SET DR_OZNAKA=?, DR_NAZIV=?, NM_PB=? WHERE DR_OZNAKA=?;";
    public static final String DELETE_STATEMENT = "DELETE FROM DRZAVA WHERE DR_OZNAKA = 'MEX';";
    public static final String SEARCH_STATEMENT = "SELECT * FROM DRZAVA WHERE DR_OZNAKA LIKE '%SR%' AND DR_NAZIV LIKE '%Srb%' AND NM_PB LIKE '%11000%';";
    public static final String TABLE_NAME = "DRZAVA";
    
    public static final Table VALID_TEST_TABLE = validTestTable();
    public static final Table INVALID_TEST_TABLE1 = invalidTestTable1();
    public static final Table INVALID_TEST_TABLE2 = invalidTestTable2();
    public static final Table INVALID_TEST_TABLE3 = invalidTestTable3();

    public static final Row VALID_TEST_ROW = validTestRow();
    public static final Row INVALID_TEST_ROW = invalidTestRow();

    public static final HashMap<String, Object> VALID_TEST_MAP = validTestMap();
    public static final HashMap<String, Object> INVALID_TEST_MAP1 = invalidTestMap1();
    public static final HashMap<String, Object> INVALID_TEST_MAP2 = invalidTestMap2();
    public static final HashMap<String, Object> INVALID_TEST_MAP3 = invalidTestMap3();
    
    public static final List<List<DialogElementInterface>> VALID_LIST_DIALOG_ELEMENTS = validListDialogElements();
    
    public static HashMap<String, Object> validTestMap() {
        HashMap<String, Object> selectMap = new HashMap<>();
        selectMap.put("DR_OZNAKA", "SRB");
        selectMap.put("DR_NAZIV", "Srbija");
        selectMap.put("DR_STANOVNISTVO", "7000000");
        selectMap.put("DR_DATUM", "05-Dec-2006");
        selectMap.put("DR_CLAN_EU", false);
        return selectMap;
    }

    public static HashMap<String, Object> invalidTestMap1() {
        HashMap<String, Object> selectMap = new HashMap<>();
        selectMap.put("DR_OZNAKA", "SRB");
        selectMap.put("DR_STANOVNISTVO", 7000000);
        selectMap.put("DR_DATUM", "05-Dec-2006");
        selectMap.put("DR_CLAN_EU", false);
        return selectMap;
    }
    
    public static HashMap<String, Object> invalidTestMap2() {
        HashMap<String, Object> selectMap = new HashMap<>();
        selectMap.put("DR_OZNAKA", "SRB");
        selectMap.put("DR_DATUM", "05-Dec-2006");
        selectMap.put("DR_IME", "Srbija");
        selectMap.put("DR_CLAN_EU", false);
        selectMap.put("DR_STANOVNISTVO", 7000000);
        return selectMap;
    }
    
    public static HashMap<String, Object> invalidTestMap3() {
        HashMap<String, Object> selectMap = new HashMap<>();
        selectMap.put("DR_OZNAKA", "SRB");
        selectMap.put("DR_NAZIV", "Srbija");
        selectMap.put("DR_STANOVNISTVO", 7000000);
        selectMap.put("DR_DATUM", "05-Dec-2006");
        selectMap.put("DR_CLAN_EU", true);
        return selectMap;
    }
    
    public static Table validTestTable() {
        Table table = new Table("DRZAVA", "Drzava", null);
        Column column11 = new Column("DR_OZNAKA", "Oznaka", "varchar", 0, 3, true, true, null, null);
        Column column12 = new Column("DR_NAZIV", "Naziv", "varchar", 0, 128, true, false, null, null);
        Column column13 = new Column("NM_PB", "Glavni grad", "varchar", 0, 5, false, false, null, null);
        table.addColumns(column11);
        table.addColumns(column12);
        table.addColumns(column13);
        ForeignKey foreignKey1 = new ForeignKey("GLAVNI_GRAD", "Glavni grad", "NASELJENO_MESTO", null, null, null);
        FKPairs fkPairs1 = new FKPairs("NM_PB", "NM_PB", null, null, null, null, null);
        foreignKey1.addFkpairs(fkPairs1);
        table.addForeignkeys(foreignKey1);
        return table;
    }
    
    public static Table invalidTestTable1() {
        Table table = new Table("DRZ", "Drzava", null);
        Column column11 = new Column("DR_OZNAKA", "Oznaka", "varchar", 0, 3, true, true, null, null);
        Column column12 = new Column("DR_NAZIV", "Naziv", "varchar", 0, 128, true, false, null, null);
        Column column13 = new Column("NM_PB", "Glavni grad", "varchar", 0, 5, false, false, null, null);
        table.addColumns(column11);
        table.addColumns(column12);
        table.addColumns(column13);
        ForeignKey foreignKey1 = new ForeignKey("GLAVNI_GRAD", "Glavni grad", "NASELJENO_MESTO", null, null, null);
        FKPairs fkPairs1 = new FKPairs("NM_PB", "NM_PB", null, null, null, null, null);
        foreignKey1.addFkpairs(fkPairs1);
        table.addForeignkeys(foreignKey1);
        return table;
    }
    
    public static Table invalidTestTable2() {
        Table table = new Table("DRZAVA", "Drzava", null);
        Column column11 = new Column("DR_OZNAKA", "Oznaka", "varchar", 0, 3, true, true, null, null);
        Column column13 = new Column("NM_PB", "Glavni grad", "varchar", 0, 5, false, false, null, null);
        table.addColumns(column11);
        table.addColumns(column13);
        ForeignKey foreignKey1 = new ForeignKey("GLAVNI_GRAD", "Glavni grad", "NASELJENO_MESTO", null, null, null);
        FKPairs fkPairs1 = new FKPairs("NM_PB", "NM_PB", null, null, null, null, null);
        foreignKey1.addFkpairs(fkPairs1);
        table.addForeignkeys(foreignKey1);
        return table;
    }
    
    public static Table invalidTestTable3() {
        Table table = new Table("STUDENT", "Student", null);
        Column column11 = new Column("INDEX", "Index", "varchar", 0, 10, true, true, null, null);
        Column column13 = new Column("IME", "Ime", "varchar", 0, 20, false, false, null, null);
        table.addColumns(column11);
        table.addColumns(column13);
        
        return table;
    }
    
    public static Row validTestRow() {
        Row row = new Row();
        row.addField("MEX");
        row.addField("Meksiko");
        row.addField(99999);
        return row;
    }
    
    public static Row invalidTestRow() {
        Row row = new Row();
        row.addField("Meksiko");
        return row;
    }
    
    private static List<List<DialogElementInterface>> validListDialogElements() {
        List<List<DialogElementInterface>> listDialogElements = new ArrayList<>();
        
        VarcharElement oznakaElement = new VarcharElement(3, true, "Oznaka");
        oznakaElement.createDialogElement();
        oznakaElement.setValue("SR");
        List<DialogElementInterface> oznakaList = new ArrayList<>();
        oznakaList.add(oznakaElement);
        listDialogElements.add(oznakaList);
        
        VarcharElement nazivElement = new VarcharElement(128, true, "Naziv");
        nazivElement.createDialogElement();
        nazivElement.setValue("Srb");
        List<DialogElementInterface> nazivList = new ArrayList<>();
        nazivList.add(nazivElement);
        listDialogElements.add(nazivList);
        
        IntegerElement mestoElement = new IntegerElement(true, 8, "Glavni grad");
        mestoElement.createDialogElement();
        mestoElement.setValue(11000);
        List<DialogElementInterface> mestoList = new ArrayList<>();
        mestoList.add(mestoElement);
        listDialogElements.add(mestoList);
        
        return listDialogElements;
    }
}
