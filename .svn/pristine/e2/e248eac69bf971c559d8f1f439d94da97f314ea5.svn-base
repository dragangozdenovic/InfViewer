package infviewer.editor.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Observable;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.everit.json.schema.Schema;
import org.json.JSONObject;

import infviewer.editor.EditorSingleton;

public class Editor extends Observable
{
	private Schema metaSchema;
	private JSONObject schema;
	private File schemaFile;
	private boolean rememberMetaSchema;

	public Schema getMetaSchema() {
		return metaSchema;
	}

	public void setMetaSchema(Schema metaSchema) {
		this.metaSchema = metaSchema;
	}

	public JSONObject getSchema() {
		return schema;
	}

	public void setSchema(JSONObject schema) {
		this.schema = schema;
	}

	public File getSchemaFile() {
		return schemaFile;
	}

	public void setSchemaFile(File schemaFile) {
		this.schemaFile = schemaFile;
	}

	public boolean isRememberMetaSchema() {
		return rememberMetaSchema;
	}

	public void setRememberMetaSchema(boolean rememberMetaSchema) {
		this.rememberMetaSchema = rememberMetaSchema;
	}

	public boolean isSchemaSaved() 
	{
		String currentText = EditorSingleton.getInstance().getEditorMainFrame().getEditorTextView().getEditorTextArea().getText();
		
		if (currentText.isEmpty())
		{
			return true;
		}
		
		if (this.schema == null)
		{
			return false;
			
		}
		
		JSONObject currentJson;
		try
		{
			currentJson = new JSONObject(currentText);			
		}
		catch (Exception e) { return false; }
		
		Map<String, Object> currentJsonMap = currentJson.toMap();
		Map<String, Object> schemaMap = schema.toMap();
		
		return currentJsonMap.equals(schemaMap);
	}
	
	@Override
	public synchronized void setChanged() 
	{
		super.setChanged();
	}
	
	public static File open(String description, String extension)
	{
		JFileChooser chooser = initFileChooser(description, extension);
		int choice = chooser.showOpenDialog(null);
		if (choice == JFileChooser.APPROVE_OPTION)
		{
			return chooser.getSelectedFile();
		}
		else
		{
			return null;
		}
	}
	
	public File save(String text, String description, String extension) 
    {
    	if(this.getSchemaFile() == null) 
    	{
			JFileChooser chooser = initFileChooser(description, extension);
			int choice = chooser.showSaveDialog(null);
			if (choice == JFileChooser.APPROVE_OPTION)
			{
				File file = chooser.getSelectedFile();
				if (!file.getAbsolutePath().endsWith("." + extension))
				{
					file = new File(file.getAbsolutePath() + "." + extension);
				}
				return saveFile(file, text);
			}
			return null;
		}
	  	else 
	  	{
	  		return saveFile(this.getSchemaFile(), text);
		}
    }
	
	private File saveFile(File file, String text)
	{
		BufferedWriter bufferedWriter = null;
		try 
		{
			bufferedWriter = new BufferedWriter(new FileWriter(file));
			bufferedWriter.write(text);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
			return null;
		}
		finally 
		{
			if (bufferedWriter != null)
			{
				try
				{
					bufferedWriter.close();
				} 
				catch (IOException e) { e.printStackTrace(); }
			}
		}
		
		return file;
	}
	
	public static JFileChooser initFileChooser(String description, String extension)
	{
		JFileChooser chooser = new JFileChooser(System.getProperty("user.dir") + "\\resources");
		FileNameExtensionFilter filter = new FileNameExtensionFilter(description, extension);
		chooser.setAcceptAllFileFilterUsed(false);
		chooser.setFileFilter(filter);
		return chooser;
	}
}