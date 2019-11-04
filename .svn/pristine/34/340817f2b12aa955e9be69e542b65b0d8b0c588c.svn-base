package infviewer.editor.controller;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

public class ZoomAction implements KeyListener
{
	public static final int MIN_FONT_SIZE = 14;
	public static final int MAX_FONT_SIZE = 70;
	public static final int STEP = 2;
	private static List<JComponent> componentsToZoom = new ArrayList<>();
	
	public ZoomAction(JComponent componentToZoom) 
	{	
		componentsToZoom.add(componentToZoom);
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) 
	{
		if (arg0.isControlDown())
		{
			for (JComponent textAreaToZoom : componentsToZoom)
			{
				int currentSize = textAreaToZoom.getFont().getSize();
				if (arg0.getKeyCode() == KeyEvent.VK_ADD && currentSize < MAX_FONT_SIZE)
				{
					setNewFont(textAreaToZoom, currentSize, STEP);
				}
				else if (arg0.getKeyCode() == KeyEvent.VK_SUBTRACT && currentSize > MIN_FONT_SIZE)
				{
					setNewFont(textAreaToZoom, currentSize, -STEP);
				}				
			}
		}
	}

	public void setNewFont(JComponent componentToZoom, int currentSize, int step)
	{
		Font newFont = componentToZoom.getFont().deriveFont((float)(currentSize + step));
		componentToZoom.setFont(newFont);
		componentToZoom.revalidate();
	}
	
	@Override
	public void keyReleased(KeyEvent arg0) {}
	@Override
	public void keyTyped(KeyEvent arg0) {}
}