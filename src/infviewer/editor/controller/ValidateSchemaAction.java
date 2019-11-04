package infviewer.editor.controller;

import java.awt.event.ActionEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.JOptionPane;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import infviewer.app.ApplicationSingleton;
import infviewer.editor.EditorSingleton;
import infviewer.editor.view.MetaSchemaLoaderDialog;

public class ValidateSchemaAction extends Action 
{
	private static final long serialVersionUID = 704128921430273296L;
	private JSONObject currentSchema;
	private MetaSchemaLoaderDialog metaSchemaLoaderDialog;

	public ValidateSchemaAction(String name) 
	{
		super(name, "ctrl shift V");
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		JSONObject currentSchema;
		try
		{
			currentSchema = new JSONObject(EditorSingleton.getInstance().getEditorMainFrame().getEditorTextView().getEditorTextArea().getText());			
		}
		catch (Exception e1) 
		{
			errorSchemaMessage();
			return;
		}
		
		this.currentSchema = currentSchema;
		
		if (EditorSingleton.getInstance().getEditor().isRememberMetaSchema())
		{
			validate(EditorSingleton.getInstance().getEditor().getMetaSchema(), true);
		}
		else
		{
			MetaSchemaLoaderConfirmAction metaSchemaLoaderConfirmAction = new MetaSchemaLoaderConfirmAction("OK", this);
			metaSchemaLoaderDialog = new MetaSchemaLoaderDialog(ApplicationSingleton.getInstance().getResourceBundle().getString("loadMetaSchema"), true);
			metaSchemaLoaderDialog.setOkButtonAction(metaSchemaLoaderConfirmAction);
			metaSchemaLoaderConfirmAction.setMetaSchemaLoaderDialog(metaSchemaLoaderDialog);
			metaSchemaLoaderDialog.setVisible(true);			
		}
	}
	
	public boolean doValidation(File metaSchemaFile, boolean rememberMetaSchema)
	{	
		if (metaSchemaFile != null)
		{
			if (metaSchemaFile.exists() && metaSchemaFile.getAbsolutePath().endsWith(".json"))
			{											
				try
				{
					InputStream inputStream = new BufferedInputStream(new FileInputStream(metaSchemaFile));
					JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
					Schema metaSchema = SchemaLoader.load(rawSchema);

					validate(metaSchema, rememberMetaSchema);
					
					EditorSingleton.getInstance().getEditorMainFrame().getEditorMenuBar().setEnabledMetaSchemaChange(rememberMetaSchema);
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
					errorMessage();
					return false;
				}
			}
			else 
			{
				errorMessage();
				return false;
			}
		}
		else
		{
			return false;
		}
		
		return true;
	}
	
	public void validate(Schema metaSchema, boolean rememberMetaSchema)
	{
		EditorSingleton.getInstance().getEditor().setRememberMetaSchema(rememberMetaSchema);
		if (rememberMetaSchema)
		{
			EditorSingleton.getInstance().getEditor().setMetaSchema(metaSchema);
		}
		
		JSONValidator validator = (JSONValidator) ApplicationSingleton.getInstance().getJsonFactory().createValidator();
		validator.setMetaSchema(metaSchema);
		validator.validate(currentSchema);
	}
	
	public static void errorSchemaMessage() { JOptionPane.showMessageDialog(null,
			ApplicationSingleton.getInstance().getResourceBundle().getString("createJsonError"), ApplicationSingleton.getInstance().getResourceBundle().getString("errorHeader"), JOptionPane.ERROR_MESSAGE); }
	public static void errorMessage() { JOptionPane.showMessageDialog(null, ApplicationSingleton.getInstance().getResourceBundle().getString("fileOpenError"), ApplicationSingleton.getInstance().getResourceBundle().getString("errorHeader"), JOptionPane.ERROR_MESSAGE); }
}