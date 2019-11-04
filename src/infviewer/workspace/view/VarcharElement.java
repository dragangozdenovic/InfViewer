/***********************************************************************
 * Module:  StringElement.java
 * Author:  Duka
 * Purpose: Defines the Class StringElement
 ***********************************************************************/

package infviewer.workspace.view;

import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;

import infviewer.miscellaneous.StringLimitFilter;
import infviewer.workspace.controller.DocumentChangedAction;

/** @pdOid b1e642a5-d250-4568-bbcc-36622716e9d1 */
public class VarcharElement extends DialogElement {
	
	private JTextField varcharField;
	private int length;
    
	public VarcharElement(int length, boolean mandatory, String label)
	{
		super(mandatory, label);
		this.length = length;
	}
	
   /** @pdOid b15e6315-9c1a-4352-884e-b953e1cb8f50 */
   public JComponent createDialogElement() {
	  varcharField = new JTextField();
	  varcharField.setPreferredSize(new Dimension(125, 25));
	  ((AbstractDocument)varcharField.getDocument()).setDocumentFilter(new StringLimitFilter(this.length));
	  
	  if (this.mandatory)
	  {
		  varcharField.getDocument().addDocumentListener(new DocumentChangedAction(varcharField, 0, this));
	  }
	  
      return varcharField;
   }

   @Override
   public void setValue(Object valueToSet) 
   {
	   if (valueToSet != null)
	   {
		   this.varcharField.setText(valueToSet.toString());		   
	   }
   }
	
	@Override
	public Object getValue() 
	{
		if (this.varcharField.getText().isEmpty())
		{
			return null;
		}
		return this.varcharField.getText();
	}

	@Override
	public String validationMessage() 
	{
		if (this.varcharField.getText().isEmpty())
		{
			return this.getValidationMessages().getValidationMessage("empty");
		}
		
		return this.getValidationMessages().getValidationMessage("ok");
	}
}