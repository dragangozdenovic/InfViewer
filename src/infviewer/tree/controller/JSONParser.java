/***********************************************************************
 * Module:  JSONParser.java
 * Author:  Jovic
 * Purpose: Defines the Class JSONParser
 ***********************************************************************/

package infviewer.tree.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import infviewer.tree.model.FKPairs;
import infviewer.tree.model.ForeignKey;
import infviewer.tree.model.Package;
import infviewer.tree.model.Table;
import infviewer.workspace.model.Column;

public class JSONParser implements infviewer.controller.Parser
{   
   public Package parse(Object objectToParse) 
   {
	    JSONObject json = (JSONObject)objectToParse;  
	   
	    if (json.has("package"))
	    {
	    	json = (JSONObject) json.get("package");
	    }
	    
	    Package mainPackage = new Package();
	    mainPackage.setPackageType(json.getString("packageType"));
		mainPackage.setName(json.getString("packageName"));
		mainPackage.setLabel(json.getString("label"));
		
		if (json.has("packages"))
		{
			JSONArray jsonArrayPackages = json.getJSONArray("packages");
			for(Object object : jsonArrayPackages)
			{
				mainPackage.addSubpackages(parse((JSONObject)object));
			}				
		}
	
		if (json.has("tables"))
		{			
			JSONArray jsonArrayTables = json.getJSONArray("tables");
			for(Object objectTable : jsonArrayTables)
			{
				JSONObject jsonTable = (JSONObject)objectTable;
				Table table = new Table();
				table.setName(jsonTable.getString("tableName"));
				table.setLabel(jsonTable.getString("label"));
				
				JSONArray jsonArrayColumns = jsonTable.getJSONArray("columns");
				for(Object objectColumn : jsonArrayColumns)
				{
					JSONObject jsonColumn = (JSONObject)objectColumn;
					Column column = new Column();
					
					column.setName(jsonColumn.getString("columnName"));
					column.setLabel(jsonColumn.getString("label"));
					column.setDataType(jsonColumn.getString("dataType"));
					
					//Length i precision nisu obazena polja u okviru kolone, pa mormao ispitati da li su definisana
					//Pre nego sto ih preuzmemo
					if(jsonColumn.has("length"))
					{
						column.setLength(jsonColumn.getInt("length"));
					}
					
					if(jsonColumn.has("precision"))
					{
						column.setPrecision(jsonColumn.getInt("precision"));
					}
					
					column.setPrimaryKey(jsonColumn.getBoolean("PK"));
					column.setMandatory(jsonColumn.getBoolean("mandatory"));
					
					table.addColumns(column);
				}
				
				if (jsonTable.has("foreignKeys"))
				{
					JSONArray jsonArrayForeignKeys = jsonTable.getJSONArray("foreignKeys");
					for(Object objectForeignKey : jsonArrayForeignKeys)
					{
						JSONObject jsonForeignKey = (JSONObject)objectForeignKey;
						ForeignKey foreignKey = new ForeignKey();
						
						foreignKey.setReferencedTable(jsonForeignKey.getString("referencedTable"));
						foreignKey.setName(jsonForeignKey.getString("relationName"));
						foreignKey.setLabel(jsonForeignKey.getString("label"));
						
						JSONArray jsonArrayPairs = jsonForeignKey.getJSONArray("pairs");
						for(Object objectPair : jsonArrayPairs)	
						{
							JSONObject jsonPair = (JSONObject)objectPair;
							FKPairs foreignKeyPair = new FKPairs();
							
							foreignKeyPair.setReferenced(jsonPair.getString("referenced"));
							foreignKeyPair.setReferencing(jsonPair.getString("referencing"));
							
							foreignKey.addFkpairs(foreignKeyPair);
						}
						
						table.addForeignkeys(foreignKey);
					}
				}
				
				mainPackage.addTables(table);
			}
		}

		return mainPackage;
   }
   
   public JSONObject getJSONForParsing(String path) throws JSONException
   {
		InputStream jsonInputStream = null;
		try 
		{
			jsonInputStream = new BufferedInputStream(new FileInputStream(new File(path)));
		} 
		catch (FileNotFoundException e) 
		{
			return null;
		}
		
		JSONObject json = new JSONObject(new JSONTokener(jsonInputStream));
		return json;
   }
}