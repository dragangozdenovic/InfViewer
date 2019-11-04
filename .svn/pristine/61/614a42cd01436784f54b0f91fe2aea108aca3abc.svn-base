package infviewer.workspace.view;

import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.text.AbstractDocument;

import infviewer.miscellaneous.FloatDocumentFilter;

public class FloatRangeElement extends RangeElement 
{
	private RangeTextField floatRangeTextField;
	private int length;
	private int precision;
	
	public FloatRangeElement(StartEndPoints endPoint, int length, int precision)
	{
		super(endPoint);
    	this.length = length;
    	this.precision = precision;
	}
	
	@Override
	public JComponent createDialogElement() {
		floatRangeTextField = new RangeTextField(endPoint);
		floatRangeTextField.setPreferredSize(new Dimension(125, 25));
        ((AbstractDocument)floatRangeTextField.getDocument()).setDocumentFilter(new FloatDocumentFilter(floatRangeTextField, this.length, this.precision));
		return floatRangeTextField;
	}
	
	@Override
    public void setValue(Object valueToSet) 
    {
	    if (valueToSet != null)
	    {
		    this.floatRangeTextField.setText(valueToSet.toString());		   
	    }
    }

	@Override
	public Object getValue() {
	    if (this.floatRangeTextField.getText().isEmpty())
        {
            return null;
        }
        return this.floatRangeTextField.getText();
	}
}