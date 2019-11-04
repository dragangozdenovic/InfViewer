package infviewer.editor;

import infviewer.editor.model.Editor;
import infviewer.editor.view.EditorMainFrame;

public class EditorSingleton 
{
	private static EditorSingleton instance = new EditorSingleton();	
	private Editor editor = new Editor();
	private EditorMainFrame editorMainFrame = new EditorMainFrame();
    
	private EditorSingleton() {}

	public static EditorSingleton getInstance() {
		return instance;
	}

	public Editor getEditor() {
		return editor;
	}

	public void setEditor(Editor editor) {
		this.editor = editor;
	}

	public EditorMainFrame getEditorMainFrame() {
		return editorMainFrame;
	}

	public void setEditorMainFrame(EditorMainFrame editorMainFrame) {
		this.editorMainFrame = editorMainFrame;
	}
}