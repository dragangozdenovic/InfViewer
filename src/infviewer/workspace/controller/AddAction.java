/***********************************************************************
 * Module:  AddAction.java
 * Author:  Duka
 * Purpose: Defines the Class AddAction
 ***********************************************************************/

package infviewer.workspace.controller;


import infviewer.tree.model.Table;
import infviewer.workspace.view.AddDialogView;
import infviewer.workspace.view.CustomTable;

public class AddAction extends WorkspaceAction 
{
	private static final long serialVersionUID = -468658134160287846L;
	private AddDialogView addActionDialog;
	private CustomTable customTable;

	public AddAction(Table table) {
		super(table);
		addActionDialog = new AddDialogView(table);
	}

   public void doAction() {
	   addActionDialog = new AddDialogView(table);
	   addActionDialog.setCustomTable(customTable);
	   addActionDialog.setVisible(true);
   }
   
   public CustomTable getCustomTable() {
   	return customTable;
	}
	
	public void setCustomTable(CustomTable customTable) {
		this.customTable = customTable;
		this.addActionDialog.setCustomTable(customTable);
	}
}