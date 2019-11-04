package infviewer.controller;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import infviewer.app.ApplicationSingleton;
import infviewer.database.DBConnection;
import infviewer.editor.controller.JSONValidator;
import infviewer.tree.controller.JSONParser;
import infviewer.tree.model.Package;
import infviewer.view.ApplicationLoadingDialog;
import infviewer.view.ApplicationMainFrame;
import infviewer.workspace.controller.RDBParser;
import infviewer.workspace.model.Row;

public class LoadingDialogConfirmAction extends AbstractAction 
{
	private static final long serialVersionUID = 6489166322872429L;

	public LoadingDialogConfirmAction(String name) 
	{
		putValue(NAME, name);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		ApplicationLoadingDialog applicationLoadingDialog = ApplicationSingleton.getInstance().getApplicationLoadingDialog();
		try 
		{
			DBConnection.getInstance().setParams(applicationLoadingDialog.getTextFieldIPAddress().getText(),
												 applicationLoadingDialog.getTextFieldDBName().getText(),
												 applicationLoadingDialog.getTextFieldUsername().getText(),
												 new String(applicationLoadingDialog.getPasswordField().getPassword()),
												 ApplicationSingleton.getInstance().getProperties().getProperty("driver"));
		}
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(applicationLoadingDialog, 
					ApplicationSingleton.getInstance().getResourceBundle().getString("databaseError"), 
					ApplicationSingleton.getInstance().getResourceBundle().getString("errorHeader"), 
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		AbstractFactory factory = new RDBFactory();
		Package mainPackage = new Package();
        
		if (applicationLoadingDialog.getRdbtnJson().isSelected())
		{
			AbstractFactory jsonFactory = new JSONFactory();
			JSONParser jsonParser = (JSONParser)jsonFactory.createParser();
			try
			{
				Schema metaSchema = loadMetaSchema();
				JSONObject json = jsonParser.getJSONForParsing(applicationLoadingDialog.getTextFieldJSONFile().getText());
				
				JSONValidator jsonValidator = (JSONValidator)jsonFactory.createValidator();
				jsonValidator.setMetaSchema(metaSchema);
				
				if (jsonValidator.validate(json))
				{
					mainPackage = jsonParser.parse(json);								
				}
				else
				{
					return;
				}
				
			} 
			catch (JSONException | FileNotFoundException e)
			{
				e.printStackTrace();
				JOptionPane.showMessageDialog(applicationLoadingDialog, 
						ApplicationSingleton.getInstance().getResourceBundle().getString("jsonError"), 
						ApplicationSingleton.getInstance().getResourceBundle().getString("errorHeader"), 
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			ApplicationSingleton.getInstance().setJsonFactory(jsonFactory);
	        ApplicationSingleton.getInstance().setFactory(factory);

		}
		else
		{
	        ApplicationSingleton.getInstance().setFactory(factory);

            RDBParser rdbParser = (RDBParser)factory.createParser();
            HashMap<String, Object> packMap = new HashMap<>();
            packMap.put("PO_TIP", "S");
            List<Row> packs = rdbParser.readColumnsAndRows("PODSISTEM", packMap);
            if(packs.size() == 1) 
            {
                mainPackage = rdbParser.parse(packs.get(0));
            }
		}
		

        ApplicationMainFrame applicationMainFrame = new ApplicationMainFrame();
        ApplicationSingleton.getInstance().setApplicationMainFrame(applicationMainFrame);
        ApplicationSingleton.getInstance().setMainPackage(mainPackage);
        applicationMainFrame.getTreeView().getTree().fillTree(mainPackage);
        
        //Switch loading dialog with main window
        applicationLoadingDialog.dispatchEvent(new WindowEvent(applicationLoadingDialog, WindowEvent.WINDOW_CLOSING));
        applicationMainFrame.setVisible(true);
        
	}

	private Schema loadMetaSchema() throws FileNotFoundException 
	{
		InputStream inputStream = new BufferedInputStream(new FileInputStream(new File(ApplicationSingleton.getInstance().getProperties().getProperty("metaschema"))));
		JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
		Schema metaSchema = SchemaLoader.load(rawSchema);
		return metaSchema;
	}
}