/***********************************************************************
 * Module:  CRUD.java
 * Author:  Jovic
 * Purpose: Defines the Interface CRUD
 ***********************************************************************/

package infviewer.controller;

import java.util.HashMap;
import java.util.List;

import infviewer.tree.model.Table;
import infviewer.workspace.model.Row;
import infviewer.workspace.view.DialogElementInterface;

/** <code>CRUD</code> interfejs predstvlja apstrakciju CRUD operacija nezavisnih od konkretne implementacije.
 * Sadrzi metode <code>Create</code> za kreiranje, <code>Read</code> za citanje,
 * <code>Update</code> za azuriranje i <code>Delete</code> za brisanje podataka.
 * 
 * @author Tim9.1
 * @version 1.0	
 */
public interface CRUD {
	
   /** Kreira prosledjen red u zadatu tabelu.
	 * Vraca vrednost koja oznacava uspesnost operacije.
	 * 
	 * @param row Red koji treba kreirati.
     * @param table Tabela iz skladista podataka u kojoj je potrebno izvrsiti kreiranje.
     * @return <tt>true</tt> ako je operacija kreiranja uspesna, u suprotnom <tt>false</tt>
	 */
   boolean create(Row row, Table table);
   
   /**Cita redove iz prosledjene tabele. 
    * @param table Tabela iz koje je potrebno vrsiti ucitavanje redova. 
    * @param key HashMap-a koja za kljuc ima naziv polja, a za vrednost, vrednost polja
    * koje je zadato kljucem.
    * @return Lista redova koji za polja iz mape {@code key},
    * imaju zadate vrednosti iz mape {@code key}.
    * Ukoliko je <tt>(key == null)</tt>, vraca sve redove iz tabele {@code table}.
    * Ukoliko je <tt>(key.isEmpty() == true)</tt>, vraca sve redove iz tabele {@code table}.
    * @see java.util.HashMap
    *  */
   List<Row> read(Table table, HashMap<String, Object> key);

   /** Azurira prosledjeni red iz zadate tabele, ukoliko postoji.
    * @param table Tabela u kojoj se vrsi azuriranje (sadrzi red koji je potrebno azurirati).
    * @param row Red koji je potrebno azurirati.
    * @return <tt>true</tt> ukoliko je akcija azuriranja uspesna, <tt>false</tt> u suprotnom.
    */
   boolean update(Row row,Table table);

   /** Brisanje prosledjenog reda iz zadate tabele, ukoliko postoji.
     * @param table Tabela u kojoj se vrsi brisanje (sadrzi red koji je potrebno obrisati).
     * @param row Red koji je potrebno obrisati.
     * @return <tt>true</tt> ukoliko je akcija brisanja uspesna, <tt>false</tt> u suprotnom.
     */
   boolean delete(Row row, Table table);
   /** Pretrazuje redove u prosledjenoj tabeli po zadatim kriterijumima za polja, prosledjenim
    * u listi {@code searchDialogElements} i vraca redove koji odgovaraju kreiterijumima.
    * @param table Tabela u kojoj se vrsi pretraga (sadrzi potenicjalne redove koji
    * odgovaraju pretrazi).
    * @param searchDialogElements Lista koja sadrzi listu vrednosti za pretragu.
    * Unutrasnja lista {@code List<DialogElementInterface>} sadrzi vrednosti za pretragu.
    * Ova lista moze sadrzati 2 elementa, ukoliko se polje pretrazuje po dometu 
    * (kriterijum od-do. Pocetni datum - krajni datum itd...)
    * U suprotnom, ova lista sadrzi jedan element, ukoliko se polje pretrazuje po tacnoj vrednosti.
    * {@code searchDialogElements} sadrzi listu ovakvih lista. 
    * @return Listu redova koji odgovaraju kriterijumima pretrage. Ukoliko ni jedan red
    * ne odgovara kriterijumima, vraca praznu listu.
    */
   List<Row> search(Table table, List<List<DialogElementInterface>> searchDialogElements);
}