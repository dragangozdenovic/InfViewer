package infviewer.workspace.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

import infviewer.app.ApplicationSingleton;
import infviewer.tree.model.Table;
import infviewer.workspace.controller.DemoteAction;

public class ParentButtonPane extends ButtonPane 
{
	private static final long serialVersionUID = 1466301602034699174L;
	private JPanel demotePanel;
	private JButton demote;
	
	public ParentButtonPane(Table table) 
	{
		super(table);
		
		this.demotePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));

		this.demote = new JButton(ApplicationSingleton.getInstance().getResourceBundle().getString("demote"));		
		this.demote.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		this.demote.addActionListener(new DemoteAction(table));
		
		this.demotePanel.add(demote);
		
		this.add(this.demotePanel, BorderLayout.EAST);
	}
}
