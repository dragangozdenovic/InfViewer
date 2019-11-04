/***********************************************************************
 * Module:  SQLGenerator.java
 * Author:  DUCA
 * Purpose: Defines the Class SQLGenerator
 ***********************************************************************/

package infviewer.workspace.miscellaneous;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import infviewer.tree.model.Table;
import infviewer.workspace.model.Column;
import infviewer.workspace.model.Row;
import infviewer.workspace.view.DialogElementInterface;

/** 
 * <code>SQLGenerator</code> je klasa koja sadrži metode koje omogućavaju implementaciju upita da bi 
 * se preuzeli određeni podaci iz tabela. Sadrži metode <code>SelectQuery</code> za citanje podataka,
 * <code>Insert</code> za upis podataka, <code>Update</code> za ažuriranje podataka, <code>Delete</code> za brisanje podataka,
 * <code>Search</code> za pretragu podataka iz tabela. Pored toga, sadrzi metode: <code>VarcharStatement</code>, <code>charOrBoolStatement</code>,
 *  <code>IntOrFloatStatement</code>,<code>DateStatement</code> koje omogucavaju primenu SQL operatora.  
 *  
 *  @author DrGoz
 *  */

public class SQLGenerator {
	 
	/**
	* @param tableName tabela iz koje se citaju podaci
    * @param key HashMapa koja za kljuc ima naziv polja, a za vrednost, vrednost polja
    * koje je zadato kljucem.
    * Metoda koja sluzi kreiranje upita i omogucava citanje podataka iz tabela.
    * Ukoliko je <tt>(key == null)</tt>, vraca String koji omogucava kreiranje upita ciji
    * su rezulati sve redovi u tabeli {@code table}.
    * Ukoliko je <tt>(key.isEmpty() == true)</tt>, vraca String koji omogucava kreiranje upita ciji
    * su rezulati sve redovi u tabeli {@code table}..
    * @return String koji ima sintaksu SELECT statementa  koji za polja iz mape {@code key},
    * imaju zadate vrednosti iz mape {@code key}.
    * 
    * */
	public static String selectQuery(String tableName, HashMap<String, Object> key) {
		String query = "";
		query += "SELECT * FROM " + tableName;
		if (key == null || key.isEmpty()){
			query += ";";
			return query;
		}
		query += " WHERE ";
		int size = key.size();
		for(Entry<String, Object> pair: key.entrySet()) {
			query += pair.getKey() + " = '" + pair.getValue() + "'";
			size--;
			if(size > 0) {
				query += " AND ";
			}
		}
		query += ";";
		return query;
	}
	
	/**
	 * Metoda koja sluzi za predstavljanje INSERT INTO statementa.
	 * @param table Naziv tabele u koju se dodaju redovi. 
	 * @return  String koji ima sintaksu INSERT INTO statementa, gdje se za tabelu {@code table} 
	 * ubacuju novi redovi
	 */
	public static String insert(Table table)
	{
		String insert = "INSERT INTO " + table.getName() + " (";
		for (int i = 0; i < table.getColumns().size() - 1; i++)
		{
			insert += table.getColumns().get(i).getName() + ", ";
		}
		insert += table.getColumns().get(table.getColumns().size() - 1).getName() + ") VALUES (";
		for (int i = 0; i < table.getColumns().size() - 1; i++)
		{
			insert += "?, ";
		}
		insert += "?)";
		
		return insert;
	}
	
	
	/**
	 * Azurira postojeci red iz tabele ukoliko postoji.
	 * @param table Naziv tabele ciji se redovi azuriraju.
	 * @return StringBuilder koji predstavlja sintaksu UPDATE statementa.
	 */

	public static StringBuilder update(Table table)

	{
		StringBuilder update = new StringBuilder();
		update.append("UPDATE " + table.getName() + " SET");
		boolean oneAdded = false;

		for (int i = 0; i < table.getColumns().size(); i++)
		{
			update.append(" "+table.getColumns().get(i).getName() + "=?,");
		}
		update.setCharAt(update.length()-1, ' ');
		update.append("WHERE");
		for(int i = 0; i < table.getColumns().size() ; i++) {
			if(table.getColumns().get(i).isPrimaryKey()) {
				if(oneAdded) {
					update.append(" AND");
				}
				update.append(" "+table.getColumns().get(i).getName() + "=?");
				oneAdded=true;
	}		
		}
		update.append(";");

		return update;
	}
	
	
	/**
	 * Metoda pomocu koje se predstavlja DELETE statement pri brisanju zeljenih 
	 * podataka iz baze podataka.
	 * @param table Naziv tabele iz koje brisemo redove. 
	 * @param row Red tabele koji se brise. 
	 * @return String koji ima sintaksu DELETE statementa. 
	 */
	public static String delete(Table table, Row row)
	{

		boolean onePkAdded = false;
		
		String delete = "DELETE FROM " + table.getName() + " WHERE ";
		
		for(int i = 0 ; i < table.getColumns().size()-1 ; i++) {
			if(table.getColumns().get(i).isPrimaryKey()) {
				if(onePkAdded) {
					delete += "' AND ";
				}
				delete += table.getColumns().get(i).getName();
				delete += " = '";
				delete += row.getFields().get(i);
				onePkAdded = true;
			}
		}
		
		if(table.getColumns().get(table.getColumns().size()-1).isPrimaryKey()) {
			delete += "' AND ";
			delete += table.getColumns().get(table.getColumns().size()-1).getName();
			delete += " = '";
			delete += row.getFields().get(table.getColumns().size()-1);
		}
	
		delete+= "';";
		
		return delete; 
	}
	
