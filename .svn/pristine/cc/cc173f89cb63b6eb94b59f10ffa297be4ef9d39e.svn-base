package infviewer.workspace.view;

import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;

import infviewer.app.ApplicationSingleton;
import infviewer.tree.model.ForeignKey;
import infviewer.tree.model.Table;

public class ChildTabbedView extends TabbedView 
{
	private static final long serialVersionUID = -1801827442384122763L;
	
	@Override
	public JPanel createTab(Table table)
	{
		String title = "";
		
		String parentName = ((Table)((DefaultMutableTreeNode)ApplicationSingleton.getInstance()
							.getApplicationMainFrame()
							.getTreeView()
							.getTree()
							.getLastSelectedPathComponent())
				            .getUserObject()).getName();
		
		int childrenToPass = -1;

		for (Tab tab : this.getTabs())
		{
			if (tab.getTable().getName().equals(table.getName()))
			{
				childrenToPass++;
			}
		}
		
		int childrenCount = 0;
		for (ForeignKey foreignKey : table.getForeignkeys())
		{
			if (foreignKey.getReferencedTable().equals(parentName) && (++childrenCount) > childrenToPass)
			{
				title = foreignKey.getLabel();
				break;					
			}
		}
		
		return this.createUnclosableTab(title);
	}
}