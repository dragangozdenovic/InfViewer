package infviewer.view;

import java.awt.BorderLayout;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import infviewer.app.ApplicationSingleton;
import infviewer.tree.view.TreeView;
import infviewer.workspace.view.TabbedView;

public class ApplicationMainFrame extends JFrame
{
	private static final long serialVersionUID = -5523104478017713093L;
	private ApplicationMenuBar menuBar;
	private ApplicationToolbar toolBar;
	private TreeView treeView;
	public static Rectangle windowSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
	private JSplitPane splitPane;

	public ApplicationMainFrame() 
	{
		this.setTitle("InfViewer");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(3 * windowSize.width / 4, 9 * windowSize.height / 10);
		this.setLocationRelativeTo(null);
        
        this.menuBar = new ApplicationMenuBar();
        setJMenuBar(this.menuBar);
       
        this.toolBar = new ApplicationToolbar();
        add(this.toolBar, BorderLayout.NORTH);
        
        this.treeView = new TreeView();
        
        TabbedView parentView = new TabbedView();
        ApplicationSingleton.getInstance().setParentView(parentView);
        
        this.splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeView, parentView);
        this.splitPane.setOneTouchExpandable(true);
        
        this.add(splitPane, BorderLayout.CENTER);
	}

	public TreeView getTreeView() {
		return treeView;
	}
}