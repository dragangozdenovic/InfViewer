package infviewer.editor.controller;

import java.awt.event.ActionEvent;
import java.io.File;

import infviewer.editor.view.MetaSchemaLoaderDialog;

public class MetaSchemaLoaderConfirmAction extends Action
{
	private static final long serialVersionUID = 5908483122935157586L;
	private MetaSchemaLoaderDialog metaSchemaLoaderDialog;
	private ValidateSchemaAction validateSchemaAction;
	
	public MetaSchemaLoaderConfirmAction(String name, ValidateSchemaAction validateSchemaAction)
	{
		super(name);
		this.validateSchemaAction = validateSchemaAction;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{	
		File currentMetaSchema = new File(metaSchemaLoaderDialog.getTextField().getText());
		
		boolean success = validateSchemaAction.doValidation(currentMetaSchema, metaSchemaLoaderDialog.getChckbxRemember().isSelected());
		if (success)
		{
			metaSchemaLoaderDialog.dispose();							
		}
	}

	public void setMetaSchemaLoaderDialog(MetaSchemaLoaderDialog metaSchemaLoaderDialog) {
		this.metaSchemaLoaderDialog = metaSchemaLoaderDialog;
	}
}