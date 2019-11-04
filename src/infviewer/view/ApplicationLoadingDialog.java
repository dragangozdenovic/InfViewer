package infviewer.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import infviewer.app.ApplicationSingleton;
import infviewer.controller.LoadingDialogConfirmAction;
import infviewer.editor.model.Editor;

public class ApplicationLoadingDialog extends JDialog
{
	private static final long serialVersionUID = -392630233110315019L;
	private JTextField textFieldIPAddress;
	private JTextField textFieldDBName;
	private JTextField textFieldUsername;
	private JPasswordField passwordField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnJson;
	private JRadioButton rdbtnDatabase;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JRadioButton rdbtnSrpski;
	private JRadioButton rdbtnEnglish;
	private JTextField textFieldJSONFile;
	private JButton btnBrowse;	
	private JLabel lblipAddress;
	private JLabel lblDBName;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblChooseSchemaSource;
	private JLabel lblJsonFileLocation;
	private JLabel lblChooseApplicationLanguage;
	private JButton btnConfirm;
	private JButton btnCancel;
	private Locale serbianLocale = new Locale("sr","RS");
	private Locale englishLocale = new Locale("en","US");
	private JLabel lblEnterDatabaseConnection;
	
	
	public ApplicationLoadingDialog() 
	{	
		this.setTitle("InfViewer");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(3 * ApplicationMainFrame.windowSize.width / 5, 6 * ApplicationMainFrame.windowSize.height / 7);
		this.setMinimumSize(new Dimension(ApplicationMainFrame.windowSize.width / 3, 3 * ApplicationMainFrame.windowSize.height / 5));
		this.setLocationRelativeTo(null);
		this.setModal(true);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		lblEnterDatabaseConnection = new JLabel(ApplicationSingleton.getInstance().getResourceBundle().getString("databaseParametersLabel"));
		lblEnterDatabaseConnection.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnterDatabaseConnection.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		GridBagConstraints gbc_lblEnterDatabaseConnection = new GridBagConstraints();
		gbc_lblEnterDatabaseConnection.anchor = GridBagConstraints.WEST;
		gbc_lblEnterDatabaseConnection.gridwidth = 4;
		gbc_lblEnterDatabaseConnection.insets = new Insets(10, 10, 10, 10);
		gbc_lblEnterDatabaseConnection.gridheight = 3;
		gbc_lblEnterDatabaseConnection.gridx = 1;
		gbc_lblEnterDatabaseConnection.gridy = 0;
		getContentPane().add(lblEnterDatabaseConnection, gbc_lblEnterDatabaseConnection);
		
		lblipAddress = new JLabel(ApplicationSingleton.getInstance().getResourceBundle().getString("ipLabel"));
		lblipAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblipAddress.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		GridBagConstraints gbc_lblipAddress = new GridBagConstraints();
		gbc_lblipAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblipAddress.gridx = 1;
		gbc_lblipAddress.gridy = 3;
		getContentPane().add(lblipAddress, gbc_lblipAddress);
		
		textFieldIPAddress = new JTextField(ApplicationSingleton.getInstance().getProperties().getProperty("ipaddress"));
		textFieldIPAddress.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		GridBagConstraints gbc_textFieldIPAddress = new GridBagConstraints();
		gbc_textFieldIPAddress.gridwidth = 3;
		gbc_textFieldIPAddress.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldIPAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldIPAddress.gridx = 2;
		gbc_textFieldIPAddress.gridy = 3;
		getContentPane().add(textFieldIPAddress, gbc_textFieldIPAddress);
		textFieldIPAddress.setColumns(10);
		
		lblDBName = new JLabel(ApplicationSingleton.getInstance().getResourceBundle().getString("databaseNameLabel"));
		lblDBName.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDBName = new GridBagConstraints();
		gbc_lblDBName.insets = new Insets(0, 0, 5, 5);
		gbc_lblDBName.gridx = 1;
		gbc_lblDBName.gridy = 4;
		getContentPane().add(lblDBName, gbc_lblDBName);
		
		textFieldDBName = new JTextField(ApplicationSingleton.getInstance().getProperties().getProperty("dbname"));
		textFieldDBName.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		GridBagConstraints gbc_textFieldDBName = new GridBagConstraints();
		gbc_textFieldDBName.gridwidth = 3;
		gbc_textFieldDBName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDBName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDBName.gridx = 2;
		gbc_textFieldDBName.gridy = 4;
		getContentPane().add(textFieldDBName, gbc_textFieldDBName);
		textFieldDBName.setColumns(10);
		
		lblUsername = new JLabel(ApplicationSingleton.getInstance().getResourceBundle().getString("usernameLabel"));
		lblUsername.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 1;
		gbc_lblUsername.gridy = 5;
		getContentPane().add(lblUsername, gbc_lblUsername);
		
		textFieldUsername = new JTextField(ApplicationSingleton.getInstance().getProperties().getProperty("username"));
		textFieldUsername.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		GridBagConstraints gbc_textFieldUsername = new GridBagConstraints();
		gbc_textFieldUsername.gridwidth = 3;
		gbc_textFieldUsername.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldUsername.gridx = 2;
		gbc_textFieldUsername.gridy = 5;
		getContentPane().add(textFieldUsername, gbc_textFieldUsername);
		textFieldUsername.setColumns(10);
		
		lblPassword = new JLabel(ApplicationSingleton.getInstance().getResourceBundle().getString("passwordLabel"));
		lblPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 6;
		getContentPane().add(lblPassword, gbc_lblPassword);
		
		passwordField = new JPasswordField(ApplicationSingleton.getInstance().getProperties().getProperty("password"));
		passwordField.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 3;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 6;
		getContentPane().add(passwordField, gbc_passwordField);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator.gridwidth = 6;
		gbc_separator.insets = new Insets(10, 0, 10, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 7;
		getContentPane().add(separator, gbc_separator);
		
		lblChooseSchemaSource = new JLabel(ApplicationSingleton.getInstance().getResourceBundle().getString("chooseSchemaLabel"));
		lblChooseSchemaSource.setHorizontalAlignment(SwingConstants.LEFT);
		lblChooseSchemaSource.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		GridBagConstraints gbc_lblChooseSchemaSource = new GridBagConstraints();
		gbc_lblChooseSchemaSource.anchor = GridBagConstraints.WEST;
		gbc_lblChooseSchemaSource.gridwidth = 4;
		gbc_lblChooseSchemaSource.insets = new Insets(10, 10, 10, 10);
		gbc_lblChooseSchemaSource.gridx = 1;
		gbc_lblChooseSchemaSource.gridy = 8;
		getContentPane().add(lblChooseSchemaSource, gbc_lblChooseSchemaSource);
		
		rdbtnJson = new JRadioButton("JSON");
		rdbtnJson.setFocusPainted(false);
		rdbtnJson.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		rdbtnJson.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent e) {
				textFieldJSONFile.setEnabled(true);
				btnBrowse.setEnabled(true);
			}
		});
		buttonGroup.add(rdbtnJson);
		GridBagConstraints gbc_rdbtnJson = new GridBagConstraints();
		gbc_rdbtnJson.gridwidth = 2;
		gbc_rdbtnJson.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnJson.gridx = 1;
		gbc_rdbtnJson.gridy = 9;
		getContentPane().add(rdbtnJson, gbc_rdbtnJson);
		
		rdbtnDatabase = new JRadioButton(ApplicationSingleton.getInstance().getResourceBundle().getString("databaseLabel"));
		rdbtnDatabase.setSelected(true);
		rdbtnDatabase.setFocusPainted(false);
		rdbtnDatabase.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		rdbtnDatabase.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent e) {
				textFieldJSONFile.setEnabled(false);
				btnBrowse.setEnabled(false);
				
			}
		});
		buttonGroup.add(rdbtnDatabase);
		GridBagConstraints gbc_rdbtnDatabase = new GridBagConstraints();
		gbc_rdbtnDatabase.gridwidth = 2;
		gbc_rdbtnDatabase.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnDatabase.gridx = 3;
		gbc_rdbtnDatabase.gridy = 9;
		getContentPane().add(rdbtnDatabase, gbc_rdbtnDatabase);
		
		lblJsonFileLocation = new JLabel(ApplicationSingleton.getInstance().getResourceBundle().getString("jsonLocationLabel"));
		lblJsonFileLocation.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		GridBagConstraints gbc_lblJsonFileLocation = new GridBagConstraints();
		gbc_lblJsonFileLocation.insets = new Insets(0, 0, 5, 5);
		gbc_lblJsonFileLocation.gridx = 1;
		gbc_lblJsonFileLocation.gridy = 10;
		getContentPane().add(lblJsonFileLocation, gbc_lblJsonFileLocation);
		
		textFieldJSONFile = new JTextField(System.getProperty("user.dir") + "\\resources\\semaRedmine.json");
		textFieldJSONFile.setEnabled(false);
		textFieldJSONFile.setCaretPosition(0);
		textFieldJSONFile.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		GridBagConstraints gbc_textFieldJSONFile = new GridBagConstraints();
		gbc_textFieldJSONFile.gridwidth = 2;
		gbc_textFieldJSONFile.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldJSONFile.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldJSONFile.gridx = 2;
		gbc_textFieldJSONFile.gridy = 10;
		getContentPane().add(textFieldJSONFile, gbc_textFieldJSONFile);
		textFieldJSONFile.setColumns(10);
		
		btnBrowse = new JButton(ApplicationSingleton.getInstance().getResourceBundle().getString("browseLabel"));
		btnBrowse.setEnabled(false);
		btnBrowse.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnBrowse.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				File schema = Editor.open("JSON file (*.json)", "json");
				textFieldJSONFile.setText(schema.getAbsolutePath());
				textFieldJSONFile.setCaretPosition(0);						
			}
		});
		GridBagConstraints gbc_btnBrowse = new GridBagConstraints();
		gbc_btnBrowse.insets = new Insets(0, 0, 5, 5);
		gbc_btnBrowse.gridx = 4;
		gbc_btnBrowse.gridy = 10;
		getContentPane().add(btnBrowse, gbc_btnBrowse);
		
		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_1.gridwidth = 6;
		gbc_separator_1.insets = new Insets(10, 0, 10, 0);
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 11;
		getContentPane().add(separator_1, gbc_separator_1);
		
		lblChooseApplicationLanguage = new JLabel(ApplicationSingleton.getInstance().getResourceBundle().getString("chooseLanguageLabel"));
		lblChooseApplicationLanguage.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		GridBagConstraints gbc_lblChooseApplicationLanguage = new GridBagConstraints();
		gbc_lblChooseApplicationLanguage.anchor = GridBagConstraints.WEST;
		gbc_lblChooseApplicationLanguage.gridwidth = 4;
		gbc_lblChooseApplicationLanguage.insets = new Insets(10, 10, 10, 10);
		gbc_lblChooseApplicationLanguage.gridx = 1;
		gbc_lblChooseApplicationLanguage.gridy = 12;
		getContentPane().add(lblChooseApplicationLanguage, gbc_lblChooseApplicationLanguage);
		
		URL url = null;
		try
		{
			url = new File("resources/images/Serbia-flag.png").toURI().toURL();
		}
		catch (MalformedURLException e) { }
		
        String htmlSerbian = "<html><body><img src='" + url.toString() +"'><br><p align=\"center\">Srpski</p></body></html>";
		rdbtnSrpski = new JRadioButton(htmlSerbian);
		rdbtnSrpski.setFocusPainted(false);
		rdbtnSrpski.setSelected(true);
		rdbtnSrpski.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Locale.setDefault(serbianLocale);
				ApplicationSingleton.getInstance().changeLanguage();
				repaintComponents();
			}
		});
		buttonGroup_1.add(rdbtnSrpski);
		rdbtnSrpski.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		GridBagConstraints gbc_rdbtnSrpski = new GridBagConstraints();
		gbc_rdbtnSrpski.gridwidth = 2;
		gbc_rdbtnSrpski.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnSrpski.gridx = 1;
		gbc_rdbtnSrpski.gridy = 13;
		getContentPane().add(rdbtnSrpski, gbc_rdbtnSrpski);
		
		try 
		{
			url = new File("resources/images/Great Britain-flag.png").toURI().toURL();
		}
		catch (MalformedURLException e) { }
		
		String htmlEnglish = "<html><body><img src='" + url.toString() + "'><br><p align=\"center\">English</p></body></html>";
		rdbtnEnglish = new JRadioButton(htmlEnglish);
		rdbtnEnglish.setFocusPainted(false);
		rdbtnEnglish.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Locale.setDefault(englishLocale);
				ApplicationSingleton.getInstance().changeLanguage();
				repaintComponents();
			}
		});
		buttonGroup_1.add(rdbtnEnglish);
		rdbtnEnglish.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		GridBagConstraints gbc_rdbtnEnglish = new GridBagConstraints();
		gbc_rdbtnEnglish.gridwidth = 2;
		gbc_rdbtnEnglish.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnEnglish.gridx = 3;
		gbc_rdbtnEnglish.gridy = 13;
		getContentPane().add(rdbtnEnglish, gbc_rdbtnEnglish);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.SOUTH;
		gbc_panel.gridwidth = 4;
		gbc_panel.insets = new Insets(10, 10, 10, 10);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 15;
		getContentPane().add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 15));
		
		btnConfirm = new JButton(new LoadingDialogConfirmAction(ApplicationSingleton.getInstance().getResourceBundle().getString("confirmOption")));
		btnConfirm.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		panel.add(btnConfirm);
		btnCancel = new JButton(ApplicationSingleton.getInstance().getResourceBundle().getString("cancelOption"));
		btnCancel.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnCancel.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent e)
			{
				ApplicationLoadingDialog.this.dispatchEvent(new WindowEvent(ApplicationLoadingDialog.this, WindowEvent.WINDOW_CLOSING));
			}
		});
		panel.add(btnCancel);
	}
	
	public void repaintComponents() {
		lblEnterDatabaseConnection.setText(ApplicationSingleton.getInstance().getResourceBundle().getString("databaseParametersLabel"));
		lblipAddress.setText(ApplicationSingleton.getInstance().getResourceBundle().getString("ipLabel"));
		lblDBName.setText(ApplicationSingleton.getInstance().getResourceBundle().getString("databaseNameLabel"));		
		lblUsername.setText(ApplicationSingleton.getInstance().getResourceBundle().getString("usernameLabel")); 
		lblChooseSchemaSource.setText(ApplicationSingleton.getInstance().getResourceBundle().getString("chooseSchemaLabel"));
		rdbtnDatabase.setText(ApplicationSingleton.getInstance().getResourceBundle().getString("databaseLabel"));
		lblJsonFileLocation.setText(ApplicationSingleton.getInstance().getResourceBundle().getString("jsonLocationLabel"));		
		btnBrowse.setText(ApplicationSingleton.getInstance().getResourceBundle().getString("browseLabel")); 	
		lblChooseApplicationLanguage.setText(ApplicationSingleton.getInstance().getResourceBundle().getString("chooseLanguageLabel"));
		btnConfirm.setText(ApplicationSingleton.getInstance().getResourceBundle().getString("confirmOption")); 
		btnCancel.setText(ApplicationSingleton.getInstance().getResourceBundle().getString("cancelOption")); 
		lblPassword.setText(ApplicationSingleton.getInstance().getResourceBundle().getString("passwordLabel"));
	}
	
	public JTextField getTextFieldIPAddress() {
		return textFieldIPAddress;
	}

	public JTextField getTextFieldDBName() {
		return textFieldDBName;
	}

	public JTextField getTextFieldUsername() {
		return textFieldUsername;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public JRadioButton getRdbtnJson() {
		return rdbtnJson;
	}

	public JRadioButton getRdbtnDatabase() {
		return rdbtnDatabase;
	}

	public JTextField getTextFieldJSONFile() {
		return textFieldJSONFile;
	}
}