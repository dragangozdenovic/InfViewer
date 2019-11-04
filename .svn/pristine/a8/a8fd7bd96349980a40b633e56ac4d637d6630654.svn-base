package infviewer.miscellaneous;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 * Klasa koja filtrira unos karaktera u string tako da dozvoljava unos samo celih pozitivnih i negativnih brojeva u 32-bitnoj predstavi zadate duzine.
 */
public class IntegerDocumentFilter extends DocumentFilter 
{
	private JTextField textField;
	private int length;
	
	public IntegerDocumentFilter(JTextField textField, int length) 
	{
		this.textField = textField;
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
    	if (str == null || textField.getText().equals("0")  )
        {
        	return;
        }
        try
        {
        	StringBuilder sb = new StringBuilder(textField.getText()).delete(textField.getSelectionStart(), textField.getSelectionEnd()).insert(offset, str);
        	String text = sb.toString();
        	int num = Integer.parseInt(text);
        	if (Math.log10(Math.abs(num)) > this.length)
        	{
        		return;
        	}
        	super.insertString(fb, offset, str, attrs);
        }
        catch(Exception e) { }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String str, AttributeSet attrs) throws BadLocationException {
        if (str == null || textField.getText().equals("0") )
        {
        	return;        	
        }
        try
        {
        	StringBuilder sb = new StringBuilder(textField.getText()).delete(textField.getSelectionStart(), textField.getSelectionEnd()).insert(offset, str);
        	String text = sb.toString();
        	int num = Integer.parseInt(text);
        	if (Math.log10(Math.abs(num)) > this.length)
        	{
        		return;
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
    			Integer.parseInt(text);    			
    		}
    		fb.remove(offset, length);
        }
        catch(Exception e) { }
	}
}