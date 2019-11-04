/***********************************************************************
 * Module:  Promote.java
 * Author:  Duka
 * Purpose: Defines the Class Promote
 ***********************************************************************/

package infviewer.workspace.controller;

import javax.swing.tree.DefaultMutableTreeNode;

import infviewer.app.ApplicationSingleton;
import infviewer.tree.model.Table;
import infviewer.workspace.view.ChildTabbedView;
import infviewer.workspace.view.TabbedView;

/**
 * Klasa sadrži metodu {@code promote} koja sluzi promovisanju deteta u roditelja
 * odnosno depromovisanju roditelja u red potomaka.
 * @author DrGoz
 *
 */
public class Promote {
	/**
	 * 
	 * @param tableName Naziv tabele cije ce se promovisanje, odnosno depromovisanje obaviti.
	 */
	public static void promote(String tableName) 
   {
	    DefaultMutableTreeNode root = (DefaultMutableTreeNode)ApplicationSingleton.getInstance().getApplicationMainFrame().getTreeView().getTree().getModel().getRoot();
	    DefaultMutableTreeNode tableNode = (DefaultMutableTreeNode)ApplicationSingleton.getInstance().getApplicationMainFrame().getTreeView().getTree().find(root, tableName).get(0);
	    Table table = (Table)tableNode.getUserObject();
	    
		if (ApplicationSingleton.getInstance().getParentView().isTabExists(table))
		{
			ApplicationSingleton.getInstance().getParentView().selectTab(table);
		}
		else if (tableNode.getChildCount() == 0)
		{
			table.setRows(ApplicationSingleton
					.getInstance()
					.getFactory()
					.createCRUD()
					.read(table, null));
			
			ApplicationSingleton.getInstance().getParentView().addTab(table);
		}
		else if (tableNode.getChildCount() > 0)
		{
			TabbedView childView = new ChildTabbedView();
			for(int i = 0; i < tableNode.getChildCount(); i++)
			{
				DefaultMutableTreeNode child = (DefaultMutableTreeNode)tableNode.getChildAt(i);
				
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