package infviewer.editor.events;

import infviewer.editor.model.Editor;

public class SchemaEvent 
{
	public enum SchemaEvents 
	{
	      NEW_SCHEMA,
		  SAVE_SCHEMA,
		  OPEN_SCHEMA;
    }
	private Editor editor;
	private SchemaEvents event;
	
	public SchemaEvent(Editor editor, SchemaEvents event) {
		this.editor = editor;
		this.event = event;
	}

	public Editor getEditor() {
		return editor;
	}

	public void setEditor(Editor editor) {
		this.editor = editor;
	}

	public SchemaEvents getEvent() {
		return event;
	}

	public void setEvent(SchemaEvents event) {
		this.event = event;
	}
}