package infviewer.miscellaneous;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 * Klasa koja filtrira unos karaktera u string tako da dozvoljava unos celih ili razlomljenih pozitivnih i negativnih brojeva u 32-bitnoj predstavi zadate duzine i preciznosti.
 */
public class FloatDocumentFilter extends DocumentFilter 
{
	private JTextField textField;
	private int length;
	private int precision;
	
	public FloatDocumentFilter(JTextField textField, int length, int precision)
	{
		this.textField = textField;
    	this.length = length;
    	this.precision = precision;
    	if (length > 0)
		{
			this.length = length;			
		}
		else
		{
			this.length = 5;
		}
	}
	
    @Override
    public void insertString(FilterBypass fb, int offset, String str, AttributeSet attrs) throws BadLocationException {
    	if (str == null || textField.getText().equals("0"))
        {
        	return;        	
        }
        try
        {
        	StringBuilder sb = new StringBuilder(textField.getText()).delete(textField.getSelectionStart(), textField.getSelectionEnd()).insert(offset, str);
        	String text = sb.toString();
        	float num = Float.parseFloat(text);
        	if (Math.log10(Math.abs(num)) > this.length)
        	{
        		return;
        	}
        	if (text.contains("."))
        	{
        		int nonDecimal = text.substring(0, text.indexOf(".")).length();
        		int decimalsAllowed = (nonDecimal <= (this.length - this.precision)) ? this.precision : this.length - nonDecimal;
        		if (text.substring(text.indexOf(".") + 1).length() > decimalsAllowed)
        		{
        			return;        			
        		}
        	}
        	super.insertString(fb, offset, str, attrs);
        }
        catch(Exception e) { }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String str, AttributeSet attrs) throws BadLocationException {
        if (str == null || textField.getText().equals("0"))
        {
        	return;        	
        }
        try
        {
        	StringBuilder sb = new StringBuilder(textField.getText()).delete(textField.getSelectionStart(), textField.getSelectionEnd()).insert(offset, str);
        	String text = sb.toString();
        	float num = Float.parseFloat(text);
        	if (Math.log10(Math.abs(num)) > this.length)
        	{
        		return;
        	}
        	if (text.contains("."))
        	{
        		int nonDecimal = text.substring(0, text.indexOf(".")).length();
        		int decimalsAllowed = (nonDecimal <= (this.length - this.precision)) ? this.precision : this.length - nonDecimal;
        		if (text.substring(text.indexOf(".") + 1).length() > decimalsAllowed)
        		{
        			return;        			
        		}
        	}
        	fb.replace(offset, length, str, attrs);
        }
        catch(Exception e) { }
    }
    
    @Override
	public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
    	try
        {
    		StringBuilder sb = new StringBuilder(textField.getText()).delete(offset, offset + length);
    		String text = sb.toString();
    		if (text.length() > 0)
    		{
    			Float.parseFloat(text);    			
    		}
    		fb.remove(offset, length);
        }
        catch(Exception e) { }
	}
}