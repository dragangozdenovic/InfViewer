/***********************************************************************
 * Module:  BooleanElement.java
 * Author:  Duka
 * Purpose: Defines the Class BooleanElement
 ***********************************************************************/

package infviewer.workspace.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.border.Border;

/** @pdOid 5fac8778-75de-4006-be29-03097b04e049 */
public class BooleanElement extends DialogElement {
	
	private TCheckBox booleanField;
	private Border invalidBorder = BorderFactory.createLineBorder(Color.RED, 2);
	
	public BooleanElement(boolean mandatory, String label)
	{
		super(mandatory, label);
		this.booleanField = new TCheckBox();
		this.booleanField.setBorderPainted(false);
		this.invalidBorder = BorderFactory.createLineBorder(Color.RED, 2);
	}
	
   /** @pdOid c75c3c2d-7e52-494e-9010-9befcd59fbfc */
   public JComponent createDialogElement() {
	   if (mandatory)
       {
    	    booleanField.addActionListener(new ActionListener() 
    	    {	
				@Override
				public void actionPerformed(ActionEvent arg0) {
					checkSelection();
				}
			});
       }
      
      return booleanField;
   }
	
   private void checkSelection()
   {
	   	if (booleanField.getSelectionState() == 2)
		{	
	   		if (!booleanField.getBorder().equals(invalidBorder))
	   		{
	   			booleanField.setBorder(invalidBorder);	   			
	   		}
			booleanField.setBorderPainted(true);
			setValid(false);
		}
		else
		{
			booleanField.setBorderPainted(false);
			setValid(true);
		}
   }
   
   @Override
   public void setValue(Object valueToSet) 
   {
	   int value = (valueToSet == null) ? 0 : ((boolean)valueToSet) ? 2 : 1;
	   this.booleanField.setSelectionState(value);
	   checkSelection();
   }

	@Override
	public Object getValue() 
	{
		if (this.booleanField.getSelectionState() == 0)
		{
			return null;
		}
		return this.booleanField.isSelected();
	}

	@Override
	public String validationMessage() 
	{
		if (!this.isValid())
		{
			return this.getValidationMessages().getValidationMessage("null"); 
		}
		return this.getValidationMessages().getValidationMessage("ok");
	}
}