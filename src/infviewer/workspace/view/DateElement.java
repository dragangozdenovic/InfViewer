/***********************************************************************
 * Module:  DateElement.java
 * Author:  Duka
 * Purpose: Defines the Class DateElement
 ***********************************************************************/

package infviewer.workspace.view;

import java.sql.Date;
import java.util.Locale;

import javax.swing.JComponent;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

/** @pdOid 929b9ac4-293b-4e69-ab9a-56e3d46ee324 */
public class DateElement extends DialogElement {
	
	private JDateChooser dateChooser;
	
    public DateElement(boolean mandatory, String label)
	{
		super(mandatory, label);
	}
    
   /** @pdOid 34fffd9f-387f-463c-994a-f08074e72312 */
   public JComponent createDialogElement() {
      dateChooser = new JDateChooser();
      dateChooser.setLocale(Locale.getDefault());
      return dateChooser;
   }
   
   @Override
   public void setValue(Object valueToSet) 
   {
	   if (valueToSet != null)
	   {
		   this.dateChooser.setDate((Date)valueToSet);		
	   }
   }
   
    @Override
	public Object getValue() 
	{
    	if (this.dateChooser.getDate() == null)
    	{
    		return null;
    	}
		return new Date(this.dateChooser.getDate().getTime());
	}
    
    public String getText()
    {
    	return ((JTextFieldDateEditor)this.dateChooser.getDateEditor()).getText();
    }

    @Override
    public String validationMessage()
    {
    	String text = ((JTextFieldDateEditor)this.dateChooser.getDateEditor()).getText();
    	if (text.isEmpty())
    	{
    		return this.getValidationMessages().getValidationMessage("empty");
    	}
    	else if (this.dateChooser.getDate() == null)
    	{
    		return this.getValidationMessages().getValidationMessage("format");
    	}
    	return this.getValidationMessages().getValidationMessage("ok");
    }
}