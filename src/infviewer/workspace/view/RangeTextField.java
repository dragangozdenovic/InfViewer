package infviewer.workspace.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JTextField;

import infviewer.workspace.view.RangeElement.StartEndPoints;

public class RangeTextField extends JTextField 
{
	private static final long serialVersionUID = 2118670304162205127L;
	private StartEndPoints endPoint;
	
	public RangeTextField(StartEndPoints endPoint) 
	{
		this.endPoint = endPoint;
	}
	
	/**
	 * Iscrtavanje placeholder-a koji ukazuje na to kakvu vrednost treba uneti u polje
	 */
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		if (this.getText().isEmpty())
		{
			g.setFont(new Font("Tahoma", Font.BOLD, 12));
			g.setColor(new Color(0, 0, 0, 100));
			g.drawString(this.endPoint.toString(), 10, 2 * this.getHeight() / 3);			
		}
	}
}