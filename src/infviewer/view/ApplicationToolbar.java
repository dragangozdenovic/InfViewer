package infviewer.view;

import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import infviewer.controller.OpenSchemaEditorAction;

public class ApplicationToolbar extends JToolBar
{
	private static final long serialVersionUID = -8791820238136493572L;
	private JButton openEditor;
	
	public ApplicationToolbar() 
	{
		super(SwingConstants.HORIZONTAL);
		setFloatable(true);
		
		openEditor = new JButton(new OpenSchemaEditorAction());
		add(openEditor);
	}
}