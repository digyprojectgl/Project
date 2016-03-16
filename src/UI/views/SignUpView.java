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
	JButton alreadySignUp;
	
	
	/**
	 * Constructor.
	 * Create all the JFrame components then adds them to the contentPane.
	 * @param contentPane
	 * @param signUpController
	 */
	public SignUpView(Container contentPane, SignUpController signUpController){
		this.signUpController = signUpController;
		
		JPanel all = new JPanel();
		JPanel totalPanel = new JPanel(new GridLayout(2,0));
		
		JPanel globalField = new JPanel(new GridLayout(0,2,0,0));
		
		JPanel labelPanel = new JPanel(new GridLayout(5,0,0,1));
		JPanel fieldPanel = new JPanel(new GridLayout(5,0,0,1));
		
		JPanel buttonPanel = new JPanel();
		
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
		
		globalField.add(labelPanel);
		globalField.add(fieldPanel);
		
		this.setAlreadySignUp(new JButton("Already sign up ?"));
		this.getAlreadySignUp().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				goToLogIn();
			}
		});
		
		buttonPanel.add(getAlreadySignUp());
	
		this.setSubmit(new JButton("Submit"));
		this.getSubmit().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				signUp();
			}
		});
		
		buttonPanel.add(this.getSubmit());
		
		totalPanel.add(globalField);
		totalPanel.add(buttonPanel);
		all.add(totalPanel);
	
		contentPane.add(all, BorderLayout.CENTER);
	}

	public JButton getAlreadySignUp() {
		return alreadySignUp;
	}

	public void setAlreadySignUp(JButton alreadySignUp) {
		this.alreadySignUp = alreadySignUp;
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
	
	private void signUp(){
		System.out.println(this.getFieldUserID().getText());
	}

	private void goToLogIn(){
		getSignUpController().goToLogIn();
	}
	
}
