package infviewer.editor;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import infviewer.editor.controller.Action;

public class EditorApp 
{
	public static void main(String[] args) 
	{
		try 
		{
			UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
		} 
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) { e.printStackTrace(); }
		
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
					EditorSingleton.getInstance().getEditorMainFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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