package infviewer.workspace.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import infviewer.tree.model.Table;
import infviewer.workspace.miscellaneous.DialogElementResources;
import infviewer.workspace.model.Column;

public class SearchDialogFieldPane extends JPanel {
	
	private static final long serialVersionUID = -965050958005183566L;
	
	protected List<List<DialogElementInterface>> searchDialogElements = new ArrayList<>();
	
	protected int fieldsInPanel;

	private GridBagConstraints gbc;
	private Table table;

	public SearchDialogFieldPane(Table table) {
		
	   this.setLayout(new GridBagLayout());
	   gbc = new GridBagConstraints();		   
	   gbc.weighty = 0.5;
	   gbc.weightx = 0.5;
	   this.table = table;
	   
	   initFields();
	}

	public void initFields()
	{
		   int y = 0;
		   
		   for(Column c : table.getColumns()) {

			   //dodaj labelu
			   gbc.gridx = 0;
			   gbc.gridy = y;
			   this.add(new JLabel(c.getLabel()), gbc);
			   
			   //dodaj komponentu u zavisnosti od tipa kolone
			   gbc.gridx = 1;
			   gbc.gridy = y;
			   
			   List<DialogElementInterface> components = new DialogElementResources(c).getSearchDialogMap().get(c.getDataType());
			   if (components == null)
			   {
				   continue;
			   }
			   this.searchDialogElements.add(components);
			   
			   for(DialogElementInterface dialogElement : components) {
				   JComponent jc = dialogElement.createDialogElement();
				   this.add(jc, gbc);
				   gbc.gridx++;
			   }
			   
			   fieldsInPanel++;

			   y++;
		   }
	}
}