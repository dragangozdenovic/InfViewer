package infviewer.editor.view;

import java.awt.Font;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import infviewer.editor.controller.LineHighlighter;
import infviewer.editor.controller.ZoomAction;
import infviewer.editor.events.SchemaEvent;
import infviewer.editor.events.SchemaEvent.SchemaEvents;

public class EditorTextView extends JScrollPane implements Observer
{
	private static final long serialVersionUID = -442824493750483859L;
	private JTextArea editorTextArea;
	private JTextArea editorLineNumbers;

	public EditorTextView() 
    {
		editorTextArea = new JTextArea();
		editorTextArea.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		editorTextArea.setTabSize(3);
		editorTextArea.addKeyListener(new ZoomAction(editorTextArea));
		new LineHighlighter(editorTextArea);
		
		editorLineNumbers = new EditorLineNumberView(editorTextArea);
		this.setViewportView(editorTextArea);
		this.setRowHeaderView(editorLineNumbers);
	}

	@Override
	public void update(Observable o, Object arg) 
	{
		if (arg == null)
		{
			return;
		}
		
		if (arg instanceof SchemaEvent)
		{
			SchemaEvent schemaEvent = (SchemaEvent) arg;
			if (schemaEvent.getEvent() == SchemaEvents.NEW_SCHEMA)
			{
				editorTextArea.setText("");
			}
			else if (schemaEvent.getEvent() == SchemaEvents.OPEN_SCHEMA)
			{
				try
				{
					byte[] bytes = Files.readAllBytes(Paths.get(schemaEvent.getEditor().getSchemaFile().getAbsolutePath()));
					editorTextArea.setText(new String(bytes));
					editorTextArea.setCaretPosition(0);
				} 
				catch (IOException e) {}
			}
		}
	}
	
	public JTextArea getEditorTextArea()
	{
		return editorTextArea;
	}

	public JTextArea getEditorLineNumbers() {
		return editorLineNumbers;
	}
}