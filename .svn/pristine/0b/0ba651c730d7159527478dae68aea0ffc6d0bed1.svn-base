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
import infviewer.editor.model.Editor;

public class OpenSchemaAction extends Action
{
	private static final long serialVersionUID = -6443091039198799667L;

	public OpenSchemaAction(String name)
	{
		super(name, "ctrl O");
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (!super.checkSave())
		{
			return;
		}
		
		File jsonFile = Editor.open("JSON file (*.json)", "json");
		if (jsonFile != null)
		{
			if (jsonFile.exists() && jsonFile.getAbsolutePath().endsWith(".json"))
			{
				try
				{
					InputStream jsonInputStream = new BufferedInputStream(new FileInputStream(jsonFile));
					JSONObject input = new JSONObject(new JSONTokener(jsonInputStream));
					
					EditorSingleton.getInstance().getEditor().setSchema(input);
					EditorSingleton.getInstance().getEditor().setSchemaFile(jsonFile);
					EditorSingleton.getInstance().getEditor().setChanged();
					
					SchemaEvent schemaEvent = new SchemaEvent(EditorSingleton.getInstance().getEditor(), SchemaEvents.OPEN_SCHEMA);
					EditorSingleton.getInstance().getEditor().notifyObservers(schemaEvent);
				}
				catch (Exception e1) { errorMessage(); }							
			}
			else { errorMessage(); }
		}
	}
	
	private static void errorMessage() { JOptionPane.showMessageDialog(null, 
			ApplicationSingleton.getInstance().getResourceBundle().getString("fileOpenError"),
			ApplicationSingleton.getInstance().getResourceBundle().getString("errorHeader"), JOptionPane.ERROR_MESSAGE); }
}