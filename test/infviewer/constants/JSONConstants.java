package infviewer.constants;


import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;

import infviewer.tree.model.FKPairs;
import infviewer.tree.model.ForeignKey;
import infviewer.tree.model.Package;
import infviewer.tree.model.Table;
import infviewer.workspace.model.Column;

public class JSONConstants 
{
	public static final String SCHEMA_PATH_VALID = "resources/semaRedmine.json";
	public static final String METASCHEMA_PATH = "resources/metasema.json";

	public static final String SCHEMA_PATH_INVALID1 = "resources/semaRedmineInvalid1.json";
	public static final String SCHEMA_PATH_INVALID2 = "resources/semaRedmineInvalid2.json";
	public static final String SCHEMA_PATH_NOT_JSON = "resources/config.properties";
	public static final String SCHEMA_NOT_FOUND = "notfound.json";
	
	public static final JSONObject JSONOBJECT_VALID = new JSONObject("{\"package\":{\"packageName\":\"PRIMER_VEZBE\",\"label\":\"Primer sa vezbi\",\"packages\":[{\"tables\":[{\"foreignKeys\":[{\"referencedTable\":\"NASELJENO_MESTO\",\"relationName\":\"GLAVNI_GRAD\",\"label\":\"Glavni grad\",\"pairs\":[{\"referencing\":\"NM_PB\",\"referenced\":\"NM_PB\"}]}],\"columns\":[{\"dataType\":\"varchar\",\"length\":3,\"label\":\"Oznaka\",\"PK\":true,\"mandatory\":true,\"columnName\":\"DRZ_ID\"},{\"dataType\":\"varchar\",\"length\":128,\"label\":\"Naziv\",\"PK\":false,\"mandatory\":true,\"columnName\":\"DRZ_NAZIV\"},{\"dataType\":\"varchar\",\"length\":5,\"label\":\"Glavni grad\",\"PK\":false,\"mandatory\":false,\"columnName\":\"NM_PB\"}],\"label\":\"Drzava\",\"tableName\":\"DRZAVA\"},{\"foreignKeys\":[{\"referencedTable\":\"DRZAVA\",\"relationName\":\"PRIPADA_DRZAVI\",\"label\":\"Pripada drzavi\",\"pairs\":[{\"referencing\":\"DRZ_ID\",\"referenced\":\"DRZ_ID\"}]}],\"columns\":[{\"dataType\":\"varchar\",\"length\":3,\"label\":\"Drzava\",\"PK\":true,\"mandatory\":true,\"columnName\":\"DRZ_ID\"},{\"dataType\":\"varchar\",\"length\":5,\"label\":\"Post. broj\",\"PK\":true,\"mandatory\":true,\"columnName\":\"NM_PB\"},{\"dataType\":\"varchar\",\"length\":128,\"label\":\"Naziv\",\"PK\":false,\"mandatory\":true,\"columnName\":\"NM_NAZIV\"},{\"dataType\":\"int\",\"length\":10,\"label\":\"Broj stanovnika\",\"PK\":false,\"mandatory\":false,\"columnName\":\"NM_STAN\"},{\"dataType\":\"boolean\",\"label\":\"Grad\",\"PK\":false,\"mandatory\":true,\"columnName\":\"NM_GRAD\"},{\"dataType\":\"date\",\"label\":\"Datum osnivanja\",\"PK\":false,\"mandatory\":false,\"columnName\":\"NM_DAT_OSNIV\"}],\"label\":\"Naseljeno mesto\",\"tableName\":\"NASELJENO_MESTO\"},{\"foreignKeys\":[{\"referencedTable\":\"NASELJENO_MESTO\",\"relationName\":\"MESTO_RODJENJA\",\"label\":\"Mesto rodjenja\",\"pairs\":[{\"referencing\":\"STU_DRZRODJ\",\"referenced\":\"DRZ_ID\"},{\"referencing\":\"STU_MESTORODJ\",\"referenced\":\"NM_PB\"}]},{\"referencedTable\":\"NASELJENO_MESTO\",\"relationName\":\"MESTO_STANOVANJA\",\"label\":\"Mesto stanovanja\",\"pairs\":[{\"referencing\":\"STU_DRZSTAN\",\"referenced\":\"DRZ_ID\"},{\"referencing\":\"STU_MESTOSTAN\",\"referenced\":\"NM_PB\"}]}],\"columns\":[{\"dataType\":\"varchar\",\"length\":15,\"label\":\"Indeks\",\"PK\":true,\"mandatory\":true,\"columnName\":\"STU_INDEKS\"},{\"dataType\":\"varchar\",\"length\":64,\"label\":\"Ime\",\"PK\":false,\"mandatory\":true,\"columnName\":\"STU_IME\"},{\"dataType\":\"varchar\",\"length\":64,\"label\":\"Prezime\",\"PK\":false,\"mandatory\":true,\"columnName\":\"STU_PREZIME\"},{\"dataType\":\"varchar\",\"length\":3,\"label\":\"Drzava rodjenja\",\"PK\":false,\"mandatory\":true,\"columnName\":\"STU_DRZRODJ\"},{\"dataType\":\"varchar\",\"length\":5,\"label\":\"Mesto rodjenja\",\"PK\":false,\"mandatory\":true,\"columnName\":\"STU_MESTORODJ\"},{\"dataType\":\"varchar\",\"length\":3,\"label\":\"Drzava stan.\",\"PK\":false,\"mandatory\":false,\"columnName\":\"STU_DRZSTAN\"},{\"dataType\":\"varchar\",\"length\":5,\"label\":\"Mesto stan.\",\"PK\":false,\"mandatory\":false,\"columnName\":\"STU_MESTOSTAN\"}],\"label\":\"Student\",\"tableName\":\"STUDENT\"}],\"packageName\":\"PODSISTEM\",\"label\":\"Podsistem\",\"packageType\":\"subpackage\"}],\"packageType\":\"package\"}}\r\n");
	public static final JSONObject JSONOBJECT_INVALID1 = new JSONObject("{\"package\":{\"packageName\":\"POGRESAN NAZIV PAKETA!\",\"label\":\"Primer sa vezbi\",\"packages\":[{\"tables\":[{\"foreignKeys\":[{\"referencedTable\":\"NASELJENO_MESTO\",\"relationName\":\"GLAVNI_GRAD\",\"label\":\"Glavni grad\",\"pairs\":[{\"referencing\":\"NM_PB\",\"referenced\":\"NM_PB\"}]}],\"columns\":[{\"dataType\":\"varchar\",\"length\":3,\"label\":\"Oznaka\",\"PK\":true,\"mandatory\":true,\"columnName\":\"DRZ_ID\"},{\"dataType\":\"varchar\",\"length\":128,\"label\":\"Naziv\",\"PK\":false,\"mandatory\":true,\"columnName\":\"DRZ_NAZIV\"},{\"dataType\":\"varchar\",\"length\":5,\"label\":\"Glavni grad\",\"PK\":false,\"mandatory\":false,\"columnName\":\"NM_PB\"}],\"label\":\"Drzava\",\"tableName\":\"DRZAVA\"},{\"foreignKeys\":[{\"referencedTable\":\"DRZAVA\",\"relationName\":\"PRIPADA_DRZAVI\",\"label\":\"Pripada drzavi\",\"pairs\":[{\"referencing\":\"DRZ_ID\",\"referenced\":\"DRZ_ID\"}]}],\"columns\":[{\"dataType\":\"varchar\",\"length\":3,\"label\":\"Drzava\",\"PK\":true,\"mandatory\":true,\"columnName\":\"DRZ_ID\"},{\"dataType\":\"varchar\",\"length\":5,\"label\":\"Post. broj\",\"PK\":true,\"mandatory\":true,\"columnName\":\"NM_PB\"},{\"dataType\":\"varchar\",\"length\":128,\"label\":\"Naziv\",\"PK\":false,\"mandatory\":true,\"columnName\":\"NM_NAZIV\"},{\"dataType\":\"int\",\"length\":10,\"label\":\"Broj stanovnika\",\"PK\":false,\"mandatory\":false,\"columnName\":\"NM_STAN\"},{\"dataType\":\"boolean\",\"label\":\"Grad\",\"PK\":false,\"mandatory\":true,\"columnName\":\"NM_GRAD\"},{\"dataType\":\"date\",\"label\":\"Datum osnivanja\",\"PK\":false,\"mandatory\":false,\"columnName\":\"NM_DAT_OSNIV\"}],\"label\":\"Naseljeno mesto\",\"tableName\":\"NASELJENO_MESTO\"},{\"foreignKeys\":[{\"referencedTable\":\"NASELJENO_MESTO\",\"relationName\":\"MESTO_RODJENJA\",\"label\":\"Mesto rodjenja\",\"pairs\":[{\"referencing\":\"STU_DRZRODJ\",\"referenced\":\"DRZ_ID\"},{\"referencing\":\"STU_MESTORODJ\",\"referenced\":\"NM_PB\"}]},{\"referencedTable\":\"NASELJENO_MESTO\",\"relationName\":\"MESTO_STANOVANJA\",\"label\":\"Mesto stanovanja\",\"pairs\":[{\"referencing\":\"STU_DRZSTAN\",\"referenced\":\"DRZ_ID\"},{\"referencing\":\"STU_MESTOSTAN\",\"referenced\":\"NM_PB\"}]}],\"columns\":[{\"dataType\":\"varchar\",\"length\":15,\"label\":\"Indeks\",\"PK\":true,\"mandatory\":true,\"columnName\":\"STU_INDEKS\"},{\"dataType\":\"varchar\",\"length\":64,\"label\":\"Ime\",\"PK\":false,\"mandatory\":true,\"columnName\":\"STU_IME\"},{\"dataType\":\"varchar\",\"length\":64,\"label\":\"Prezime\",\"PK\":false,\"mandatory\":true,\"columnName\":\"STU_PREZIME\"},{\"dataType\":\"varchar\",\"length\":3,\"label\":\"Drzava rodjenja\",\"PK\":false,\"mandatory\":true,\"columnName\":\"STU_DRZRODJ\"},{\"dataType\":\"varchar\",\"length\":5,\"label\":\"Mesto rodjenja\",\"PK\":false,\"mandatory\":true,\"columnName\":\"STU_MESTORODJ\"},{\"dataType\":\"varchar\",\"length\":3,\"label\":\"Drzava stan.\",\"PK\":false,\"mandatory\":false,\"columnName\":\"STU_DRZSTAN\"},{\"dataType\":\"varchar\",\"length\":5,\"label\":\"Mesto stan.\",\"PK\":false,\"mandatory\":false,\"columnName\":\"STU_MESTOSTAN\"}],\"label\":\"Student\",\"tableName\":\"STUDENT\"}],\"packageName\":\"PODSISTEM\",\"label\":\"Podsistem\",\"packageType\":\"subpackage\"}],\"packageType\":\"package\"}}\r\n");
	public static final JSONObject JSONOBJECT_INVALID2 = new JSONObject("{\"package\":{\"packageName\":\"PRIMER_VEZBE\",\"label\":\"Primer sa vezbi\",\"packages\":[{\"tables\":[{\"foreignKeys\":[{\"referencedTable\":\"NASELJENO_MESTO\",\"relationName\":\"GLAVNI_GRAD\",\"label\":\"Glavni grad\",\"pairs\":[{\"referencing\":\"NM_PB\",\"referenced\":\"NM_PB\"}]}],\"columns\":[{\"dataType\":\"varchar\",\"length\":3,\"label\":\"Oznaka\",\"PK\":true,\"mandatory\":true,\"columnName\":\"DRZ_ID\"},{\"dataType\":\"varchar\",\"length\":128,\"label\":\"Naziv\",\"PK\":false,\"mandatory\":true,\"columnName\":\"DRZ_NAZIV\"},{\"dataType\":\"varchar\",\"length\":5,\"label\":\"Glavni grad\",\"PK\":false,\"mandatory\":false,\"columnName\":\"NM_PB\"}],\"label\":\"Drzava\",\"tableName\":\"DRZAVA\"},{\"foreignKeys\":[{\"referencedTable\":\"DRZAVA\",\"relationName\":\"PRIPADA_DRZAVI\",\"label\":\"Pripada drzavi\",\"pairs\":[{\"referencing\":\"DRZ_ID\",\"referenced\":\"DRZ_ID\"}]}],\"columns\":[{\"dataType\":\"varchar\",\"length\":3,\"label\":\"Drzava\",\"PK\":true,\"mandatory\":true,\"columnName\":\"DRZ_ID\"},{\"dataType\":\"varchar\",\"length\":5,\"label\":\"Post. broj\",\"PK\":true,\"mandatory\":true,\"columnName\":\"NM_PB\"},{\"dataType\":\"varchar\",\"length\":128,\"label\":\"Naziv\",\"PK\":false,\"mandatory\":true,\"columnName\":\"NM_NAZIV\"},{\"dataType\":\"int\",\"length\":10,\"label\":\"Broj stanovnika\",\"PK\":false,\"mandatory\":false,\"columnName\":\"NM_STAN\"},{\"dataType\":\"boolean\",\"label\":\"Grad\",\"PK\":false,\"mandatory\":true,\"columnName\":\"NM_GRAD\"},{\"dataType\":\"date\",\"label\":\"Datum osnivanja\",\"PK\":false,\"mandatory\":false,\"columnName\":\"NM_DAT_OSNIV\"}],\"label\":\"Naseljeno mesto\",\"tableName\":\"NASELJENO_MESTO\"},{\"label\":\"Student\",\"tableName\":\"STUDENT\"}],\"packageName\":\"PODSISTEM\",\"label\":\"Podsistem\",\"packageType\":\"subpackage\"}],\"packageType\":\"package\"}}\r\n");
	public static final Package TESTING_PACKAGE = testingPackage();
	
