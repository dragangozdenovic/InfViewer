package infviewer.tree.view;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import infviewer.model.Element;
import infviewer.tree.controller.TreeMouseListener;
import infviewer.tree.model.FKPairs;
import infviewer.tree.model.ForeignKey;
import infviewer.tree.model.Package;
import infviewer.tree.model.Table;
import infviewer.workspace.model.Column;

public class ApplicationTree extends JTree
{
	private static final long serialVersionUID = -3967112636693622437L;
	private DefaultTreeModel treeModel;
	
	public ApplicationTree(DefaultTreeModel treeModel)
	{
		super(treeModel);
		this.treeModel = treeModel;
		this.setEditable(false);
		this.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		this.setCellRenderer(new CustomTreeRenderer());
		this.addMouseListener(new TreeMouseListener(this));
    }
	
	public void fillTree(Package mainPackage)
	{
		DefaultMutableTreeNode packageNode = addNode(mainPackage);
		selectNode(packageNode);
		
		for(Package subpackage : mainPackage.getSubpackages())
		{
			fillTree(subpackage);
		}
		
		for(Table table : mainPackage.getTables())
		{
			boolean child = false;
			for (ForeignKey foreignKey : table.getForeignkeys())
			{
				for (FKPairs pair : foreignKey.getFkpairs())
				{
					Column column = table.getColumnByName(pair.getReferencing());
					
					//Ukoliko se referencirajuca kolona nalazi u sklopu primarnog kljuca
					//Tabela je child barem jednoj tabeli
					if (column.isPrimaryKey())
					{
						child = true;
					}
					else
					{
						child = false;
					}
				}
				
				if (child)
				{
					break;
				}
			}
			
			if (!child)
			{
				addNode(table);
			}
		}
		
		for(Table table : mainPackage.getTables())
		{
			for (ForeignKey foreignKey : table.getForeignkeys())
			{
				boolean isPrimaryKey = true;
				for (FKPairs pair : foreignKey.getFkpairs())
				{
					Column column = table.getColumnByName(pair.getReferencing());
					
					if (!column.isPrimaryKey())
					{
						isPrimaryKey = false;
						break;
					}
				}
				if (isPrimaryKey)
				{
					List<DefaultMutableTreeNode> referencedTableNodes = find((DefaultMutableTreeNode)this.getModel().getRoot(), foreignKey.getReferencedTable());
					for (DefaultMutableTreeNode node : referencedTableNodes)
					{
						selectNode(node);
						addNode(table);
					}
				}
			}
		}
		
		if (packageNode.getParent() != null)
		{
			selectNode((DefaultMutableTreeNode)packageNode.getParent());
		}
		else
		{
			selectNode(packageNode);
		}
	}
	
	public DefaultMutableTreeNode addNode(Object newNodeObject) 
	{
		if (newNodeObject != null)
		{
		   DefaultMutableTreeNode newNode = null;
		   if (this.treeModel.getRoot() == null)
		   {
			   Package rootObject = (Package)newNodeObject;
			   newNode = new DefaultMutableTreeNode(rootObject);
			   this.treeModel.setRoot(newNode);   
		   }
		   else
		   {
			   DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) this.getLastSelectedPathComponent();
			   if (selectedNode != null && selectedNode.getAllowsChildren()) 
			   {
				   newNode = new DefaultMutableTreeNode();
				   
				   //Zavisno od tipa poslatog objekta u stablu postavljamo tip novog cvora
				   if(newNodeObject instanceof Package) 
				   {
					   newNode.setUserObject((Package)newNodeObject);
				   }
				   else if(newNodeObject instanceof Table) 
				   {
					   newNode.setUserObject((Table)newNodeObject);
				   }
				   
				   treeModel.insertNodeInto(newNode, selectedNode, selectedNode.getChildCount());
			   }
		   }
		   return newNode;
	   }
		
	   return null;
   }
	
   public void selectNode(DefaultMutableTreeNode nodeToSelect)
   {
	   this.setSelectionPath(new TreePath(nodeToSelect.getPath()));
       this.scrollPathToVisible(new TreePath(nodeToSelect.getPath()));
   }
   
   public List<DefaultMutableTreeNode> find(DefaultMutableTreeNode root, String name) 
   {
	    @SuppressWarnings("unchecked")
	    Enumeration<DefaultMutableTreeNode> e = root.depthFirstEnumeration();
	    List<DefaultMutableTreeNode> nodes = new ArrayList<>();
	    while (e.hasMoreElements()) {
	        DefaultMutableTreeNode node = e.nextElement();
	        if (node.getUserObject() instanceof Element)
	        {
	        	Element schemaElement = (Element)node.getUserObject();
	        	if (schemaElement.getName().equals(name))
	        	{
	        		nodes.add(node);
	        	}	        	
	        }
	    }
	    return nodes;
   }
}