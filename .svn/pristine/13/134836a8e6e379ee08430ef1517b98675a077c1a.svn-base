package infviewer.workspace.view;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import infviewer.tree.model.Table;

public class Tab extends JPanel 
{
	private static final long serialVersionUID = -3236294858159504208L;
	private TabPane parentView;
	private TabbedView childView;
	private Table table;
	
	public Tab(Table table, TabbedView childView) 
	{
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.table = table;
		parentView = new TabPane(table, new ParentButtonPane(table));
		this.add(parentView);
		this.childView = childView;
		this.add(childView);
	}
	
	public Tab(Table table, ButtonPane buttonPane) 
	{
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.table = table;
		parentView = new TabPane(table, buttonPane);
		this.add(parentView);
	}
	
	public TabPane getParentView() {
		return parentView;
	}

	public void setParentView(TabPane parentView) {
		this.parentView = parentView;
	}

	public TabbedView getChildView() {
		return childView;
	}

	public void setChildView(TabbedView childView) {
		this.childView = childView;
	}

	public Table getTable() {
		return this.table;
	}
}
