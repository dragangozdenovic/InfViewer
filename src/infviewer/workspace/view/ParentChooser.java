package infviewer.workspace.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import infviewer.app.ApplicationSingleton;
import infviewer.workspace.controller.DemoteAction;

public class ParentChooser extends JDialog 
{
	private static final long serialVersionUID = -5878473629723429913L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox<String> comboBox;
	private ResourceBundle resourceBundle = ApplicationSingleton.getInstance().getResourceBundle();

	public ParentChooser(DemoteAction demoteAction, String[] tableNames) 
	{
		setTitle(resourceBundle.getString("chooseParent"));
		setResizable(false);
		setModal(true);
		setBounds(0, 0, 300, 200);
		setLocationRelativeTo(ApplicationSingleton.getInstance().getApplicationMainFrame());
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			comboBox = new JComboBox<String>();
			comboBox.setModel(new DefaultComboBoxModel<>(tableNames));
			comboBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
			comboBox.setMaximumRowCount(100);
			contentPanel.add(comboBox);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(new ActionListener()
				{	
					@Override
					public void actionPerformed(ActionEvent e)
					{
						demoteAction.demote(demoteAction.getTable(), (String)comboBox.getSelectedItem());
						ParentChooser.this.dispose();
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton(resourceBundle.getString("cancelOption"));
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new ActionListener() 
				{	
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						ParentChooser.this.dispose();
					}
				});
				buttonPane.add(cancelButton);
			}
		}
	}

}
