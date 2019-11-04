package infviewer.editor.view;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Element;

import infviewer.editor.controller.ZoomAction;

public class EditorLineNumberView extends JTextArea implements DocumentListener
{
	private static final long serialVersionUID = -4012447689391219437L;
	private static final int MIN_DISPLAY_DIGITS = 2;
	private JTextArea textArea;
	
	public EditorLineNumberView(JTextArea textArea)
	{
		super(Integer.MAX_VALUE, MIN_DISPLAY_DIGITS);
		this.setEditable(false);
		this.setHighlighter(null);
		this.setFont(textArea.getFont());
		this.addKeyListener(new ZoomAction(this));		
	
		this.textArea = textArea;
		this.textArea.getDocument().addDocumentListener(this);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		int line = 1;
		int numberOfLines = textArea.getLineCount();
		FontMetrics fontMetrics = this.textArea.getFontMetrics(this.textArea.getFont());
		
		do
		{
			int digits = String.valueOf(line).length();
			int stringWidth = fontMetrics.charWidth('0') * digits;
			int x = (int)(this.getWidth() - stringWidth)/2;
			int y = fontMetrics.getHeight() * line;
			
			g.drawString(Integer.toString(line), x, y - this.textArea.getFont().getSize()/4);
		}
		while(line++ < numberOfLines);
	}

	protected String getTextLineNumber(int rowStartOffset)
	{
		Element root = this.textArea.getDocument().getDefaultRootElement();
		int index = root.getElementIndex(rowStartOffset);
		Element line = root.getElement(index);

		if (line.getStartOffset() == rowStartOffset)
		{			
			return String.valueOf(index + 1);
		}
		else
		{
			return null;			
		}
	}
	
	@Override
	public void changedUpdate(DocumentEvent e) { documentChanged(); }

	@Override
	public void insertUpdate(DocumentEvent e) { documentChanged(); }

	@Override
	public void removeUpdate(DocumentEvent e) { documentChanged(); }
	
	private void documentChanged()
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				setPreferredSize(new Dimension(getWidth(), Integer.MAX_VALUE));
				setColumns(String.valueOf(textArea.getLineCount()).length() + 1);
				revalidate();
				repaint();
			}
		});
	}
}