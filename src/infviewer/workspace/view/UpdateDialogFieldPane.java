package infviewer.workspace.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;

import infviewer.app.ApplicationSingleton;
import infviewer.tree.model.FKPairs;
import infviewer.tree.model.ForeignKey;
import infviewer.tree.model.Table;
import infviewer.workspace.miscellaneous.DialogElementResources;
import infviewer.workspace.model.Column;
import infviewer.workspace.model.Row;

public class UpdateDialogFieldPane extends JPanel 
{
	private static final long serialVersionUID = 3693583406271158464L;
	protected List<DialogElement> fieldsInPanel = new ArrayList<DialogElement>();

	public UpdateDialogFieldPane(Table table) {
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		   
	   int y = 0;
	   gbc.weighty = 0.5;
	   gbc.weightx = 0.5;
	   
	   for(Column c : table.getColumns()) {

		   //dodaj labelu
		   gbc.gridx = 0;
		   gbc.gridy = y;
		   StringBuilder label = new StringBuilder(c.getLabel());
		   if (c.isMandatory())
		   {
			   label.insert(0, "* ");
		   }
		   this.add(new JLabel(label.toString()), gbc);
		   		   
		   //dodaj komponentu u zavisnosti od tipa kolone
		   gbc.gridx = 1;
		   gbc.gridy = y;
		   DialogElement dialogElement = new DialogElementResources(c).getCreateDialogMap().get(c.getDataType());
		   if (dialogElement == null)
		   {
			   continue;
		   }
		   JComponent component = dialogElement.createDialogElement();
		   
		   //Zabrana promene vrednosti primarnog kljuca
		   if (c.isPrimaryKey())
		   {
			   component.setEnabled(false);
		   }
		   fieldsInPanel.add(dialogElement);
		   this.add(component, gbc);
		   
		   
		   Table referencedTable = null;
		   for (ForeignKey foreignKey : table.getForeignkeys())
		   {
			   for (FKPairs pair : foreignKey.getFkpairs())
			   {
				   if (pair.getReferencing().equals(c.getName()))
				   {
			   referencedTable = (Table)ApplicationSingleton.getInstance().getApplicationMainFrame().getTreeView().getTree().find(
					   							(DefaultMutableTreeNode)ApplicationSingleton.getInstance().getApplicationMainFrame().
					   													getTreeView().
					   													getTree().
					   													getModel().
					   													getRoot(), foreignKey.getReferencedTable()).get(0).getUserObject();
			   
			   
					   break;
				   }
			   }
		   }
		   if (referencedTable != null)
		   {
			   List<Row> rows = ApplicationSingleton
					   .getInstance()
					   .getFactory()
					   .createCRUD()
					   .read(referencedTable, null);
			   referencedTable.setRows(rows);
			   
			   JButton zoomButton = new JButton(new ImageIcon("resources/images/zoom.png"));
			   zoomButton.setFocusPainted(false);
			   zoomButton.setBorderPainted(false);
			   zoomButton.setContentAreaFilled(false);
			   
			   final Table tmp = referencedTable;
			   zoomButton.addActionListener(new ActionListener() 
			   {
				   @Override
				   public void actionPerformed(ActionEvent arg0) 
				   {
					   ZoomButtonDialog zoom = new ZoomButtonDialog(UpdateDialogFieldPane.this, tmp);
					   zoom.setVisible(true);
				   }
			   });
			   
			   gbc.gridx = 2;
			   this.add(zoomButton, gbc);
		   }
		   
		   y++;
	   }
	}	 
	
	
	public List<DialogElement> getFieldsInPanel() {
		return fieldsInPanel;
	}


	public void setFields(Row row)
	{
		for (int i = 0; i < this.fieldsInPanel.size(); i++)
		{
			this.fieldsInPanel.get(i).setValue(row.getFields().get(i));
		}
	}
}
