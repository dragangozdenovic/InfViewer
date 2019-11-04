package infviewer.workspace.controller;

import java.awt.event.ActionEvent;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import infviewer.app.ApplicationSingleton;
import infviewer.editor.controller.JSONValidator;
import infviewer.tree.model.Table;
import infviewer.workspace.model.Row;
import infviewer.workspace.view.CustomTable;
import infviewer.workspace.view.CustomTableModel;
import infviewer.workspace.view.Tab;
import infviewer.workspace.view.TabbedView;

public class DeleteAction extends AbstractAction{

	private static final long serialVersionUID = 3693119556087729385L;
	private Table table;
	private CustomTable customTable;
	private ResourceBundle resourceBundle = ApplicationSingleton.getInstance().getResourceBundle();
	
	public DeleteAction(Table table) {
		this.setTable(table);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (this.customTable == null || this.customTable.getSelectedRow() == -1)
    	{
    		JOptionPane.showMessageDialog(ApplicationSingleton.getInstance().getApplicationMainFrame(), resourceBundle.getString("rowWarning"), resourceBundle.getString("warningHeader"), JOptionPane.WARNING_MESSAGE);
    	}
    	else
    	{
    		int rowIndexToDelete = this.customTable.getSelectedRow();
    		Row row = table.getRows().get(rowIndexToDelete);
    		
    		if (!ApplicationSingleton.getInstance().getFactory().createCRUD().delete(row, table))
    		{
    			JOptionPane.showMessageDialog(null, resourceBundle.getString("deleteError"), resourceBundle.getString("errorHeader"), JOptionPane.ERROR_MESSAGE);
    			return;
    		}
    		table.removeRows(table.getRows().get(rowIndexToDelete));
  
    	    ((CustomTableModel)customTable.getModel()).setData(table.getRows());
    	    
    	    JOptionPane.showMessageDialog(null, resourceBundle.getString("rowDeleted"), resourceBundle.getString("successHeader"), JOptionPane.INFORMATION_MESSAGE, JSONValidator.SUCCESS_ICON);

    		TabbedView parentView = ApplicationSingleton.getInstance().getParentView();
			if (parentView.getSelectedIndex() != -1)
			{
				Tab tab = parentView.getTabs().get(parentView.getSelectedIndex());
				if (tab.getTable().getName().equals(customTable.getTable().getName()) && tab.getChildView() != null)
				{
					for (Tab childTab : tab.getChildView().getTabs())
					{
						List<Row> rows = ApplicationSingleton
								.getInstance()
								.getFactory()
								.createCRUD()
								.read(childTab.getTable(), null);
							
						childTab.getTable().setRows(rows);
						childTab.getParentView().getTableScrollPane().getTable().setData(rows);
					}
					
				}
			
		    }
			
    	}
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public CustomTable getCustomTable() {
		return customTable;
	}

	public void setCustomTable(CustomTable customTable) {
		this.customTable = customTable;
	}
	
	
}
