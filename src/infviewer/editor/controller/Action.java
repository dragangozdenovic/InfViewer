package infviewer.editor.controller;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import infviewer.app.ApplicationSingleton;
import infviewer.editor.EditorSingleton;

public abstract class Action extends AbstractAction
{
	private static final long serialVersionUID = -4760868614535663361L;

	public Action(String name)
	{
		super(name);
	}
	
	public Action(String name, String key)
	{
		super(name);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(key));
	}
	
	public static boolean checkSave()
	{
		if (!EditorSingleton.getInstance().getEditor().isSchemaSaved())
		{
			int choice = JOptionPane.showConfirmDialog(EditorSingleton.getInstance().getEditorMainFrame(),
													   ApplicationSingleton.getInstance().getResourceBundle().getString("editorSaveQuestion"),
													   ApplicationSingleton.getInstance().getResourceBundle().getString("schemaEditor"), 
													   JOptionPane.YES_NO_CANCEL_OPTION);
			if (choice == JOptionPane.YES_OPTION)
			{
				return SaveSchemaAction.save();				
			}
			else if (choice == JOptionPane.NO_OPTION)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		return true;
	}
}