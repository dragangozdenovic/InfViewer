package infviewer.app;


import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import infviewer.controller.AbstractFactory;
import infviewer.tree.model.Package;
import infviewer.view.ApplicationLoadingDialog;
import infviewer.view.ApplicationMainFrame;
import infviewer.workspace.view.TabbedView;

public class ApplicationSingleton 
{
	private static ApplicationSingleton instance = new ApplicationSingleton();	
	private ApplicationMainFrame ApplicationMainFrame;
	private AbstractFactory jsonFactory;
	private AbstractFactory factory;
	private Package mainPackage;
	private TabbedView parentView;
	private ApplicationLoadingDialog applicationLoadingDialog;
	private Properties properties;
	private ResourceBundle resourceBundle;
    
	private ApplicationSingleton() {
		Locale.setDefault(new Locale("sr","RS"));
		this.changeLanguage();
	}
	
	public void changeLanguage() {
		resourceBundle = ResourceBundle.getBundle("infviewer.languages.MessageResources", Locale.getDefault());
	}

	public static ApplicationSingleton getInstance() {
		return instance;
	}

	public ApplicationMainFrame getApplicationMainFrame() {
		return ApplicationMainFrame;
	}

	public void setApplicationMainFrame(ApplicationMainFrame ApplicationMainFrame) {
		this.ApplicationMainFrame = ApplicationMainFrame;
	}

	public AbstractFactory getJsonFactory() {
		return jsonFactory;
	}

	public void setJsonFactory(AbstractFactory jsonFactory) {
		this.jsonFactory = jsonFactory;
	}

	public Package getMainPackage() {
		return mainPackage;
	}

	public void setMainPackage(Package mainPackage) {
		this.mainPackage = mainPackage;
	}

	public TabbedView getParentView() {
		return parentView;
	}

	public void setParentView(TabbedView workspaceView) {
		this.parentView = workspaceView;
	}

	public AbstractFactory getFactory() {
		return factory;
	}

	public void setFactory(AbstractFactory factory) {
		this.factory = factory;
	}

	public ApplicationLoadingDialog getApplicationLoadingDialog() {
		return applicationLoadingDialog;
	}

	public void setApplicationLoadingDialog(ApplicationLoadingDialog applicationLoadingDialog) {
		this.applicationLoadingDialog = applicationLoadingDialog;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}

	public void setResourceBundle(ResourceBundle resourceBundle) {
		this.resourceBundle = resourceBundle;
	}
}