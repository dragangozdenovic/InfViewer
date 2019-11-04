/***********************************************************************
 * Module:  FloatElement.java
 * Author:  Duka
 * Purpose: Defines the Class FloatElement
 ***********************************************************************/

package infviewer.workspace.view;

import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;

import infviewer.miscellaneous.FloatDocumentFilter;
import infviewer.workspace.controller.DocumentChangedAction;

/** @pdOid 3106f39f-f0d4-4a13-b378-b387431caa63 */
public class FloatElement extends DialogElement {
	
	private JTextField floatField;
	private int length;
	private int precision;
	
    public FloatElement(boolean mandatory, int length, int precision, String label)
	{
    	super(mandatory, label);
    	this.length = length;
    	this.precision = precision;
	}
    
   /** @pdOid 5f376150-8741-416d-bd78-2d2c6d537e9d */
   public JComponent createDialogElement() {
      floatField = new JTextField();
      floatField.setPreferredSize(new Dimension(125, 25));
      ((AbstractDocument)floatField.getDocument()).setDocumentFilter(new FloatDocumentFilter(floatField, this.length, this.precision));

      if (this.mandatory)
	  {
		  floatField.getDocument().addDocumentListener(new DocumentChangedAction(floatField, 0, this));
	  }
      
      return floatField;
   }

   @Override
   public void setValue(Object valueToSet) 
   {
	   if (valueToSet != null)
	   {
		   this.floatField.setText(valueToSet.toString());		   
	   }
   }
   
    @Override
	public Object getValue() 
	{
    	if (this.floatField.getText().isEmpty())
    	{
    		return null;
    	}
		return this.floatField.getText();
	}
}