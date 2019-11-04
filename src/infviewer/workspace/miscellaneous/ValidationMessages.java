package infviewer.workspace.miscellaneous;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import infviewer.app.ApplicationSingleton;

public class ValidationMessages 
{
	private Map<String, String> validationMessages = new HashMap<String, String>();
	private ResourceBundle resourceBundle = ApplicationSingleton.getInstance().getResourceBundle();

	public ValidationMessages(String fieldLabel)
	{
		validationMessages.put("ok", "'" + "OK");
		validationMessages.put("empty", "'" + fieldLabel + resourceBundle.getString("mustBeFilled"));
		validationMessages.put("length", "'" + fieldLabel + resourceBundle.getString("lengthValidationError"));
		validationMessages.put("format", "'" + fieldLabel + resourceBundle.getString("formatValidationError"));
		validationMessages.put("null", "'" + fieldLabel + resourceBundle.getString("nullValidationError"));
	}
	
	public String getValidationMessage(String key)
	{
		return validationMessages.get(key);
	}	
}