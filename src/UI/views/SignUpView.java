package UI.views;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import UI.controllers.SignUpController;

public class SignUpView {
	SignUpController signUpController;
	JTextField fieldFirstName;
	JTextField fieldLastName;
	JTextField fieldUserID;
	JPasswordField fieldPassword;
	JPasswordField fieldConfirm;
	JButton submit;	
	
	
	/**
	 * Constructor.
	 * Create all the JFrame components then adds them to the contentPane.
	 * @param contentPane
	 * @param signUpController
	 */
	public SignUpView(Container contentPane, SignUpController signUpController){
		this.signUpController = signUpController;
		
		JPanel totalPanel = new JPanel();
		
		JPanel globalContent = new JPanel(new GridLayout(0,2,0,0));
		JPanel labelPanel = new JPanel(new GridLayout(5,0,0,1));
		JPanel fieldPanel = new JPanel(new GridLayout(5,0,0,1));
		
		JLabel firstName = new JLabel("First Name");
		JLabel lastName = new JLabel("Last Name");
		JLabel userID = new JLabel("Username");
		JLabel password = new JLabel("Password");
		JLabel confirmPassword = new JLabel("Confirm your password");
		
		this.setFieldFirstName(new JTextField(10));
		this.setFieldLastName(new JTextField(10));
		this.setFieldUserID(new JTextField(10));
		this.setFieldPassword(new JPasswordField(10));
		this.setFieldConfirm(new JPasswordField(10));
		
		labelPanel.add(firstName);
		labelPanel.add(lastName);
		labelPanel.add(userID);
		labelPanel.add(password);
		labelPanel.add(confirmPassword);

		fieldPanel.add(getFieldFirstName());
		fieldPanel.add(getFieldLastName());
		fieldPanel.add(getFieldUserID());
		fieldPanel.add(getFieldPassword());
		fieldPanel.add(getFieldConfirm());
		
		globalContent.add(labelPanel);
		globalContent.add(fieldPanel);
		
		this.setSubmit(new JButton("Submit"));
		this.getSubmit().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				submitAction();
			}
		});
		
		totalPanel.add(globalContent, BorderLayout.CENTER);
		totalPanel.add(this.getSubmit(), BorderLayout.SOUTH);
		
		contentPane.add(totalPanel, BorderLayout.CENTER);
		
	}

	private void submitAction(){
		System.out.println(this.getFieldUserID().getText());
	}

	public SignUpController getSignUpController() {
		return signUpController;
	}


	public void setSignUpController(SignUpController signUpController) {
		this.signUpController = signUpController;
	}


	public JTextField getFieldFirstName() {
		return fieldFirstName;
	}


	public void setFieldFirstName(JTextField fieldFirstName) {
		this.fieldFirstName = fieldFirstName;
	}


	public JTextField getFieldLastName() {
		return fieldLastName;
	}


	public void setFieldLastName(JTextField fieldLastName) {
		this.fieldLastName = fieldLastName;
	}


	public JTextField getFieldUserID() {
		return fieldUserID;
	}


	public void setFieldUserID(JTextField fieldUserID) {
		this.fieldUserID = fieldUserID;
	}


	public JPasswordField getFieldPassword() {
		return fieldPassword;
	}


	public void setFieldPassword(JPasswordField fieldPassword) {
		this.fieldPassword = fieldPassword;
	}


	public JPasswordField getFieldConfirm() {
		return fieldConfirm;
	}


	public void setFieldConfirm(JPasswordField fieldConfirm) {
		this.fieldConfirm = fieldConfirm;
	}


	public JButton getSubmit() {
		return submit;
	}


	public void setSubmit(JButton submit) {
		this.submit = submit;
	}
	
	
}
