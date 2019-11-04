package infviewer.workspace.view;

import javax.swing.JComponent;

 /**  
 * Klasa sadrzi metodu <code>createDialogElement</code>.
 * Koristi se radi implementacije Strategy sablona. 
 * */
public interface DialogElementInterface{
   /**
    * Omogucava se stvaranje razlicitih elemenata dijaloga u zavisnosti od izabrane strategije.
    * @return Kreirana Swing komponenta na osnovu odabrane strategije.
    **/
   JComponent createDialogElement();

   /**
    * @param valueToSet Vrednost koja se prosledjuje predstavlja konkretan objekat.
    */
   public void setValue(Object valueToSet);
   
   /**
    * @return Vraca se konkretan objekat.
    */
   public Object getValue();
}