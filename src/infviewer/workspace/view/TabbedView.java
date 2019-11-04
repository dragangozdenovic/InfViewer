package infviewer.workspace.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import infviewer.app.ApplicationSingleton;
import infviewer.tree.model.Table;
import infviewer.view.ApplicationMainFrame;
import infviewer.workspace.model.Row;

public class TabbedView extends JTabbedPane
{
	private static final long serialVersionUID = 2374390327498714359L;
	private static final ImageIcon CLOSE_ICON = new ImageIcon(new ImageIcon("resources/images/close_icon.png").getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
	private static final ImageIcon LARGE_CLOSE_ICON = new ImageIcon(new ImageIcon("resources/images/close_icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
	private static final Cursor HAND_CURSOR = new Cursor(Cursor.HAND_CURSOR);
	protected List<Tab> tabs;

	public TabbedView() 
	{
		super(TOP, SCROLL_TAB_LAYOUT);
		this.setMinimumSize(new Dimension(ApplicationMainFrame.windowSize.width / 5, 0));
		
		this.addChangeListener(new ChangeListener() 
		{	
			@Override
			public void stateChanged(ChangeEvent e) 
			{
				if (TabbedView.this.equals(ApplicationSingleton.getInstance().getParentView()))
				{
					for(Tab tab : TabbedView.this.getTabs())
					{
						tab.getParentView().getTableScrollPane().getTable().clearSelection();
						
						List<Row> rows = ApplicationSingleton
								.getInstance()
								.getFactory()
								.createCRUD()
								.read(tab.getTable(), null);
						tab.getTable().setRows(rows);
						tab.getParentView().getTableScrollPane().getTable().setData(rows);
						if (tab.getChildView() != null)
						{
							for (Tab childTab : tab.getChildView().getTabs())
							{
								childTab.getParentView().getTableScrollPane().getTable().clearSelection();
								
								List<Row> childRows = ApplicationSingleton
										.getInstance()
										.getFactory()
										.createCRUD()
										.read(childTab.getTable(), null);
								
								childTab.getTable().setRows(childRows);
								childTab.getParentView().getTableScrollPane().getTable().setData(childRows);
							}							
						}
					}					
				}
			}
		});
	}
	
	public void addTab(Table table)
	{
		Tab tab = new Tab(table, (this instanceof ChildTabbedView) ? new ChildButtonPane(table) : new ParentButtonPane(table));
		this.add(tab, table);
	}
	
	public void addTab(Table table, TabbedView childView)
	{
		Tab tab = new Tab(table, childView);
		this.add(tab, table);
	}
	
	public void add(Tab tab, Table table)
	{
		this.addTab(tab);
		this.add(table.getLabel(), tab);
		int index = this.getTabCount() - 1;
		this.setTabComponentAt(index, createTab(table));
		this.selectTab(table);
	}
	
	public void removeTab(String title)
	{
		int index = this.indexOfTab(title);
		this.removeTabAt(index);
		this.removeTabFromList(index);
	}
	
	public boolean isTabExists(Table table)
	{
		for (Tab tab : this.getTabs())
		{
			if (tab.getTable().getName().equals(table.getName()))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public void selectTab(Table table)
	{
		for (int i = 0; i < this.getTabs().size(); i++)
		{
			if (this.tabs.get(i).getTable().getName().equals(table.getName()))
			{
				setSelectedIndex(i);
				break;
			}
		}
	}
	
	public JPanel createUnclosableTab(String title)
	{
		JPanel customTab = new JPanel();
		customTab.setLayout(new BoxLayout(customTab, BoxLayout.X_AXIS));
		customTab.setOpaque(false);
		
		JLabel lblTitle = new JLabel(title);
		lblTitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblTitle.setForeground(new Color(229, 137, 0));
		customTab.add(lblTitle);
		
		return customTab;
	}
	
	public JPanel createTab(Table table)
	{
		JPanel customTab = createUnclosableTab(table.getLabel());
		
		JButton btnClose = new JButton(CLOSE_ICON);
		btnClose.setBorderPainted(false);
        btnClose.setContentAreaFilled(false); 
		btnClose.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				TabbedView.this.removeTab(table.getLabel());
			}
		});
		btnClose.addMouseListener(new MouseListener() 
		{	
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				this.setNewDimension(LARGE_CLOSE_ICON);
				btnClose.setCursor(HAND_CURSOR);
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				this.setNewDimension(CLOSE_ICON);
			}

			private void setNewDimension(ImageIcon imageIcon)
			{
				btnClose.setIcon(imageIcon);
				SwingUtilities.updateComponentTreeUI(btnClose);
			}
			@Override
			public void mouseReleased(MouseEvent e) { }
			@Override
			public void mousePressed(MouseEvent e) { }
			@Override
			public void mouseClicked(MouseEvent e) { }
		});

		customTab.add(Box.createHorizontalStrut(10));
		customTab.add(btnClose);
		
		customTab.setPreferredSize(new Dimension((int)customTab.getPreferredSize().getWidth(), (int)customTab.getPreferredSize().getHeight() + 8));
		return customTab;
	}
	
	public List<Tab> getTabs()
	{
    	if (tabs == null)
    		tabs = new java.util.ArrayList<Tab>();
    	return tabs;
    }
   
    public void addTab(Tab newTab) 
    {
    	if (newTab == null)
    		return;
    	if (this.tabs == null)
    		this.tabs = new ArrayList<Tab>();
    	if (!this.tabs.contains(newTab))
    		this.tabs.add(newTab);
    }
   
    public void removeTabFromList(int index)
    {
    	if (this.tabs != null)
    	{
    		if (index >= this.tabs.size())
    		{
    			return;
    		}
    		this.tabs.remove(index);
    	}
   }
}