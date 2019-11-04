package infviewer.tree.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.tree.DefaultMutableTreeNode;

import infviewer.app.ApplicationSingleton;
import infviewer.tree.model.Table;
import infviewer.tree.view.ApplicationTree;
import infviewer.workspace.view.ChildTabbedView;
import infviewer.workspace.view.TabbedView;

public class TreeMouseListener extends MouseAdapter
{
	private ApplicationTree tree;
	
	public TreeMouseListener(ApplicationTree tree) 
	{
		this.tree = tree;
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		int row = tree.getRowForLocation(e.getX(),e.getY());
	    if (row == -1)
	    {
	    	return;
	    }
	    
	    DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
		if (e.getClickCount() == 2 && currentNode.getUserObject() instanceof Table)
		{
			Table table = (Table)currentNode.getUserObject();
			
			if (ApplicationSingleton.getInstance().getParentView().isTabExists(table))
			{
				ApplicationSingleton.getInstance().getParentView().selectTab(table);
			}
			else if (currentNode.getChildCount() == 0)
			{
				table.setRows(ApplicationSingleton
						.getInstance()
						.getFactory()
						.createCRUD()
						.read(table, null));
				
				ApplicationSingleton.getInstance().getParentView().addTab(table);
			}
			else if (currentNode.getChildCount() > 0)
			{
				TabbedView childView = new ChildTabbedView();
				for(int i = 0; i < currentNode.getChildCount(); i++)
				{
					DefaultMutableTreeNode child = (DefaultMutableTreeNode)currentNode.getChildAt(i);
					Table childTable = (Table)child.getUserObject();
					childTable.setRows(ApplicationSingleton
						.getInstance()
						.getFactory()
						.createCRUD()
						.read(childTable, null));
					childView.addTab(childTable);
				}
				
				table.setRows(ApplicationSingleton
						.getInstance()
						.getFactory()
						.createCRUD()
						.read(table, null));
				
				ApplicationSingleton.getInstance().getParentView().addTab(table, childView);
			}
		}
	}
	
}