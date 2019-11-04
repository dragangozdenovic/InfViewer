package infviewer.editor.controller;

import java.awt.event.ActionEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.JOptionPane;

import org.json.JSONObject;
import org.json.JSONTokener;

import infviewer.app.ApplicationSingleton;
import infviewer.editor.EditorSingleton;
import infviewer.editor.events.SchemaEvent;
import infviewer.editor.events.SchemaEvent.SchemaEvents;

public class SaveSchemaAction extends Action 
{
	private static final long serialVersionUID = -5200842758927792174L;

	public SaveSchemaAction(String name) 
	{
		super(name, "ctrl S");
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		save();
	}

	public static boolean save()
	{
		File modifiedFile = EditorSingleton.getInstance().getEditor().save(EditorSingleton.getInstance().getEditorMainFrame().
													   getEditorTextView().getEditorTextArea().getText(), "JSON file (*.json)", "json");
		
		if (modifiedFile != null)
		{
			try 
			{
				InputStream jsonInputStream = new BufferedInputStream(new FileInputStream(modifiedFile));
				JSONObject input = new JSONObject(new JSONTokener(jsonInputStream));
				
				EditorSingleton.getInstance().getEditor().setSchema(input);
				EditorSingleton.getInstance().getEditor().setSchemaFile(modifiedFile);
				EditorSingleton.getInstance().getEditor().setChanged();
				
				SchemaEvent schemaEvent = new SchemaEvent(EditorSingleton.getInstance().getEditor(), SchemaEvents.SAVE_SCHEMA);
				EditorSingleton.getInstance().getEditor().notifyObservers(schemaEvent);			
			} 
			catch (Exception e) 
			{ 
				errorMessage();
				return false;
			}
		}
		
		return true;
	}
	
	private static void errorMessage() { JOptionPane.showMessageDialog(null,
			ApplicationSingleton.getInstance().getResourceBundle().getString("fileSaveError"),
			ApplicationSingleton.getInstance().getResourceBundle().getString("errorHeader"), JOptionPane.ERROR_MESSAGE); }
}