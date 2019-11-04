package infviewer.editor.view;

import java.util.ResourceBundle;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import infviewer.app.ApplicationSingleton;
import infviewer.editor.controller.ChangeMetaSchemaAction;
import infviewer.editor.controller.ExitAction;
import infviewer.editor.controller.NewSchemaAction;
import infviewer.editor.controller.OpenSchemaAction;
import infviewer.editor.controller.SaveSchemaAction;
import infviewer.editor.controller.ValidateSchemaAction;

public class EditorMenuBar extends JMenuBar
{
	private static final long serialVersionUID = -8333123285931285149L;
	
	private ResourceBundle resourceBundle = ApplicationSingleton.getInstance().getResourceBundle();
	private JMenu file = new JMenu(resourceBundle.getString("file"));
	private JMenuItem newSchema = new JMenuItem();
	private JMenuItem openSchema = new JMenuItem();
	private JMenuItem saveSchema = new JMenuItem();
	private JMenuItem validateSchema = new JMenuItem();
	private JMenuItem changeMetaSchema = new JMenuItem();
	private JMenuItem exit = new JMenuItem();
	
	public EditorMenuBar() 
	{
		newSchema.setAction(new NewSchemaAction(resourceBundle.getString("newSchema")));
		openSchema.setAction(new OpenSchemaAction(resourceBundle.getString("openSchema")));
		saveSchema.setAction(new SaveSchemaAction(resourceBundle.getString("saveSchema")));
		validateSchema.setAction(new ValidateSchemaAction(resourceBundle.getString("validateSchema")));
		changeMetaSchema.setAction(new ChangeMetaSchemaAction(resourceBundle.getString("changeMetaSchema")));
		changeMetaSchema.setEnabled(false); //Dokle god se ne zapamti nijedna meta-sema, nije moguce promeniti meta-semu
		exit.setAction(new ExitAction(resourceBundle.getString("exitOption")));
		
		add(file);
		file.add(newSchema);
		file.addSeparator();
		file.add(openSchema);
		file.add(saveSchema);
		file.addSeparator();
		file.add(validateSchema);
		file.add(changeMetaSchema);
		file.addSeparator();
		file.add(exit);
	}
	
	public void setEnabledMetaSchemaChange(boolean enabled)
	{
		this.changeMetaSchema.setEnabled(enabled);
	}
}