	public static final JSONObject METASCHEMA = new JSONObject("{\"$schema\":\"http://json-schema.org/draft-07/schema#\",\"additionalProperties\":false,\"title\":\"Meta-sema\",\"type\":\"object\",\"definitions\":{\"package\":{\"additionalProperties\":false,\"type\":\"object\",\"properties\":{\"tables\":{\"type\":\"array\",\"items\":{\"additionalProperties\":false,\"type\":\"object\",\"properties\":{\"foreignKeys\":{\"description\":\"Niz stranih kljuceva tabele\",\"type\":\"array\",\"items\":{\"additionalProperties\":false,\"type\":\"object\",\"properties\":{\"referencedTable\":{\"description\":\"Naziv tabele koja je referencirana\",\"$ref\":\"#/definitions/stringType\"},\"relationName\":{\"description\":\"Opis relacije izmedju referencirane i referencirajuce tabele\",\"$ref\":\"#/definitions/stringType\"},\"label\":{\"description\":\"Labela za vizuelni prikaz\",\"$ref\":\"#/definitions/stringType\"},\"pairs\":{\"description\":\"Par koji predstavlja kolonu iz referencirane i kolonu iz referencirajuce tabele\",\"type\":\"array\",\"items\":{\"additionalProperties\":false,\"type\":\"object\",\"properties\":{\"referencing\":{\"description\":\"Naziv kolone koja referencira\",\"$ref\":\"#/definitions/stringType\"},\"referenced\":{\"description\":\"Naziv kolone koja je referencirana\",\"$ref\":\"#/definitions/stringType\"}},\"required\":[\"referenced\",\"referencing\"]}}},\"required\":[\"referencedTable\",\"relationName\",\"label\",\"pairs\"]}},\"columns\":{\"type\":\"array\",\"items\":{\"additionalProperties\":false,\"type\":\"object\",\"properties\":{\"dataType\":{\"description\":\"Tip podataka za vrednost u koloni\",\"type\":\"string\",\"enum\":[\"boolean\",\"int\",\"float\",\"varchar\",\"date\",\"char\"]},\"precision\":{\"description\":\"Broj cifara vrednosti u koloni\",\"type\":\"integer\",\"minimum\":1},\"length\":{\"description\":\"Duzina vrednosti u koloni\",\"type\":\"integer\",\"minimum\":1},\"label\":{\"description\":\"Labela za vizuelni prikaz\",\"$ref\":\"#/definitions/stringType\"},\"PK\":{\"description\":\"True vrednost ako je kolona primarni kljuc, false u suprotnom\",\"type\":\"boolean\"},\"mandatory\":{\"description\":\"Da li je kolona obavezna za popunjavanje\",\"type\":\"boolean\"},\"columnName\":{\"description\":\"Naziv kolone\",\"$ref\":\"#/definitions/stringType\"}},\"required\":[\"columnName\",\"label\",\"dataType\",\"PK\",\"mandatory\"]}},\"label\":{\"description\":\"Labela za vizuelni prikaz\",\"$ref\":\"#/definitions/stringType\"},\"tableName\":{\"description\":\"Naziv jednog entiteta\",\"$ref\":\"#/definitions/stringType\"}},\"required\":[\"tableName\",\"label\",\"columns\"]}},\"packageName\":{\"description\":\"Ime paketa u kojoj se nalazi opis informacionog resursa\",\"$ref\":\"#/definitions/stringType\"},\"label\":{\"description\":\"Labela za vizuelni prikaz\",\"$ref\":\"#/definitions/stringType\"},\"packages\":{\"type\":\"array\",\"items\":{\"$ref\":\"#/definitions/package\"}},\"packageType\":{\"description\":\"Tip paketa\",\"type\":\"string\",\"enum\":[\"package\",\"subpackage\"]}},\"required\":[\"packageName\",\"label\",\"packageType\"]},\"stringType\":{\"minLength\":2,\"type\":\"string\",\"maxLength\":30}},\"properties\":{\"package\":{\"$ref\":\"#/definitions/package\"}}}");
	
