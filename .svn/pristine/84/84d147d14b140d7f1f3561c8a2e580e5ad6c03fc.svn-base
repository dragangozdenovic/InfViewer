package infviewer.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ResourceBundle;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import infviewer.app.ApplicationSingleton;
import infviewer.controller.OpenSchemaEditorAction;

public class ApplicationMenuBar extends JMenuBar
{
	private static final long serialVersionUID = 2548926536326170960L;
	private ResourceBundle resourceBundle = ApplicationSingleton.getInstance().getResourceBundle();
	private JMenu file = new JMenu(resourceBundle.getString("file"));
	private JMenuItem openSchemaEditor = new JMenuItem(new OpenSchemaEditorAction(resourceBundle.getString("openEditor")));
	private JMenuItem exit = new JMenuItem(resourceBundle.getString("exitOption"));
	
	public ApplicationMenuBar() 
	{
		exit.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				ApplicationSingleton.getInstance().getApplicationMainFrame().dispatchEvent(new WindowEvent(ApplicationSingleton.getInstance().getApplicationMainFrame(), WindowEvent.WINDOW_CLOSING));
			}
		});
		
		add(file);
		file.add(openSchemaEditor);
		file.addSeparator();
		file.add(exit);
	}
}