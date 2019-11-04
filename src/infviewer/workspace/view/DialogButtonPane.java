package infviewer.workspace.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JPanel;

import infviewer.app.ApplicationSingleton;
import infviewer.tree.model.Table;

public class DialogButtonPane extends JPanel {

	private static final long serialVersionUID = 8345698825418442875L;
	protected JPanel buttonPane;
	protected JButton okButton;
	protected JButton cancelButton;
	protected Table table;
	private ResourceBundle resourceBundle = ApplicationSingleton.getInstance().getResourceBundle();
	
	public DialogButtonPane(Table table, String name) 
	{
		super(new BorderLayout());
		this.okButton = new JButton(name);
		this.okButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		this.cancelButton = new JButton(resourceBundle.getString("cancelOption"));
		this.cancelButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

		this.buttonPane = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		
		this.buttonPane.add(okButton);
		this.buttonPane.add(cancelButton);
		
		this.add(buttonPane, BorderLayout.EAST);
	    
		this.table = table;
	}
	
	public JButton getOkButton()
	{
		return this.okButton;
	}
	
	public JButton getCancelButton()
	{
		return this.cancelButton;
	}
	
	public JPanel getButtonPane()
	{
		return this.buttonPane;
	}
}