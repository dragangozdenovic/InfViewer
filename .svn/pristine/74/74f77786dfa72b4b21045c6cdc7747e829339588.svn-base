/***********************************************************************
 * Module:  IntegerElement.java
 * Author:  Duka
 * Purpose: Defines the Class IntegerElement
 ***********************************************************************/

package infviewer.workspace.view;

import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;

import infviewer.miscellaneous.IntegerDocumentFilter;
import infviewer.workspace.controller.DocumentChangedAction;

/** @pdOid 8a46f971-75f6-44c0-9abe-d7a045e0f7c1 */
public class IntegerElement extends DialogElement {
	
	private JTextField integerField;
	private int length;
	
    public IntegerElement(boolean mandatory, int length, String label)
	{
    	super(mandatory, label);
    	this.length = length;
	}
    
   /** @pdOid a7f66353-89ef-4e41-90a1-07ebc49bde8d */
   public JComponent createDialogElement() {
       integerField = new JTextField();
       integerField.setPreferredSize(new Dimension(125, 25));
       ((AbstractDocument)integerField.getDocument()).setDocumentFilter(new IntegerDocumentFilter(integerField, this.length));

       if (this.mandatory)
 	   {
    	   integerField.getDocument().addDocumentListener(new DocumentChangedAction(integerField, 0, this));
 	   }
       
       return integerField;
   }

    @Override
    public void setValue(Object valueToSet) 
    {
    	if (valueToSet != null)
    	{
    		this.integerField.setText(valueToSet.toString());		   
    	}
    }
   
    @Override
	public Object getValue() 
	{
    	if (this.integerField.getText().isEmpty())
    	{
    		return null;
    	}
		return this.integerField.getText();
	}
}