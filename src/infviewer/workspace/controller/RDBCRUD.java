/***********************************************************************
 * Module:  Rdbcrud.java
 * Author:  Jovic
 * Purpose: Defines the Class Rdbcrud
 ***********************************************************************/

package infviewer.workspace.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import infviewer.database.DBConnection;
import infviewer.tree.model.Table;
import infviewer.workspace.miscellaneous.SQLGenerator;
import infviewer.workspace.model.Column;
import infviewer.workspace.model.Row;
import infviewer.workspace.view.DialogElementInterface;

public class RDBCRUD implements infviewer.controller.CRUD {
   
   public boolean create(Row row, Table table) {
	   String insert = SQLGenerator.insert(table);
	   try 
	   {
		   PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement(insert);
		   for (int i = 0; i < row.getFields().size(); i++)
		   {
			   preparedStatement.setObject(i+1, row.getFields().get(i));
		   }
		   preparedStatement.executeUpdate();
	   }
	   catch (SQLException e) 
	   {
		   e.printStackTrace();
		   return false;		
	   }
	   return true;
   }
   
   public boolean update(Row row,Table table) {
	   	StringBuilder update = SQLGenerator.update(table);
	   	String query = update.toString();
		   try 
		   {
			   PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement(query);
			   for (int i = 0; i < row.getFields().size(); i++)
			   {

				   preparedStatement.setObject(i+1, row.getFields().get(i));
			   }
			   int k = row.getFields().size();
		    
				for(int i = 0; i < table.getColumns().size() ; i++) 
				{
					if(table.getColumns().get(i).isPrimaryKey()) {
						k++;
						preparedStatement.setObject(k, row.getFields().get(i));

					}		
				}
						   
			   preparedStatement.executeUpdate();
		   }
		   catch (SQLException e) 
		   {
			   e.printStackTrace();
			   return false;		
		   }
		   return true;
	   
   }
   
    public List<Row> read(Table table, HashMap<String, Object> key) {
    	String query = SQLGenerator.selectQuery(table.getName(), key);
	    List<Row> result = new ArrayList<>();
		try(Statement stm = DBConnection.getInstance().getConnection().createStatement(); 
			ResultSet resultSet = stm.executeQuery(query);) {			
			
			while(resultSet.next()) {
				Row row = new Row();
				for(Column c: table.getColumns()) {
					if (c.getDataType().equals("date"))
					{
						row.addField(resultSet.getDate(c.getName()));
					}
					else
					{
						row.addField(resultSet.getObject(c.getName()));
					}
				}
				result.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
	   return result;
   }
   
   public boolean delete(Row row, Table table) {
	   String delete = SQLGenerator.delete(table, row);
	   try{
		   Statement statement = DBConnection.getInstance().getConnection().createStatement();    
		   statement.executeUpdate(delete);
	   }
	       catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	   
		
      return true;
   }

	public List<Row> search(Table table, List<List<DialogElementInterface>> searchDialogElements) {
		String query = SQLGenerator.search(table, searchDialogElements);
		List<Row> result = new ArrayList<>();
		try(Statement stm = DBConnection.getInstance().getConnection().createStatement(); 
			ResultSet resultSet = stm.executeQuery(query);) {			
			
			while(resultSet.next()) {
				Row row = new Row();
				for(Column c: table.getColumns()) {
					if (c.getDataType().equals("date"))
					{
						row.addField(resultSet.getDate(c.getName()));
					}
					else
					{
						row.addField(resultSet.getObject(c.getName()));
					}
				}
				result.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	   
		
	   return result;
	}

}