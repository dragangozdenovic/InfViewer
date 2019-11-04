package infviewer.workspace.view;

import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;

import infviewer.miscellaneous.StringLimitFilter;
import infviewer.workspace.controller.DocumentChangedAction;

public class CharElement extends DialogElement {

	private JTextField charField;
    private int length;
    
	public CharElement(int length, boolean mandatory, String label)
	{
		super(mandatory, label);
		this.length = length;
	}
	
	public JComponent createDialogElement() 
    {
    	charField = new JTextField();
    	charField.setPreferredSize(new Dimension(125, 25));
    	((AbstractDocument)charField.getDocument()).setDocumentFilter(new StringLimitFilter(this.length));
    	
    	if (this.mandatory)
  	    {
    		charField.getDocument().addDocumentListener(new DocumentChangedAction(charField, this.length, this));
  	    }
    	
    	return charField;
    }

	@Override
	public void setValue(Object valueToSet) 
	{
		if (valueToSet != null) 
		{
			this.charField.setText(valueToSet.toString());		   
		}
	}
	
	
	@Override
	public Object getValue() 
	{
		return this.charField.getText();
	}
	
	@Override
	public String validationMessage() 
	{
		if (this.charField.getText().isEmpty())
		{
			return this.getValidationMessages().getValidationMessage("empty");
		}
		else if (this.charField.getText().length() != this.length)
		{
			return this.getValidationMessages().getValidationMessage("length");
		}
		return this.getValidationMessages().getValidationMessage("ok");
	}
}