package infviewer.workspace.view;

import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.text.AbstractDocument;

import infviewer.miscellaneous.IntegerDocumentFilter;

public class IntegerRangeElement extends RangeElement
{
	private RangeTextField integerRangeTextField;
	private int length;
	
	public IntegerRangeElement(StartEndPoints endPoint, int length)
	{
		super(endPoint);
    	this.length = length;
	}
	
	@Override
	public JComponent createDialogElement() {
		integerRangeTextField = new RangeTextField(endPoint);
		integerRangeTextField.setPreferredSize(new Dimension(125, 25));
        ((AbstractDocument)integerRangeTextField.getDocument()).setDocumentFilter(new IntegerDocumentFilter(integerRangeTextField, this.length));
		return integerRangeTextField;
	}
	
	@Override
    public void setValue(Object valueToSet) 
    {
	    if (valueToSet != null)
	    {
		    this.integerRangeTextField.setText(valueToSet.toString());		   
	    }
    }

	@Override
	public Object getValue() {
	    if (this.integerRangeTextField.getText().isEmpty())
        {
            return null;
        }
		return this.integerRangeTextField.getText();
	}
}
