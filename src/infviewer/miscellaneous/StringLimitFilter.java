package infviewer.miscellaneous;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class StringLimitFilter extends DocumentFilter 
{
	private int length;
	
	public StringLimitFilter(int length) 
	{
		this.length = length;
	}
	
    @Override
    public void insertString(FilterBypass fb, int offset, String str, AttributeSet attrs) throws BadLocationException 
    {
    	if (fb.getDocument().getLength() < this.length)
    	{
    		super.insertString(fb, offset, str, attrs);    		
    	}
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String str, AttributeSet attrs) throws BadLocationException 
    {
    	if (fb.getDocument().getLength() < this.length)
    	{
        	fb.replace(offset, length, str, attrs);
        }
    }
}