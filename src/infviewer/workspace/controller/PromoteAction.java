/***********************************************************************
 * Module:  PromoteAction.java
 * Author:  Duka
 * Purpose: Defines the Class PromoteAction
 ***********************************************************************/

package infviewer.workspace.controller;

import infviewer.tree.model.Table;

/**
 * Klasa <code>PromoteAction</code> vrši promovisanje tabele. 
 * Nasleđuje klasu <code>WorkspaceAction</code>. 
 * @see infviewer.workspace.controller.WorkspaceAction
 * @author DrGoz
 *
 */
public class PromoteAction extends WorkspaceAction 
{
	private static final long serialVersionUID = 9144516471784700374L;

	public PromoteAction(Table table) {
		super(table);
	}

/**
 * U metodi se poziva klasa {@link Promote} koja pozivom metode <code>promote</code> vrši promovisanje
 * prosleđene tabele. Tabela se prosleđuje tako što se prosledi ime tabele kao parametar.
 */
   public void doAction() 
   {  
	    Promote.promote(this.table.getName());
   }
}