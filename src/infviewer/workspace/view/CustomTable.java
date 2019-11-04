package infviewer.workspace.view;

import java.awt.Color;
import java.util.HashMap;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;

import infviewer.app.ApplicationSingleton;
import infviewer.tree.model.FKPairs;
import infviewer.tree.model.ForeignKey;
import infviewer.tree.model.Table;
import infviewer.workspace.model.Column;
import infviewer.workspace.model.Row;

public class CustomTable extends JTable
{
	private static final long serialVersionUID = -793673166239538911L;
	private Table table;
	private CustomTableModel tableModel;
	
	public CustomTable(Table table) 
	{
		this.getTableHeader().setBackground(new Color(94, 200, 255));
		this.table = table;

		Object[] columnNames = this.getColumnsHeader();
		this.tableModel = new CustomTableModel(table.getRows(), columnNames);
		this.setModel(this.tableModel);
		
		CustomTableCellRenderer myTableCellRenderer = new CustomTableCellRenderer(this.getSelectionBackground());
		for (int i = 0; i < this.getColumnCount(); i++) 
		{
	        TableColumn column = this.getColumnModel().getColumn(i);
	        column.setCellRenderer(myTableCellRenderer);
	    }
		
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				TabbedView parentView = ApplicationSingleton.getInstance().getParentView();
				if (parentView.getSelectedIndex() != -1)
				{
					Tab tab = parentView.getTabs().get(parentView.getSelectedIndex());
					if (tab.getTable().getName().equals(CustomTable.this.table.getName()) && tab.getChildView() != null)
					{
						Table currentTable = CustomTable.this.table;
						if (CustomTable.this.getSelectedRow() != -1)
						{
							Row row = currentTable.getRows().get(CustomTable.this.getSelectedRow());
							
							HashMap<String, Object> key = new HashMap<String, Object>();
							
							for (Tab childTab : tab.getChildView().getTabs())
							{
								for (ForeignKey foreignKey : childTab.getTable().getForeignkeys())
								{
									if (foreignKey.getReferencedTable().equals(currentTable.getName()))
									{
										for (FKPairs pair : foreignKey.getFkpairs())
										{
											int index = currentTable.getColumns().indexOf(currentTable.getColumnByName(pair.getReferenced()));
											key.put(pair.getReferencing(), row.getFields().get(index));
										}
									}
								}
								
								List<Row> rows = ApplicationSingleton
										.getInstance()
										.getFactory()
										.createCRUD()
										.read(childTab.getTable(), key);
								
								childTab.getTable().setRows(rows);
								childTab.getParentView().getTableScrollPane().getTable().setData(rows);
								key.clear();
							}							
						}
					}
				}
	        }
		});
	}
	
	
	public void setData(List<Row> rows)
	{
		this.tableModel.setData(rows);
	}
	
	public Object[] getColumnsHeader()
	{
		List<Column> columns = this.table.getColumns();
		Object[] columnNames = new Object[columns.size()];
		
		for (int i = 0; i < columns.size(); i++)
		{
			columnNames[i] = columns.get(i).getLabel();
		}
		
		return columnNames;
	}


	public Table getTable() {
		return table;
	}


	public void setTable(Table table) {
		this.table = table;
	}
}