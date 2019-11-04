package infviewer.workspace.controller;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import infviewer.workspace.view.DialogElement;

public class DocumentChangedAction implements DocumentListener, FocusListener
{
	private Border validBorder;
	private Border invalidBorder = BorderFactory.createLineBorder(Color.RED, 2);
	private JTextField textField;
	private int exactLength;
	private DialogElement dialogElement;
	
	public DocumentChangedAction(JTextField textField, int minLength, DialogElement dialogElement)
	{
		this.textField = textField;
		this.exactLength = minLength;
		this.dialogElement = dialogElement;
		validBorder = textField.getBorder();
		
		this.textField.addFocusListener(this);
	}
	
	@Override
	public void changedUpdate(DocumentEvent arg0) {
		validate(arg0.getDocument().getLength());
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		validate(arg0.getDocument().getLength());
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		validate(arg0.getDocument().getLength());
	}
	
	public void validate(int length)
	{
		if (length == 0 || this.exactLength > length)
		{
			this.textField.setBorder(invalidBorder);
			this.dialogElement.setValid(false);
		}
		else
		{
			this.textField.setBorder(validBorder);
			this.dialogElement.setValid(true);
		}
	}

	@Override
	public void focusGained(FocusEvent arg0) { }

	@Override
	public void focusLost(FocusEvent arg0) {
		validate(this.textField.getText().length());
	}
}