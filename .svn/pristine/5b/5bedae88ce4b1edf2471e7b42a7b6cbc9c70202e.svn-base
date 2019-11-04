package infviewer.editor.view;

import java.awt.BorderLayout;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JDialog;
import javax.swing.JFrame;

import infviewer.app.ApplicationSingleton;
import infviewer.editor.events.SchemaEvent;
import infviewer.editor.events.SchemaEvent.SchemaEvents;

public class EditorMainFrame extends JDialog implements Observer
{
	private static final long serialVersionUID = 8146561425733073838L;
	private EditorMenuBar editorMenuBar;
	private EditorTextView editorTextView;
	private static final String NO_NAME = "Untitled";
	private static final String TITLE = ApplicationSingleton.getInstance().getResourceBundle().getString("schemaEditor");
	public static Rectangle windowSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();

	public EditorMainFrame()
	{
		setTitle(NO_NAME);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(windowSize.width / 2, windowSize.height / 2);
        setLocationRelativeTo(null);
        setModal(true);
        
        editorMenuBar = new EditorMenuBar();
        setJMenuBar(editorMenuBar);
        editorMenuBar.updateUI();
        
        editorTextView = new EditorTextView();
        add(editorTextView, BorderLayout.CENTER);
	}

	public EditorMenuBar getEditorMenuBar() {
		return editorMenuBar;
	}

	public EditorTextView getEditorTextView() {
		return editorTextView;
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
				setTitle(NO_NAME);
			}
			else if (schemaEvent.getEvent() == SchemaEvents.OPEN_SCHEMA ||
					 schemaEvent.getEvent() == SchemaEvents.SAVE_SCHEMA)
			{
				setTitle(schemaEvent.getEditor().getSchemaFile().getName());
			}
		}
	}
	
	@Override
	public void setTitle(String title) 
	{
		super.setTitle(title + " - " + TITLE);
	}
}