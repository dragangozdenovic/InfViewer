package infviewer.workspace.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JPanel;

import infviewer.app.ApplicationSingleton;
import infviewer.tree.model.Table;
import infviewer.workspace.controller.PromoteAction;

public class ChildButtonPane extends ButtonPane 
{
	private static final long serialVersionUID = 7894145550499558863L;
	private JPanel promotePanel;
	private JButton promote;
	private ResourceBundle resourceBundle = ApplicationSingleton.getInstance().getResourceBundle();
	
	public ChildButtonPane(Table table) 
	{
		super(table);
		
		this.promotePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));

		this.promote = new JButton(resourceBundle.getString("promote"));		
		this.promote.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		this.promote.addActionListener(new PromoteAction(table));
		
		this.promotePanel.add(promote);
		
		this.add(this.promotePanel, BorderLayout.EAST);
	}
}