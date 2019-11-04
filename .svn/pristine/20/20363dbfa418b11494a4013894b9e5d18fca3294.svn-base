package infviewer.workspace.view;

import java.sql.Date;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.table.DefaultTableModel;

import infviewer.workspace.model.Row;

public class CustomTableModel extends DefaultTableModel 
{
	private static final long serialVersionUID = 1026040904589494479L;
	private List<Row> rows;
	
	public CustomTableModel(List<Row> rows, Object[] columnNames)
	{
		this.setColumnIdentifiers(columnNames);
		this.rows = new ArrayList<>(rows);
	}
	
	@Override
	public boolean isCellEditable(int row, int column) 
	{
		return false;
	}
	
	@Override
	public Class<?> getColumnClass(int arg0)
	{
		if (rows == null) rows = new ArrayList<>();
		for (Row row : rows)
		{
			if (row.getFields().get(arg0) != null)
			{
				return row.getFields().get(arg0).getClass();				
			}
		}
		return null;
	}
	
	@Override
	public int getRowCount() 
	{
		if (rows == null) rows = new ArrayList<>();
		return rows.size();
	}

	@Override
	public int getColumnCount() 
	{
		if (rows == null) rows = new ArrayList<>();
		if (rows.size() == 0) return 0;
		return rows.get(0).getFields().size();
	}
	
	@Override
	public Object getValueAt(int row, int column) 
	{
		if (rows == null) rows = new ArrayList<>();
		
		if (rows.get(row).getFields().get(column) == null)
		{
			return null;
		}
		
		if (this.getColumnClass(column).equals(Date.class) && rows.get(row).getFields().get(column) instanceof Date)
		{
			DateFormat df = DateFormat.getDateInstance(DateFormat.DEFAULT, Locale.getDefault());
			String formattedDate = df.format(rows.get(row).getFields().get(column));
			return formattedDate;
		}
		else if ((this.getColumnClass(column).equals(Integer.class) && rows.get(row).getFields().get(column) instanceof Integer) ||
				(this.getColumnClass(column).equals(Float.class) && rows.get(row).getFields().get(column) instanceof Float))
		{
			return NumberFormat.getInstance(Locale.getDefault()).format(rows.get(row).getFields().get(column));
		}
		else
		{
			return rows.get(row).getFields().get(column);			
		}
	}
	
	@Override
	public void setValueAt(Object aValue, int row, int column) 
	{
		if (rows == null) rows = new ArrayList<>();
		rows.get(row).getFields().set(column, aValue);
		this.fireTableDataChanged();
	}
	
	public void setData(List<Row> rows)
	{
		this.rows = new ArrayList<>(rows);
		this.fireTableDataChanged();
	}
}