	/**
	 * 
	 * @param table Tabela u kojoj se vrsi pretraga (sadrzi potenicjalne redove koji
    * odgovaraju pretrazi).
	 * @param searchDialogElements  Lista koja sadrzi listu vrednosti za pretragu.
	 * @return String koji predstavlja upit koji korisnik moze da iskoristi u cilj dobijanja odredjenih
	 * informacija iz tabele. 
	 */
	public static String search(Table table, List<List<DialogElementInterface>> searchDialogElements) {
	    
	    String search = "SELECT * FROM " + table.getName() + " WHERE ";
	    int tableSize = table.getColumns().size();
	    int counter = 0;
	    
	    for(int i = 0; i < tableSize; i++) {
	        
	        Column column = table.getColumns().get(i);
	        List<DialogElementInterface> searchDialogElement = searchDialogElements.get(i);
	        String result = "";
	        
	        switch(column.getDataType()) {
	            case "varchar" : result = varcharStatement(column.getName(), searchDialogElement.get(0).getValue()); break;
	            case "char"    : result = charOrBoolStatement(column.getName(), searchDialogElement.get(0).getValue()); break;
	            case "boolean" : result = charOrBoolStatement(column.getName(), searchDialogElement.get(0).getValue()); break;
	            case "int"     : result = intOrFloatStatement(column.getName(), 
    	                                                        searchDialogElement.get(0).getValue(), 
    	                                                        searchDialogElement.get(1).getValue()); break;
	                
	            case "float"   : result = intOrFloatStatement(column.getName(), 
                                                                searchDialogElement.get(0).getValue(), 
                                                                searchDialogElement.get(1).getValue()); break;  
	            case "date"    : result = dateStatement(column.getName(), 
                                                                searchDialogElement.get(0).getValue(), 
                                                                searchDialogElement.get(1).getValue()); break;
	        }
	        
	        //prilikom prolaska kroz prvi uslov ne treba dodavati 'AND' u upitu	        
	        if(!result.equals("")) {
	            counter++;
	            if(counter != 1 ) {
	                search += " AND " + result;        	        
	            } else {
	                search += result;
	            }
	        }
	        
	        
	    }
	    search += ";";
	    
	    if(counter == 0)
	        return "SELECT * FROM " + table.getName();
	    else
	        return search;
	}
	
	/**
	 * Metoda koristi LIKE operator u WHERE klauzuli da bi se prikupili podaci koji imaju 
	 * specifican obrazac ponasanja u prosledjenoj <code>columnName</code>.
	 * @param columnName Prosledjena kolona tabele koja je od interesa, za koju se trazi obraza ponasanja.  
	 * @param s Objekat na osnovu koga pretrazujemo <code>columnName</code>.
	 * @return String 
	 */
	public static String varcharStatement(String columnName, Object s) {
	    String result = "";
	    if(s != null) result += columnName + " LIKE '%" + s.toString() + "%'";
	    return result;
	}
	
	public static String charOrBoolStatement(String columnName, Object s) {
	    String result = "";
        if(s != null) result += columnName + "='" + s.toString() + "'";
        return result;
    }
	
	/**
	 *  Metoda omogucava pretragu kolone po datumu, u obliku "od-do", u zavisnoti od toga da li je <code>(s1!=null)</code> i <code>(s2!=null)</code>.
	 * @param columnName Prosledjena kolona od interesa, u kojoj korisnik trazi podatke.
	 * @param s1 prvi parametar koji odredjuje od kog vremenskog interavala korisnik zapocinje pretragu
	 * @param s2 drugi parametar koji odredjuje to kog vremenskog intervala korisnik zavrsava preragu.
	 * @return String koji predstavlja pretragu u ({@code columnName} po BETWEEN operatoru. 
	 */
	public static String intOrFloatStatement(String columnName, Object s1, Object s2) {
	    String result = "";
        if(s1 != null && s2 != null) {
           result += columnName + " BETWEEN " + s1.toString() + " AND " + s2.toString();
        } else if (s1 != null) {
           result += columnName + ">=" + s1.toString();
        } else if (s2 != null) {
           result += columnName + "<=" + s2.toString(); 
        }
        return result;
    }

	/**
	 * Metoda omogucava pretragu kolone po datumu, u obliku "od-do", u zavisnoti od toga da li je <code>(s1!=null)</code> i <code>(s2!=null)</code>.
	 * @param columnName Prosledjena kolona od interesa, u kojoj korisnik trazi podatke.
	 * @param s1 prvi parametar koji odredjuje od kog vremenskog interavala korisnik zapocinje pretragu
	 * @param s2 drugi parametar koji odredjuje to kog vremenskog intervala korisnik zavrsava preragu.
	 * @return String u obliku DATE statementa. 
	 */
	public static String dateStatement(String columnName, Object s1, Object s2) {
	    String result = "";
        if(s1 != null && s2 != null) {
           result += columnName + " BETWEEN '" + s1.toString() + "' AND '" + s2.toString() + "'";
        } else if (s1 != null) {
           result += columnName + ">= '" + s1.toString() + "'";
        } else if (s2 != null) {
           result += columnName + "<= '" + s2.toString() + "'"; 
        }
        return result;
    }
}