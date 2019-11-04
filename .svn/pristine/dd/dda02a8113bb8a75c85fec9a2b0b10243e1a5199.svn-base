package infviewer.editor.controller;

import java.awt.Image;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;

import infviewer.app.ApplicationSingleton;

public class JSONValidator implements infviewer.controller.Validator 
{
	public static final ImageIcon SUCCESS_ICON = new ImageIcon(new ImageIcon("resources/images/success.png").getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH));
	private Schema metaSchema;
	private ResourceBundle resourceBundle = ApplicationSingleton.getInstance().getResourceBundle();
	
    public boolean validate(Object objectToValidate) 
    {
    	if (metaSchema == null)
		{
			JOptionPane.showMessageDialog(null, resourceBundle.getString("schemaError"), resourceBundle.getString("errorHeader"), JOptionPane.ERROR_MESSAGE);
			return false;
		}
    	else if (objectToValidate == null || !(objectToValidate instanceof JSONObject))
    	{
    		JOptionPane.showMessageDialog(null, resourceBundle.getString("jsonError"), resourceBundle.getString("errorHeader"), JOptionPane.ERROR_MESSAGE);
			return false;
    	}
		
    	JSONObject schema = (JSONObject) objectToValidate;
    	
		try
		{
			metaSchema.validate(schema);
		}
		catch (ValidationException e) 
		{
			String allMessages = "";
			for (String message : e.getAllMessages())
			{
				allMessages += message + "\n";
			}
			JOptionPane.showMessageDialog(null, allMessages, "Error!", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
	    JOptionPane.showMessageDialog(null, "No errors found. JSON schema validates against the JSON meta-schema.", "Success!", JOptionPane.PLAIN_MESSAGE, SUCCESS_ICON);	
        return true;
    }

	public Schema getMetaSchema() {
		return metaSchema;
	}
	public static final JSONObject METASCHEMA = new JSONObject("{\"$schema\":\"http://json-schema.org/draft-07/schema#\",\"additionalProperties\":false,\"title\":\"Meta-sema\",\"type\":\"object\",\"definitions\":{\"package\":{\"additionalProperties\":false,\"type\":\"object\",\"properties\":{\"tables\":{\"type\":\"array\",\"items\":{\"additionalProperties\":false,\"type\":\"object\",\"properties\":{\"foreignKeys\":{\"description\":\"Niz stranih kljuceva tabele\",\"type\":\"array\",\"items\":{\"additionalProperties\":false,\"type\":\"object\",\"properties\":{\"referencedTable\":{\"description\":\"Naziv tabele koja je referencirana\",\"$ref\":\"#/definitions/stringType\"},\"relationName\":{\"description\":\"Opis relacije izmedju referencirane i referencirajuce tabele\",\"$ref\":\"#/definitions/stringType\"},\"label\":{\"description\":\"Labela za vizuelni prikaz\",\"$ref\":\"#/definitions/stringType\"},\"pairs\":{\"description\":\"Par koji predstavlja kolonu iz referencirane i kolonu iz referencirajuce tabele\",\"type\":\"array\",\"items\":{\"additionalProperties\":false,\"type\":\"object\",\"properties\":{\"referencing\":{\"description\":\"Naziv kolone koja referencira\",\"$ref\":\"#/definitions/stringType\"},\"referenced\":{\"description\":\"Naziv kolone koja je referencirana\",\"$ref\":\"#/definitions/stringType\"}},\"required\":[\"referenced\",\"referencing\"]}}},\"required\":[\"referencedTable\",\"relationName\",\"label\",\"pairs\"]}},\"columns\":{\"type\":\"array\",\"items\":{\"additionalProperties\":false,\"type\":\"object\",\"properties\":{\"dataType\":{\"description\":\"Tip podataka za vrednost u koloni\",\"type\":\"string\",\"enum\":[\"boolean\",\"int\",\"float\",\"varchar\",\"date\",\"char\"]},\"precision\":{\"description\":\"Broj cifara vrednosti u koloni\",\"type\":\"integer\",\"minimum\":1},\"length\":{\"description\":\"Duzina vrednosti u koloni\",\"type\":\"integer\",\"minimum\":1},\"label\":{\"description\":\"Labela za vizuelni prikaz\",\"$ref\":\"#/definitions/stringType\"},\"PK\":{\"description\":\"True vrednost ako je kolona primarni kljuc, false u suprotnom\",\"type\":\"boolean\"},\"mandatory\":{\"description\":\"Da li je kolona obavezna za popunjavanje\",\"type\":\"boolean\"},\"columnName\":{\"description\":\"Naziv kolone\",\"$ref\":\"#/definitions/stringType\"}},\"required\":[\"columnName\",\"label\",\"dataType\",\"PK\",\"mandatory\"]}},\"label\":{\"description\":\"Labela za vizuelni prikaz\",\"$ref\":\"#/definitions/stringType\"},\"tableName\":{\"description\":\"Naziv jednog entiteta\",\"$ref\":\"#/definitions/stringType\"}},\"required\":[\"tableName\",\"label\",\"columns\"]}},\"packageName\":{\"description\":\"Ime paketa u kojoj se nalazi opis informacionog resursa\",\"$ref\":\"#/definitions/stringType\"},\"label\":{\"description\":\"Labela za vizuelni prikaz\",\"$ref\":\"#/definitions/stringType\"},\"packages\":{\"type\":\"array\",\"items\":{\"$ref\":\"#/definitions/package\"}},\"packageType\":{\"description\":\"Tip paketa\",\"type\":\"string\",\"enum\":[\"package\",\"subpackage\"]}},\"required\":[\"packageName\",\"label\",\"packageType\"]},\"stringType\":{\"minLength\":2,\"type\":\"string\",\"maxLength\":30}},\"properties\":{\"package\":{\"$ref\":\"#/definitions/package\"}}}");
	
	public static Schema getMetaSchemaa(JSONObject metaschema2)
	{
		return SchemaLoader.load(METASCHEMA);
	}


	public void setMetaSchema(Schema metaSchema) {
		this.metaSchema = metaSchema;
	}
}