	public static Schema getMetaSchema()
	{
		return SchemaLoader.load(METASCHEMA);
	}
	
	
	public static Package testingPackage()
	{
		Package pckg = new Package("PRIMER_VEZBE", "Primer sa vezbi", "package");
		Package subPckg = new Package("PODSISTEM", "Podsistem", "subpackage");
		
		Table table1 = new Table("DRZAVA", "Drzava", null);
		Column column11 = new Column("DRZ_ID", "Oznaka", "varchar", 0, 3, true, true, null, null);
		Column column12 = new Column("DRZ_NAZIV", "Naziv", "varchar", 0, 128, true, false, null, null);
		Column column13 = new Column("NM_PB", "Glavni grad", "varchar", 0, 5, false, false, null, null);
		table1.addColumns(column11);
		table1.addColumns(column12);
		table1.addColumns(column13);
		ForeignKey foreignKey1 = new ForeignKey("GLAVNI_GRAD", "Glavni grad", "NASELJENO_MESTO", null, null, null);
		FKPairs fkPairs1 = new FKPairs("NM_PB", "NM_PB", null, null, null, null, null);
		foreignKey1.addFkpairs(fkPairs1);
		table1.addForeignkeys(foreignKey1);
		subPckg.addTables(table1);
		
		Table table2 = new Table("NASELJENO_MESTO", "Naseljeno mesto", null);
		Column column21 = new Column("DRZ_ID", "Drzava", "varchar", 0, 3, true, true, null, null);
		Column column22 = new Column("NM_PB", "Post. broj", "varchar", 0, 5, true, true, null, null);
		Column column23 = new Column("NM_NAZIV", "Naziv", "varchar", 0, 128, true, false, null, null);
		Column column24 = new Column("NM_STAN", "Broj stanovnika", "int", 0, 10, false, false, null, null);
		Column column25 = new Column("NM_GRAD", "Grad", "boolean", 0, 0, true, false, null, null);
		Column column26 = new Column("NM_DAT_OSNIV", "Datum osnivanja", "date", 0, 0, false, false, null, null);
		table2.addColumns(column21);
		table2.addColumns(column22);
		table2.addColumns(column23);
		table2.addColumns(column24);
		table2.addColumns(column25);
		table2.addColumns(column26);
		ForeignKey foreignKey2 = new ForeignKey("PRIPADA_DRZAVI", "Pripada drzavi", "DRZAVA", null, null, null);
		FKPairs fkPairs2 = new FKPairs("DRZ_ID", "DRZ_ID", null, null, null, null, null);
		foreignKey2.addFkpairs(fkPairs2);
		table2.addForeignkeys(foreignKey2);
		subPckg.addTables(table2);
		
		Table table3 = new Table("STUDENT", "Student", null);
		Column column31 = new Column("STU_INDEKS", "Indeks", "varchar", 0, 15, true, true, null, null);
		Column column32 = new Column("STU_IME", "Ime", "varchar", 0, 64, true, false, null, null);
		Column column33 = new Column("STU_PREZIME", "Prezime", "varchar", 0, 64, true, false, null, null);
		Column column34 = new Column("STU_DRZRODJ", "Drzava rodjenja", "varchar", 0, 3, true, false, null, null);
		Column column35 = new Column("STU_MESTORODJ", "Mesto rodjenja", "varchar", 0, 5, true, false, null, null);
		Column column36 = new Column("STU_DRZSTAN", "Drzava stan.", "varchar", 0, 3, false, false, null, null);
		Column column37 = new Column("STU_MESTOSTAN", "Mesto stan.", "varchar", 0, 5, false, false, null, null);
		table3.addColumns(column31);
		table3.addColumns(column32);
		table3.addColumns(column33);
		table3.addColumns(column34);
		table3.addColumns(column35);
		table3.addColumns(column36);
		table3.addColumns(column37);
		ForeignKey foreignKey31 = new ForeignKey("MESTO_RODJENJA", "Mesto rodjenja", "NASELJENO_MESTO", null, null, null);
		FKPairs fkPairs311 = new FKPairs("DRZ_ID", "STU_DRZRODJ", null, null, null, null, null);
		FKPairs fkPairs312 = new FKPairs("NM_PB", "STU_MESTORODJ", null, null, null, null, null);
		foreignKey31.addFkpairs(fkPairs311);
		foreignKey31.addFkpairs(fkPairs312);
		ForeignKey foreignKey32 = new ForeignKey("MESTO_STANOVANJA", "Mesto stanovanja", "NASELJENO_MESTO", null, null, null);
		FKPairs fkPairs321 = new FKPairs("DRZ_ID", "STU_DRZSTAN", null, null, null, null, null);
		FKPairs fkPairs322 = new FKPairs("NM_PB", "STU_MESTOSTAN", null, null, null, null, null);
		foreignKey32.addFkpairs(fkPairs321);
		foreignKey32.addFkpairs(fkPairs322);
		table3.addForeignkeys(foreignKey31);
		table3.addForeignkeys(foreignKey32);
		subPckg.addTables(table3);
		
		pckg.addSubpackages(subPckg);
		return pckg;
	}
}