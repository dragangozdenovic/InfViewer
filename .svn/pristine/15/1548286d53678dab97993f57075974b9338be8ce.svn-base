/***********************************************************************
 * Module:  RDBParser.java
 * Author:  Jovic
 * Purpose: Defines the Class RDBParser
 ***********************************************************************/

package infviewer.workspace.controller;

import java.util.HashMap;
import java.util.List;

import infviewer.app.ApplicationSingleton;
import infviewer.tree.model.FKPairs;
import infviewer.tree.model.ForeignKey;
import infviewer.tree.model.Package;
import infviewer.tree.model.Table;
import infviewer.workspace.model.Column;
import infviewer.workspace.model.Row;

public class RDBParser implements infviewer.controller.Parser {
    
    private RDBCRUD rdbcrud = new RDBCRUD();
    
    public Package parse(Object object) {
        
        Package mainPackage = new Package();
        Row packageFromDB = (Row) object;
                   
        mainPackage.setName(packageFromDB.getFields().get(0).toString());
        mainPackage.setLabel(ApplicationSingleton.getInstance().getResourceBundle().getString(packageFromDB.getFields().get(1).toString()));
        mainPackage.setPackageType(packageFromDB.getFields().get(2).toString());

        HashMap<String, Object> subPackMap = new HashMap<>();
        subPackMap.put("PO_OZNAKA", mainPackage.getName());
        List<Row> subpackages = readColumnsAndRows("STRUKTURA_PODSISTEMA", subPackMap);
        
        if(subpackages.size() != 0) {
            for(Row subPack : subpackages) {
                
                HashMap<String, Object> subPackFinalMap = new HashMap<>();
                subPackFinalMap.put("PO_OZNAKA", subPack.getFields().get(1).toString());
                List<Row> subpackagesFinal = readColumnsAndRows("PODSISTEM", subPackFinalMap);
                mainPackage.addSubpackages(parse(subpackagesFinal.get(0)));
            }

        }               
            
        
        HashMap<String, Object> tableMap = new HashMap<>();
        tableMap.put("PO_OZNAKA", mainPackage.getName());
        List<Row> tables = readColumnsAndRows("TABELE", tableMap);
        if(tables.size() != 0) {
            for(Row tab : tables) {
                Table table = new Table();
                table.setPackageOwner(tab.getFields().get(0).toString());
                table.setName(tab.getFields().get(1).toString());
                table.setLabel(ApplicationSingleton.getInstance().getResourceBundle().getString(tab.getFields().get(2).toString()));
                
                HashMap<String, Object> columnMap = new HashMap<>();
                columnMap.put("PO_OZNAKA", mainPackage.getName());
                columnMap.put("TAB_KOD", table.getName());
                List<Row> columns = readColumnsAndRows("ATRIBUTI", columnMap);
                for(Row col : columns) {
                    Column column = new Column();
                    column.setPackageOwner(col.getFields().get(0).toString());
                    column.setTableOwner(col.getFields().get(1).toString());
                    column.setName(col.getFields().get(2).toString());
                    column.setLabel(ApplicationSingleton.getInstance().getResourceBundle().getString(col.getFields().get(3).toString()));
                    column.setDataType(col.getFields().get(4).toString());
                    if(col.getFields().get(5) != null)
                        column.setMandatory((boolean) col.getFields().get(5));
                    if(col.getFields().get(6) != null)
                        column.setLength((int) col.getFields().get(6));
                    if(col.getFields().get(7) != null)
                        column.setPrecision((int) col.getFields().get(7));
                    if(col.getFields().get(8) != null)
                        column.setPrimaryKey((boolean) col.getFields().get(8));
                    table.addColumns(column);
                }
                
                HashMap<String, Object> foreignKeyMap = new HashMap<>();
                foreignKeyMap.put("TAB_PO_OZNAKA", table.getPackageOwner());
                foreignKeyMap.put("TAB_TAB_KOD", table.getName());
                List<Row> foreignKeys = readColumnsAndRows("STRANI_KLJUC", foreignKeyMap);
                for(Row fk : foreignKeys) {
                    ForeignKey foreignKey = new ForeignKey();
                    foreignKey.setReferencedPackage(fk.getFields().get(0).toString());
                    foreignKey.setReferencedTable(fk.getFields().get(1).toString());
                    foreignKey.setReferencingPackage(fk.getFields().get(2).toString());
                    foreignKey.setReferencingTable(fk.getFields().get(3).toString());
                    foreignKey.setName(fk.getFields().get(4).toString());
                    foreignKey.setLabel(ApplicationSingleton.getInstance().getResourceBundle().getString(fk.getFields().get(5).toString()));
                    
                    HashMap<String, Object> fkPairMap = new HashMap<>();
                    fkPairMap.put("ATR_PO_OZNAKA2", table.getPackageOwner());
                    fkPairMap.put("ATR_TAB_KOD", table.getName());
                    fkPairMap.put("SK_KOD", foreignKey.getName());
                    List<Row> fkPairs = readColumnsAndRows("KOLONE_U_STRANOM_KLJUCU", fkPairMap);
                    for(Row pair : fkPairs) {
                        FKPairs fkPair = new FKPairs();
                        fkPair.setReferencedPackage(pair.getFields().get(0).toString());
                        fkPair.setReferencedTable(pair.getFields().get(1).toString());
                        fkPair.setReferencingPackage(pair.getFields().get(2).toString());
                        fkPair.setReferencingTable(pair.getFields().get(3).toString());
                        fkPair.setForeignKey(pair.getFields().get(4).toString());
                        fkPair.setReferenced(pair.getFields().get(5).toString());
                        fkPair.setReferencing(pair.getFields().get(6).toString());
                        foreignKey.addFkpairs(fkPair);
                    }
                    
                    table.addForeignkeys(foreignKey);
                }
                mainPackage.addTables(table);
            }
        } 
    
        return mainPackage;
    }
   
   public List<Row> readColumnsAndRows(String name, HashMap<String, Object> mapKeys) {
       
       HashMap<String, Object> tableHashMap = new HashMap<String, Object>();
       tableHashMap.put("TABLE_NAME", name);
       
       Table tableColumns = new Table();       
       tableColumns.setName("INFORMATION_SCHEMA.COLUMNS");
       
       Column tableName = new Column();
       tableName.setName("COLUMN_NAME");
       tableName.setDataType("varchar");
       tableColumns.addColumns(tableName);
       
       Column tableLabel = new Column();
       tableLabel.setName("DATA_TYPE");
       tableLabel.setDataType("varchar");
       tableColumns.addColumns(tableLabel);
       
       Column tableType = new Column();
       tableType.setName("CHARACTER_MAXIMUM_LENGTH");
       tableType.setDataType("varchar");
       tableColumns.addColumns(tableType);
       
       List<Row> columns = rdbcrud.read(tableColumns, tableHashMap);
       
       Table tableRows = new Table();
       tableRows.setName(name);
       
       for(Row column : columns) {
           Column c = new Column();
           c.setName(column.getFields().get(0).toString());
           c.setDataType(column.getFields().get(1).toString());
           if(column.getFields().get(2) != null) {
               c.setLength((int)column.getFields().get(2));
           }
           tableRows.addColumns(c);
       }
       
       List<Row> rows = rdbcrud.read(tableRows, mapKeys);
       
       return rows;
   }
  
}