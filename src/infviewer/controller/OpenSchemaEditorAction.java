package infviewer.controller;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import infviewer.app.ApplicationSingleton;
import infviewer.editor.EditorSingleton;
import infviewer.editor.controller.Action;

public class OpenSchemaEditorAction extends AbstractAction 
{
	private static final long serialVersionUID = -5111338002473234848L;
	private ResourceBundle resourceBundle = ApplicationSingleton.getInstance().getResourceBundle();

	public OpenSchemaEditorAction(String name)
	{
		this();
		putValue(NAME, name);
	}
	
	public OpenSchemaEditorAction() 
	{
		putValue(SHORT_DESCRIPTION, resourceBundle.getString("editorJsonOpen"));
		putValue(LARGE_ICON_KEY, new ImageIcon("resources/images/editor_icon.png"));
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		EditorSingleton.getInstance().getEditor().addObserver(EditorSingleton.getInstance().getEditorMainFrame());
		EditorSingleton.getInstance().getEditor().addObserver(EditorSingleton.getInstance().getEditorMainFrame().getEditorTextView());
		
		EditorSingleton.getInstance().getEditorMainFrame().setVisible(true);
		
		EditorSingleton.getInstance().getEditorMainFrame().addWindowListener(new WindowListener() 
		{	
			@Override
			public void windowClosing(WindowEvent e) {
				if (!Action.checkSave())
				{
					EditorSingleton.getInstance().getEditorMainFrame().setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
				else
				{
					EditorSingleton.getInstance().getEditorMainFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			}
			
			@Override
			public void windowOpened(WindowEvent e) { }
			@Override
			public void windowIconified(WindowEvent e) { }
			@Override
			public void windowDeiconified(WindowEvent e) { }
			@Override
			public void windowDeactivated(WindowEvent e) { }
			@Override
			public void windowClosed(WindowEvent e) { }
			@Override
			public void windowActivated(WindowEvent e) { }
		});
	}
}