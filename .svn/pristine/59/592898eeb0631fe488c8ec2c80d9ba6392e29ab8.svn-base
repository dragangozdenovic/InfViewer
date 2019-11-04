package infviewer.editor.controller;

import java.awt.event.ActionEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import infviewer.editor.EditorSingleton;
import infviewer.editor.view.MetaSchemaLoaderDialog;

public class ChangeMetaSchemaConfirmAction extends Action 
{
	private static final long serialVersionUID = -5449377128106635672L;
	private MetaSchemaLoaderDialog metaSchemaLoaderDialog;

	public ChangeMetaSchemaConfirmAction(String name) 
	{
		super(name);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		File currentMetaSchema = new File(metaSchemaLoaderDialog.getTextField().getText());
		
		if (currentMetaSchema != null && currentMetaSchema.exists() && currentMetaSchema.getAbsolutePath().endsWith(".json"))
		{
			try
			{
				InputStream inputStream = new BufferedInputStream(new FileInputStream(currentMetaSchema));
				JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
				Schema metaSchema = SchemaLoader.load(rawSchema);
				
				EditorSingleton.getInstance().getEditor().setMetaSchema(metaSchema);
			}
			catch (Exception e1)
			{
				ValidateSchemaAction.errorMessage();
				return;
			}
			
			metaSchemaLoaderDialog.dispose();
		}
		else
		{
			ValidateSchemaAction.errorMessage();
		}
	}
	
	public void setMetaSchemaLoaderDialog(MetaSchemaLoaderDialog metaSchemaLoaderDialog) {
		this.metaSchemaLoaderDialog = metaSchemaLoaderDialog;
	}
}