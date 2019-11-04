package infviewer.workspace.view;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;

import infviewer.tree.model.Table;
import infviewer.view.ApplicationMainFrame;

public class ZoomButtonDialog extends JDialog 
{
	private static final long serialVersionUID = 8628786562662852925L;
	
	public ZoomButtonDialog(JComponent relativeTo, Table table)
	{
		this.setTitle(table.getLabel());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(ApplicationMainFrame.windowSize.width / 4, ApplicationMainFrame.windowSize.height / 3);
		this.setResizable(false);
		this.setLocation((int)relativeTo.getLocationOnScreen().getX() + relativeTo.getWidth(), (int)relativeTo.getLocationOnScreen().getY() - 28);
		this.setModal(true);
		
		TableScrollPane tableScrollPane = new TableScrollPane(table);
		tableScrollPane.getTable().setEnabled(false);
		this.add(tableScrollPane);
	}
}