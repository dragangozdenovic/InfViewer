package infviewer.workspace.view;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomTableCellRenderer extends DefaultTableCellRenderer
{
	private static final long serialVersionUID = -2753476420871153463L;
	private static final Color LIGHT_GRAY_COLOR = new Color(230, 230, 230);
	private Color selectionBackground;
	private static final float DARK_FACTOR = 0.85f;
	private TCheckBox trueBox;
	private TCheckBox falseBox;
	private TCheckBox nullBox;
	
	public CustomTableCellRenderer(Color selectionBackground) 
	{
		int red = Math.min(255, (int)(selectionBackground.getRed() * DARK_FACTOR));
		int green = Math.min(255,(int)(selectionBackground.getGreen() * DARK_FACTOR));
		int blue = Math.min(255,(int)(selectionBackground.getBlue() * DARK_FACTOR));
		this.selectionBackground = new Color(red, green, blue);
		
		this.nullBox = new TCheckBox("", 0);
		this.falseBox = new TCheckBox("", 1);
		this.trueBox = new TCheckBox("", 2);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
	{
		super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
		Component component = this;
		
		if (value instanceof Boolean)
		{
			if (((boolean)value) == true)
			{
				component = trueBox;
			}
			else if (((boolean)value) == false)
			{
				component = falseBox;
			}
			else
			{
				component = nullBox;			
			}
		}
		
		if (isSelected)
		{
			component.setBackground(this.selectionBackground);
		}
		else
		{
			if (row % 2 == 0)
			{
				component.setBackground(LIGHT_GRAY_COLOR);
			}
			else
			{
				component.setBackground(Color.WHITE);
			}						
		}

		return component;
	}
}
