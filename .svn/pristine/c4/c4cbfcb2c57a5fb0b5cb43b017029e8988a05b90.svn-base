package infviewer.editor.controller;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import infviewer.editor.EditorSingleton;

public class ExitAction extends Action 
{
	private static final long serialVersionUID = 3542994624755523471L;

	public ExitAction(String name) 
	{
		super(name);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (!super.checkSave())
		{
			return;
		}
		
		EditorSingleton.getInstance().getEditorMainFrame().dispatchEvent(new WindowEvent(EditorSingleton.getInstance().getEditorMainFrame(), WindowEvent.WINDOW_CLOSING));
	}
}
