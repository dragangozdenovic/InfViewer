/***********************************************************************
 * Module:  TreeView.java
 * Author:  ra29-2015
 * Purpose: Defines the Class TreeView
 ***********************************************************************/

package infviewer.tree.view;

import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.tree.DefaultTreeModel;

import infviewer.view.ApplicationMainFrame;

public class TreeView extends JScrollPane 
{	
	private static final long serialVersionUID = 2471472613967907597L;
	private ApplicationTree tree;
	
	public TreeView() 
	{
		this.tree = new ApplicationTree(new DefaultTreeModel(null));
		this.setViewportView(this.tree);
        this.setPreferredSize(new Dimension(ApplicationMainFrame.windowSize.width / 6, 0));
        this.setMinimumSize(new Dimension(ApplicationMainFrame.windowSize.width / 8, 0));
	}

	public ApplicationTree getTree() {
		return tree;
	}
}