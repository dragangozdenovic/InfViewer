package infviewer.editor.controller;

import java.awt.event.ActionEvent;

import infviewer.app.ApplicationSingleton;
import infviewer.editor.view.MetaSchemaLoaderDialog;

public class ChangeMetaSchemaAction extends Action 
{
	private static final long serialVersionUID = 7110427635185779797L;
	
	
	public ChangeMetaSchemaAction(String name) 
	{
		super(name, "ctrl shift C");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		ChangeMetaSchemaConfirmAction changeMetaSchemaConfirmAction = 
				new ChangeMetaSchemaConfirmAction(
						ApplicationSingleton.getInstance().getResourceBundle().getString("confirmOption"));
		
		MetaSchemaLoaderDialog metaSchemaLoaderDialog = new MetaSchemaLoaderDialog(
				ApplicationSingleton.getInstance().getResourceBundle().getString("changeMetaSchema"),
				false);
		
		metaSchemaLoaderDialog.setOkButtonAction(changeMetaSchemaConfirmAction);
		changeMetaSchemaConfirmAction.setMetaSchemaLoaderDialog(metaSchemaLoaderDialog);
		metaSchemaLoaderDialog.setVisible(true);
	}
	
}