package infviewer.editor.controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingUtilities;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;

public class LineHighlighter implements Highlighter.HighlightPainter, CaretListener, MouseListener, MouseMotionListener
{
    private JTextComponent componentToHighlight;
	private Color highlightColor;
	private Rectangle currentView;
	private static final float LIGHTING_FACTOR = 0.9f;

	public LineHighlighter(JTextComponent componentToHighlight)
	{
		this.componentToHighlight = componentToHighlight; 		
		
		int red   = Math.min(255, (int)(this.componentToHighlight.getSelectionColor().getRed() * LIGHTING_FACTOR));
		int green = Math.min(255, (int)(this.componentToHighlight.getSelectionColor().getGreen() * LIGHTING_FACTOR));
		int blue  = Math.min(255, (int)(this.componentToHighlight.getSelectionColor().getBlue() * LIGHTING_FACTOR));
		this.highlightColor = new Color(red, green, blue);
	
		try
		{
			this.componentToHighlight.getHighlighter().addHighlight(0, 0, this);
		}
		catch(BadLocationException e) {}

		this.componentToHighlight.addCaretListener(this);
		this.componentToHighlight.addMouseListener(this);
		this.componentToHighlight.addMouseMotionListener(this);
	}
	
	@Override
	public void paint(Graphics g, int p0, int p1, Shape bounds, JTextComponent c)
	{
		try
		{
			Rectangle view = c.modelToView(c.getCaretPosition());
			g.setColor(highlightColor);
			g.fillRect(0, view.y, c.getWidth(), view.height);

			if (currentView == null)
			{
				currentView = view;				
			}
		}
		catch(BadLocationException e) {}
	}
	
	private void resetHighlight()
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					int offset =  componentToHighlight.getCaretPosition();
					Rectangle newView = componentToHighlight.modelToView(offset);

					if (currentView != null)
					{
						if (currentView.y != newView.y)
						{
							componentToHighlight.repaint(0, currentView.y, componentToHighlight.getWidth(), currentView.height);
							currentView = newView;
						}
					}
				}
				catch(BadLocationException e) {}
			}
		});
	}

	public void caretUpdate(CaretEvent e){ resetHighlight(); }
	
	public void mousePressed(MouseEvent e){ resetHighlight(); }
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	
	public void mouseDragged(MouseEvent e){ resetHighlight(); }
	public void mouseMoved(MouseEvent e) {}
}