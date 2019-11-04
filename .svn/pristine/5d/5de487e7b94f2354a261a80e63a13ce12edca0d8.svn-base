/***********************************************************************
 * Module:  UpdateAction.java
 * Author:  Duka
 * Purpose: Defines the Class UpdateAction
 ***********************************************************************/

package infviewer.workspace.controller;

import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import infviewer.app.ApplicationSingleton;
import infviewer.tree.model.Table;
import infviewer.workspace.view.CustomTable;
import infviewer.workspace.view.UpdateDialogView;

public class UpdateAction extends WorkspaceAction 
{
	private static final long serialVersionUID = 7238602079532658820L;
	private ResourceBundle resourceBundle = ApplicationSingleton.getInstance().getResourceBundle();
	
	private UpdateDialogView updateActionDialog;
	private CustomTable customTable;

	public UpdateAction(Table table) {
		super(table);
		updateActionDialog = new UpdateDialogView(table);
	}

    public void doAction() {
		updateActionDialog = new UpdateDialogView(table);
		this.updateActionDialog.setCustomTable(customTable);

    	if (this.customTable == null || this.customTable.getSelectedRow() == -1)
    	{
    		JOptionPane.showMessageDialog(ApplicationSingleton.getInstance().getApplicationMainFrame(), resourceBundle.getString("rowWarning"), resourceBundle.getString("warningHeader"), JOptionPane.WARNING_MESSAGE);
    	}
    	else
    	{
    		updateActionDialog.setFieldValues(this.customTable.getSelectedRow());
    		updateActionDialog.setVisible(true);
    	}
    }
    
    public CustomTable getCustomTable() {
    	return customTable;
	}
	
	public void setCustomTable(CustomTable customTable) {
		this.customTable = customTable;
		this.updateActionDialog.setCustomTable(customTable);

	}
}