package infviewer.editor.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import infviewer.app.ApplicationSingleton;
import infviewer.editor.controller.Action;
import infviewer.editor.model.Editor;

public class MetaSchemaLoaderDialog extends JDialog 
{
	private static final long serialVersionUID = -134466728595092832L;
	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JButton cancelButton;
	private JButton okButton;
	private JTextField textField;
	private JLabel lblLocation;
	private JButton btnBrowse;
	private JCheckBox chckbxRemember;
	private File currentMetaSchema;
	private ResourceBundle resourceBundle = ApplicationSingleton.getInstance().getResourceBundle();

	public MetaSchemaLoaderDialog(String title, boolean remember) 
	{
		setTitle(title);
		setResizable(false);
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(EditorMainFrame.windowSize.width / 3, EditorMainFrame.windowSize.height / 6);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 50, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			lblLocation = new JLabel(resourceBundle.getString("location"));
			lblLocation.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
			GridBagConstraints gbc_lblLocation = new GridBagConstraints();
			gbc_lblLocation.gridwidth = 2;
			gbc_lblLocation.insets = new Insets(0, 0, 5, 5);
			gbc_lblLocation.gridx = 0;
			gbc_lblLocation.gridy = 1;
			contentPanel.add(lblLocation, gbc_lblLocation);
		}
		{
			textField = new JTextField();
			textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 5);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 2;
			gbc_textField.gridy = 1;
			contentPanel.add(textField, gbc_textField);
			textField.setColumns(10);
		}
		{
			btnBrowse = new JButton(resourceBundle.getString("browseLabel"));
			btnBrowse.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
			btnBrowse.addActionListener(new ActionListener() 
			{
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					currentMetaSchema = Editor.open("JSON file (*.json)", "json");
					if (currentMetaSchema != null && currentMetaSchema.exists())
					{
						textField.setText(currentMetaSchema.getAbsolutePath());
						textField.setCaretPosition(0);						
					}
				}
			});
			GridBagConstraints gbc_btnBrowse = new GridBagConstraints();
			gbc_btnBrowse.insets = new Insets(0, 0, 5, 0);
			gbc_btnBrowse.gridx = 3;
			gbc_btnBrowse.gridy = 1;
			contentPanel.add(btnBrowse, gbc_btnBrowse);
		}
		if (remember)
		{
			chckbxRemember = new JCheckBox(resourceBundle.getString("remember"));
			chckbxRemember.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
			GridBagConstraints gbc_chckbxRemember = new GridBagConstraints();
			gbc_chckbxRemember.gridwidth = 2;
			gbc_chckbxRemember.insets = new Insets(0, 0, 0, 5);
			gbc_chckbxRemember.gridx = 0;
			gbc_chckbxRemember.gridy = 2;
			contentPanel.add(chckbxRemember, gbc_chckbxRemember);
		}
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setPreferredSize(new Dimension(80, 25));
				okButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton(resourceBundle.getString("cancelOption"));
				cancelButton.setPreferredSize(new Dimension(80, 25));
				cancelButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new ActionListener() 
				{	
					@Override
					public void actionPerformed(ActionEvent arg0) 
					{
						MetaSchemaLoaderDialog.this.dispose();
					}
				});
				buttonPane.add(cancelButton);
			}
		}		
	}

	public void setOkButtonAction(Action action) 
	{
		this.okButton.setAction(action);
	}

	public JTextField getTextField() {
		return textField;
	}

	public JCheckBox getChckbxRemember() {
		return chckbxRemember;
	}
}