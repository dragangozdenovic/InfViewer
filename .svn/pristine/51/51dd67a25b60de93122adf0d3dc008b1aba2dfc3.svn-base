package infviewer.workspace.view;

import java.sql.Date;
import java.util.Locale;

import javax.swing.JComponent;

import com.toedter.calendar.JDateChooser;

public class DateRangeElement extends RangeElement 
{	
	private JDateChooser dateChooser;
	
	public DateRangeElement(StartEndPoints endPoint)
	{
		super(endPoint);
	}
	
	@Override
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
	public Object getValue() {
	    if (this.dateChooser.getDate() == null)
        {
            return null;
        }
        return new Date(this.dateChooser.getDate().getTime());
	}
}