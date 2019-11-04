package infviewer.tree.view;

import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import infviewer.model.Element;
import infviewer.tree.model.Package;
import infviewer.tree.model.Table;

public class CustomTreeRenderer extends DefaultTreeCellRenderer{
	
	private static final long serialVersionUID = 4905103914733056702L;
	private static final ImageIcon PACKAGE_ICON = new ImageIcon("resources/images/package_icon.png");
	private static final ImageIcon TABLE_ICON = new ImageIcon("resources/images/table_icon.png");
	
	public CustomTreeRenderer() 
	{
		this.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
	}
	
	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
		
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
		Object object = node.getUserObject();
		
		if (object instanceof Element) 
		{
			this.setText(((Element)object).getLabel());
		}
		
		if (object instanceof Package)
		{
			this.setIcon(PACKAGE_ICON);
		}
		else if (object instanceof Table)
		{
			this.setIcon(TABLE_ICON);
		}

		return this;
	}
}