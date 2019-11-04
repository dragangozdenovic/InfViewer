package infviewer.workspace.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JDialog;

import infviewer.app.ApplicationSingleton;
import infviewer.tree.model.Table;
import infviewer.workspace.controller.CancelActionListener;
import infviewer.workspace.model.Row;

public class SearchDialogView extends JDialog {

	private static final long serialVersionUID = -7364781245397947669L;
	private SearchDialogFieldPane fieldPane;
	private DialogButtonPane buttonPane;
	private CustomTable customTable;
	private ResourceBundle resourceBundle = ApplicationSingleton.getInstance().getResourceBundle();

	public SearchDialogView(Table table) {
			
		   this.setTitle(resourceBundle.getString("searchIn") + " " + table.getLabel());
		   this.setLayout(new BorderLayout());
		   this.setResizable(false);
		   this.setModal(true);
		   this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		   
		   fieldPane = new SearchDialogFieldPane(table);
		   this.add(fieldPane, BorderLayout.CENTER);
		   buttonPane = new DialogButtonPane(table, resourceBundle.getString("searchOption"));
		   buttonPane.cancelButton.addActionListener(new CancelActionListener(this));
		   this.add(buttonPane, BorderLayout.SOUTH);
		   this.buttonPane.getOkButton().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Row> rows = ApplicationSingleton.getInstance().getFactory().createCRUD().search(table, fieldPane.searchDialogElements);
                table.removeAllRows();
                for(Row row : rows) {
                    table.addRows(row);
                }
                ((CustomTableModel)customTable.getModel()).setData(table.getRows());
                SearchDialogView.this.dispose();
            }
        });
		   this.setSize(500, table.getColumns().size()*40 + 70);
		   this.setLocationRelativeTo(ApplicationSingleton.getInstance().getApplicationMainFrame());
	}
	
	public void setCustomTable(CustomTable customTable) {
        this.customTable = customTable;
    }
}
