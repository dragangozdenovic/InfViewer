package infviewer.workspace.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import infviewer.app.ApplicationSingleton;
import infviewer.tree.model.Table;
import infviewer.workspace.controller.CancelActionListener;
import infviewer.workspace.model.Row;

public class UpdateDialogView extends JDialog 
{
	private static final long serialVersionUID = 7483741075109604028L;
	
	private UpdateDialogFieldPane fieldPane;
	private DialogButtonPane buttonPane;
	private Table table;
	private ResourceBundle resourceBundle = ApplicationSingleton.getInstance().getResourceBundle();
	private CustomTable customTable;
	private int rowindex;

	public UpdateDialogView(Table table) {
		   
		   this.table = table;	
		   this.setTitle(resourceBundle.getString("updateIn") + " " + table.getLabel());
		   this.setLayout(new BorderLayout());
		   this.setResizable(false);
		   this.setModal(true);
		   this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		   
		   fieldPane = new UpdateDialogFieldPane(table);
		   this.add(fieldPane, BorderLayout.CENTER);
		   buttonPane = new DialogButtonPane(table, resourceBundle.getString("confirmOption"));
		   buttonPane.cancelButton.addActionListener(new CancelActionListener(this));
		   this.add(buttonPane, BorderLayout.SOUTH);
		   
		   JPanel required = new JPanel();
		   JLabel label = new JLabel(resourceBundle.getString("requiredFields"));
		   required.add(label); 
		   buttonPane.add(required, BorderLayout.SOUTH);
		   this.add(buttonPane, BorderLayout.SOUTH);
		   
		   this.setSize(350, table.getColumns().size()*40 + 100);
		   this.setLocationRelativeTo(ApplicationSingleton.getInstance().getApplicationMainFrame());
		   this.buttonPane.getCancelButton().addActionListener(new ActionListener() 
		   {
			   @Override
		 	   public void actionPerformed(ActionEvent arg0) 
			   {
				   UpdateDialogView.this.dispose();
			   }
		   });
		   
		   this.buttonPane.getOkButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 for (DialogElement dialogElement : UpdateDialogView.this.fieldPane.getFieldsInPanel())
				   {
					   if (dialogElement instanceof DateElement)
					   {
						   if (((DateElement) dialogElement).getText().isEmpty())
						   {
							   if (dialogElement.mandatory)
							   {
								   dialogElement.setValid(false);
							   }
							   else
							   {
								   dialogElement.setValid(true);
							   }
						   }
						   else if (dialogElement.getValue() == null)
						   {
							   dialogElement.setValid(false);
						   }
						   else
						   {
							   dialogElement.setValid(true);
						   }
					   }
					   if (!dialogElement.isValid())
					   {
						   JOptionPane.showMessageDialog(null, dialogElement.validationMessage(), resourceBundle.getString("errorHeader"), JOptionPane.ERROR_MESSAGE);
						   return;
					   }
				   }   
				 
				   Row row = new Row();
				   for (DialogElement dialogElement : UpdateDialogView.this.fieldPane.getFieldsInPanel())
				   {
					   row.addField(dialogElement.getValue());
				   }
				  ApplicationSingleton.getInstance().getFactory().createCRUD().update(row,table);
					
					table.setRow(rowindex, row);
				   ((CustomTableModel)customTable.getModel()).setData(table.getRows());
				   
				   UpdateDialogView.this.dispose();
			}
		});
	}
	
	public void setFieldValues(int rowIndex)
	{
		rowindex=rowIndex;
		Row row = this.table.getRows().get(rowIndex);
		this.fieldPane.setFields(row);
	}
	public void setCustomTable(CustomTable customTable) {
		this.customTable = customTable;
	}
}
