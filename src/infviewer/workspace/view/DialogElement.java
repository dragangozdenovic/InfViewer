package infviewer.workspace.view;

import infviewer.workspace.miscellaneous.ValidationMessages;

public abstract class DialogElement implements DialogElementInterface 
{
	protected boolean valid;
    protected boolean mandatory;
    protected String label;
    protected ValidationMessages validationMessages;
    
    public DialogElement(boolean mandatory, String label)
    {
    	this.mandatory = mandatory;
    	this.valid = !mandatory;
    	this.validationMessages = new ValidationMessages(label);
    }
    
	public boolean isValid()
	{
		return this.valid;
	}
	
	public void setValid(boolean valid)
	{
		this.valid = valid;
	}
	
	public String validationMessage() { return null; }

	public ValidationMessages getValidationMessages() {
		return validationMessages;
	} 
}