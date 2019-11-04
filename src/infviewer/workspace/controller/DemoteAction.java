/***********************************************************************
 * Module:  DemoteAction.java
 * Author:  Duka
 * Purpose: Defines the Class DemoteAction
 ***********************************************************************/

package infviewer.workspace.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import infviewer.app.ApplicationSingleton;
import infviewer.tree.model.FKPairs;
import infviewer.tree.model.ForeignKey;
import infviewer.tree.model.Table;
import infviewer.workspace.model.Column;
import infviewer.workspace.view.ParentChooser;
import infviewer.workspace.view.Tab;

/**
 * Klasa u kojoj se vrši depromovisanje prosleđene tabele. 
 * Nasleđuje <code>WorkspaceAction</code>. Pored nasleđenih metoda, sadrži metodu
 * <code>demote</code> i <code>findAllParents</code>. 
 * @see infviewer.workspace.controller.WorkspaceAction
 * @author DrGoz
 *
 */
public class DemoteAction extends WorkspaceAction 
{   
	private static final long serialVersionUID = -8113740019061843700L;
	private ResourceBundle resourceBundle = ApplicationSingleton.getInstance().getResourceBundle();

	public DemoteAction(Table table) {
		super(table);
	}

  /**
   * Metoda {@code findAllParents} se poziva i kreira se lista svih tabela koje je moguce depromovisati.
   * Korisnik se obavestava o tome ako ne postoji nijedna tabela koju je moguce depromovisati. 
   * Poziva se metoda {@code demote} ukoliko je pronadjena samo jedna roditeljska tabela.
   * Ukoliko postoji vise roditeljskih tabela korisnik bira jednu od ponuđenih za depromovisanje.
   */
   public void doAction() 
   {
	   List<String> parentsList = findAllParents(this.table);
	   
	   if (parentsList.isEmpty())
	   {
		   JOptionPane.showMessageDialog(ApplicationSingleton.getInstance().getApplicationMainFrame(), resourceBundle.getString("demoteErrorPart1") + this.table.getLabel() + resourceBundle.getString("demoteErrorPart2"), resourceBundle.getString("warningHeader"), JOptionPane.WARNING_MESSAGE);
	   }
	   else if(parentsList.size() == 1)
	   {
		   this.demote(this.table, parentsList.get(0));
	   }
	   else
	   {
		   String[] parents = new String[parentsList.size()];
		   parents = parentsList.toArray(parents);
		   
		   ParentChooser parentChooser = new ParentChooser(this, parents);
		   parentChooser.setVisible(true);
		   
		   
	   }
   }
   
   /**
    * Metoda vrsi depromovisanje roditelja u red deteta. 
    * Depromovisanje je izvrseno tako sto je koristena klasa {@link Promote}. Pozivanjem njene metode 
    * <code>promote</code> izvrseno je promovisanje roditelja tabele koja treba da se depromovise, cime je
    * postignut zeljeni uspeh.
    * @param table Tabela koja se depromovise.
    * @param parentName Naziv roditelja od tabele koja se depromovise.
    */
   public void demote(Table table, String parentName)
   {
	   Promote.promote(parentName);
	   for (Tab tab : ApplicationSingleton.getInstance().getParentView().getTabs())
	   {
		   if (tab.getTable().getLabel().equals(parentName))
		   {
			   tab.getChildView().selectTab(table);
			   break;
		   }
	   }
   }
   
   /**
    * Metoda za prosledjenu tabelu pronalazi roditelje te tabele koje se mogu depromovisati. 
    * @param table Za tabelu koja se prosledjuje se utvrdjuje da li ima i koliko ima roditelja.
    * @return Lista svih tabela koje se mogu depromovisati.
    */
   public List<String> findAllParents(Table table)
   {
	   List<String> parents = new ArrayList<>();
	   
	   boolean child = false;
	   for (ForeignKey foreignKey : table.getForeignkeys())
	   {
			for (FKPairs pair : foreignKey.getFkpairs())
			{
				Column column = table.getColumnByName(pair.getReferencing());
				
				if (column.isPrimaryKey())
				{
					child = true;
				}
				else
				{
					child = false;
				}
			}
			
			if (child)
			{
				parents.add(foreignKey.getReferencedTable());
			}
	   }
	   
	   return parents;
   }
}