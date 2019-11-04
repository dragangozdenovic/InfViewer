package infviewer.editor.controller;

import java.awt.event.ActionEvent;

import infviewer.editor.EditorSingleton;
import infviewer.editor.events.SchemaEvent;
import infviewer.editor.events.SchemaEvent.SchemaEvents;
import infviewer.editor.model.Editor;

public class NewSchemaAction extends Action
{
	private static final long serialVersionUID = -4149934500151399932L;

	public NewSchemaAction(String name) 
	{
		super(name, "ctrl N");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if (!super.checkSave())
		{
			return;
		}
		
		EditorSingleton.getInstance().setEditor(new Editor());
		EditorSingleton.getInstance().getEditor().addObserver(EditorSingleton.getInstance().getEditorMainFrame());
		EditorSingleton.getInstance().getEditor().addObserver(EditorSingleton.getInstance().getEditorMainFrame().getEditorTextView());
		EditorSingleton.getInstance().getEditor().setChanged();
		
		SchemaEvent schemaEvent = new SchemaEvent(EditorSingleton.getInstance().getEditor(), SchemaEvents.NEW_SCHEMA);
		EditorSingleton.getInstance().getEditor().notifyObservers(schemaEvent);
	}
}
