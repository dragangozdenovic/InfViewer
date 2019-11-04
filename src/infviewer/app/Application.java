package infviewer.app;

import java.awt.Font;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import infviewer.view.ApplicationLoadingDialog;

public class Application 
{
	public static void main(String[] args) 
	{
		try 
		{
			UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
		} 
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) { e.printStackTrace(); }
		
		UIManager.put("TableHeader.font", new Font("Comic Sans MS", Font.BOLD, 15));
		UIManager.put("Table.font", new Font("Comic Sans MS", Font.PLAIN, 14));
		
		SwingUtilities.invokeLater(new Runnable() 
		{	
			@Override
			public void run() 
			{
				try
				{
					ApplicationSingleton.getInstance().setProperties(initProperties());
				}
				catch (IOException e1) 
				{
					return;
				}
				
				ApplicationLoadingDialog applicationLoadingDialog = new ApplicationLoadingDialog();
				ApplicationSingleton.getInstance().setApplicationLoadingDialog(applicationLoadingDialog);
				applicationLoadingDialog.setVisible(true);
			}
		});
	}
	
	private static Properties initProperties() throws IOException
	{
		Properties properties = new Properties();
		InputStream inputStream = new FileInputStream("resources/config.properties");
		properties.load(inputStream);
		return properties;
	}
}