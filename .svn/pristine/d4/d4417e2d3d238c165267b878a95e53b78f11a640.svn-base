package infviewer.workspace.view;

import javax.swing.JScrollPane;

import infviewer.tree.model.Table;

public class TableScrollPane extends JScrollPane
{
	private static final long serialVersionUID = 6242953477766736177L;
	private CustomTable customTable;
	
	public TableScrollPane(Table table) 
	{
		customTable = new CustomTable(table);
		this.setViewportView(customTable);
	}
		
	public CustomTable getTable() {
		return customTable;
	}
}