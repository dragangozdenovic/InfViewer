package infviewer.workspace.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JPanel;

import infviewer.app.ApplicationSingleton;
import infviewer.tree.model.Table;
import infviewer.workspace.controller.AddAction;
import infviewer.workspace.controller.DeleteAction;
import infviewer.workspace.controller.SearchAction;
import infviewer.workspace.controller.UpdateAction;
import infviewer.workspace.controller.WorkspaceAction;

public class ButtonPane extends JPanel
{
	private static final long serialVersionUID = 8225788200758262321L;
	protected JPanel crudButtonPane;
	protected JButton addButton;
	protected JButton deleteButton;
	protected JButton updateButton;
	protected JButton searchButton;
	protected WorkspaceAction updateAction;
	protected WorkspaceAction addAction;
	protected DeleteAction deleteAction;
	protected SearchAction searchAction;
	protected Table table;
	private ResourceBundle resourceBundle;
	
	public ButtonPane(Table table) 
	{
		super(new BorderLayout());
		
		this.resourceBundle = ApplicationSingleton.getInstance().getResourceBundle();
		this.addAction = new AddAction(table);
		this.addButton = new JButton(resourceBundle.getString("addOption"));
		this.addButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		this.addButton.addActionListener(this.addAction);
		
		this.deleteAction = new DeleteAction(table);
		this.deleteButton = new JButton(resourceBundle.getString("deleteOption"));
		this.deleteButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		this.deleteButton.addActionListener(this.deleteAction);
			
		this.updateAction = new UpdateAction(table);
		this.updateButton = new JButton(resourceBundle.getString("updateOption"));
		this.updateButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		this.updateButton.addActionListener(this.updateAction);
		
	    this.searchAction = new SearchAction(table);
		this.searchButton = new JButton(resourceBundle.getString("searchOption"));
		this.searchButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		this.searchButton.addActionListener(this.searchAction);
		
		this.crudButtonPane = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		this.crudButtonPane.add(addButton);
		this.crudButtonPane.add(deleteButton);
		this.crudButtonPane.add(updateButton);
		this.crudButtonPane.add(searchButton);
		
		this.add(crudButtonPane, BorderLayout.WEST);
		
		this.table = table;
	}
	
	public void passCustomTableToActions(CustomTable customTable)
	{
		((UpdateAction)this.updateAction).setCustomTable(customTable);
		((AddAction)this.addAction).setCustomTable(customTable);
		((DeleteAction)this.deleteAction).setCustomTable(customTable);
		((SearchAction)this.searchAction).setCustomTable(customTable);
		
	}
}