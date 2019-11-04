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
import infviewer.editor.controller.JSONValidator;
import infviewer.tree.model.Table;
import infviewer.workspace.controller.CancelActionListener;
import infviewer.workspace.model.Row;

public class AddDialogView extends JDialog{
	
	private static final long serialVersionUID = 1L;
	
	private AddDialogFieldPane fieldPane;
	private DialogButtonPane buttonPane;
	private CustomTable customTable;
	private ResourceBundle resourceBundle = ApplicationSingleton.getInstance().getResourceBundle();
	
	public AddDialogView(Table table) {
		   
		   this.setTitle(resourceBundle.getString("addTo") + table.getLabel());
		   this.setLayout(new BorderLayout());
		   this.setResizable(false);
		   this.setModal(true);
		   this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		   
		   fieldPane = new AddDialogFieldPane(table);
		   this.add(fieldPane, BorderLayout.CENTER);
		   buttonPane = new DialogButtonPane(table, resourceBundle.getString("addOption"));
		   buttonPane.cancelButton.addActionListener(new CancelActionListener(this));
		   
		   JPanel requiredInfoPane = new JPanel();
		   JLabel label = new JLabel(resourceBundle.getString("requiredFields"));
		   requiredInfoPane.add(label); 
		   buttonPane.add(requiredInfoPane, BorderLayout.SOUTH);
		   
		   this.add(buttonPane, BorderLayout.SOUTH);
		   
		   this.setSize(350, table.getColumns().size()*40 + 100);
		   this.setLocationRelativeTo(ApplicationSingleton.getInstance().getApplicationMainFrame());

		   this.buttonPane.getCancelButton().addActionListener(new ActionListener() 
		   {
			   @Override
		 	   public void actionPerformed(ActionEvent arg0) 
			   {
				   AddDialogView.this.dispose();
			   }
		   });
		   
		   this.buttonPane.getOkButton().addActionListener(new ActionListener() 
		   {
			   @Override
			   public void actionPerformed(ActionEvent e) 
			   {
				   for (DialogElement dialogElement : AddDialogView.this.fieldPane.getFieldsInPanel())
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
				   
				   //INSERT
				   Row row = new Row();
				   for (DialogElement dialogElement : AddDialogView.this.fieldPane.getFieldsInPanel())
				   {
					   row.addField(dialogElement.getValue());
				   }
				   
				   if (!ApplicationSingleton.getInstance().getFactory().createCRUD().create(row, table))
				   {
					   JOptionPane.showMessageDialog(null, resourceBundle.getString("checkDataError"), resourceBundle.getString("errorHeader"), JOptionPane.ERROR_MESSAGE);
					   return;
				   }
				   
				   //Update model and view
				   table.addRows(row);
				   ((CustomTableModel)customTable.getModel()).setData(table.getRows());
				   
				   AddDialogView.this.dispose();
				   JOptionPane.showMessageDialog(null, resourceBundle.getString("rowAdded"), resourceBundle.getString("successHeader"), JOptionPane.INFORMATION_MESSAGE, JSONValidator.SUCCESS_ICON);
			   }
		   });
	}
	
	public void setCustomTable(CustomTable customTable) {
		this.customTable = customTable;
	}
}