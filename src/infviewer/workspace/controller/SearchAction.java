/***********************************************************************
 * Module:  SearchAction.java
 * Author:  Duka
 * Purpose: Defines the Class SearchAction
 ***********************************************************************/

package infviewer.workspace.controller;

import infviewer.tree.model.Table;
import infviewer.workspace.view.CustomTable;
import infviewer.workspace.view.SearchDialogView;

public class SearchAction extends WorkspaceAction 
{
	private static final long serialVersionUID = -7825896404189504088L;	
	private SearchDialogView searchActionDialog;
	private CustomTable customTable;
	
	public SearchAction(Table table) {
		super(table);
		searchActionDialog = new SearchDialogView(table);
		
	}

   public void doAction() {
	  searchActionDialog = new SearchDialogView(table);
	  searchActionDialog.setCustomTable(customTable);
	  searchActionDialog.setVisible(true);

   }

    public CustomTable getCustomTable() {
        return customTable;
    }
    
    public void setCustomTable(CustomTable customTable) {
        this.customTable = customTable;
        this.searchActionDialog.setCustomTable(customTable);
    }

}