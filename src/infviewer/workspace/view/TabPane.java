package infviewer.workspace.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import infviewer.tree.model.Table;

public class TabPane extends JPanel
{
	private static final long serialVersionUID = -868213526182909925L;
	private ButtonPane buttonPane;
	private TableScrollPane tableScrollPane;
	
	public TabPane(Table table, ButtonPane buttonPane) 
	{
		super(new BorderLayout());
		
		this.buttonPane = buttonPane;
		this.add(this.buttonPane, BorderLayout.NORTH);
		
		this.tableScrollPane = new TableScrollPane(table);
		this.add(tableScrollPane, BorderLayout.CENTER);
		
		this.buttonPane.passCustomTableToActions(this.tableScrollPane.getTable());
	}

	public TableScrollPane getTableScrollPane() {
		return tableScrollPane;
	}
}