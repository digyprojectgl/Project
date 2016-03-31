package UI.views;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import UI.controllers.SignUpController;
import UI.core.ViewInterface;

public class SignUpView implements ViewInterface {
	SignUpController signUpController;
	JTextField fieldFirstName = new JTextField(15);
	JTextField fieldLastName = new JTextField(15);
	JTextField fieldUserID = new JTextField(15);

	JTextField email = new JTextField(15);
	JTextField address = new JTextField(15);
	JTextField phoneNumber= new JTextField(10);

	JTextField webAddress = new JTextField(15);
	JTextField siret = new JTextField(15);
	
	JPasswordField fieldPassword = new JPasswordField(10);
	JPasswordField fieldConfirm = new JPasswordField(10);
	JButton submit = new JButton("Submit");	
	JButton alreadySignUp = new JButton("Already sign up ?");
	
	String[] types = {"Customer", "Seller"};
	JComboBox typeBox = new JComboBox(types);
	
	String type;
	
	/**
	 * Constructor for the Customer.
	 * Create all the JFrame components then adds them to the contentPane.
	 * @param signUpController, type
	 */
	public SignUpView(SignUpController signUpController, String type) {
		this.signUpController = signUpController;
		this.type = type;
	}
	
	public void render(Container contentPane) {
		switch(this.type) {
			case "customer":
				this.renderCustomer(contentPane);
				break;
			case "seller":
				this.renderSeller(contentPane);
				break;
		}
	}
	
	public void renderCustomer(Container contentPane) {
		JPanel all = new JPanel();
		JPanel totalPanel = new JPanel(new GridLayout(2,0));
		
		JPanel globalField = new JPanel(new GridLayout(0,2,0,0));
		
		JPanel labelPanel = new JPanel(new GridLayout(8,0,0,1));
		JPanel fieldPanel = new JPanel(new GridLayout(8,0,0,1));
		
		JPanel buttonPanel = new JPanel();
		
		JLabel userType = new JLabel("Sign up as");
		JPanel userTypePanel = new JPanel();
		
		getTypeBox().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				userChoice(e);
			}
			
		});
		userTypePanel.add(userType);
		userTypePanel.add(typeBox);
		
		JLabel firstName = new JLabel("First Name*");
		JLabel lastName = new JLabel("Last Name*");
		JLabel userID = new JLabel("Username*");
		JLabel password = new JLabel("Password*");
		JLabel confirmPassword = new JLabel("Confirm your password*");
		JLabel emailLab = new JLabel("Email*");
		JLabel phoneNumberLab = new JLabel("Phone number");
		JLabel addressLab = new JLabel("Address");
		
		labelPanel.add(firstName);
		labelPanel.add(lastName);
		labelPanel.add(userID);
		labelPanel.add(emailLab);
		labelPanel.add(phoneNumberLab);
		labelPanel.add(addressLab);
		labelPanel.add(password);
		labelPanel.add(confirmPassword);
		

		fieldPanel.add(getFieldFirstName());
		fieldPanel.add(getFieldLastName());
		fieldPanel.add(getFieldUserID());
		fieldPanel.add(getEmail());
		fieldPanel.add(getPhoneNumber());
		fieldPanel.add(getAddress());
		fieldPanel.add(getFieldPassword());
		fieldPanel.add(getFieldConfirm());
		
		globalField.add(labelPanel);
		globalField.add(fieldPanel);
		
		this.getAlreadySignUp().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				goToLogIn();
			}
		});
		buttonPanel.add(getAlreadySignUp());
	
		
		this.getSubmit().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				signUpCustomer();
			}
		});
		buttonPanel.add(this.getSubmit());
		
		totalPanel.add(globalField);
		totalPanel.add(buttonPanel);
		all.add(totalPanel);
	
		contentPane.add(userTypePanel, BorderLayout.NORTH);
		contentPane.add(all, BorderLayout.CENTER);
	}
		
	
	
	/**
	 * Constructor for the Seller
	 * @param contentPane
	 */
	public void renderSeller(Container contentPane) {	
		JPanel all = new JPanel();
		JPanel totalPanel = new JPanel(new GridLayout(2,0));
		
		JPanel globalField = new JPanel(new GridLayout(0,2,0,0));
		
		JPanel labelPanel = new JPanel(new GridLayout(10,0,0,1));
		JPanel fieldPanel = new JPanel(new GridLayout(10,0,0,1));
		
		JPanel buttonPanel = new JPanel();
		
		JLabel userTypeLab = new JLabel("Sign up as");
		JPanel userTypePanel = new JPanel();
		this.getTypeBox().setSelectedIndex(1);
		getTypeBox().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				userChoice(e);
			}
			
		});
		userTypePanel.add(userTypeLab);
		userTypePanel.add(typeBox);
		
		JLabel firstName = new JLabel("First Name*");
		JLabel lastName = new JLabel("Last Name*");
		JLabel userID = new JLabel("Username*");
		JLabel password = new JLabel("Password*");
		JLabel confirmPassword = new JLabel("Confirm your password*");
		JLabel emailLab = new JLabel("Email*");
		JLabel phoneNumberLab = new JLabel("Phone number");
		JLabel addressLab = new JLabel("Address");
		JLabel siretLab = new JLabel("SIRET");
		JLabel webAddressLab = new JLabel("Web address");
		
		labelPanel.add(firstName);
		labelPanel.add(lastName);
		labelPanel.add(userID);
		labelPanel.add(emailLab);
		labelPanel.add(phoneNumberLab);
		labelPanel.add(addressLab);
		labelPanel.add(siretLab);
		labelPanel.add(webAddressLab);
		labelPanel.add(password);
		labelPanel.add(confirmPassword);
		

		fieldPanel.add(getFieldFirstName());
		fieldPanel.add(getFieldLastName());
		fieldPanel.add(getFieldUserID());
		fieldPanel.add(getEmail());
		fieldPanel.add(getPhoneNumber());
		fieldPanel.add(getAddress());
		fieldPanel.add(getSiret());
		fieldPanel.add(getWebAddress());
		fieldPanel.add(getFieldPassword());
		fieldPanel.add(getFieldConfirm());
		
		globalField.add(labelPanel);
		globalField.add(fieldPanel);
		
		this.getAlreadySignUp().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				goToLogIn();
			}
		});
		buttonPanel.add(getAlreadySignUp());
	
		
		this.getSubmit().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				signUpSeller();
			}
		});
		buttonPanel.add(this.getSubmit());
		
		totalPanel.add(globalField);
		totalPanel.add(buttonPanel);
		all.add(totalPanel);
	
		contentPane.add(userTypePanel, BorderLayout.NORTH);
		contentPane.add(all, BorderLayout.CENTER);
	}

	
	/*
	 * GETTERS AND SETTERS
	 */
	
	public JTextField getWebAddress() {
		return webAddress;
	}


	public void setWebAddress(JTextField webAddress) {
		this.webAddress = webAddress;
	}


	public JTextField getSiret() {
		return siret;
	}


	public void setSiret(JTextField siret) {
		this.siret = siret;
	}


	public String[] getTypes() {
		return types;
	}


	public void setTypes(String[] type) {
		this.types = types;
	}


	public JComboBox getTypeBox() {
		return typeBox;
	}

	public void setTypeBox(JComboBox typeBox) {
		this.typeBox = typeBox;
	}

	public JTextField getEmail() {
		return email;
	}

	public void setEmail(JTextField email) {
		this.email = email;
	}

	public JTextField getAddress() {
		return address;
	}

	public void setAddress(JTextField address) {
		this.address = address;
	}

	public JTextField getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(JTextField phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	
	
	
	/*
	 *	METHODS 
	 */
	
	private void signUpCustomer(){
		String firstName = this.getFieldFirstName().getText();
		String lastName = this.getFieldLastName().getText();
		String userID = this.getFieldUserID().getText();
		String email = this.getEmail().getText();
		String phoneNumber = this.getPhoneNumber().getText();
		String address = this.getAddress().getText();
		String password = String.valueOf(this.getFieldPassword().getPassword());
		String confirm = String.valueOf(this.getFieldConfirm().getPassword());
		this.getSignUpController().signUpCustomer(firstName, lastName, userID, email, phoneNumber, address, password, confirm);
	}

	private void signUpSeller(){
		String firstName = this.getFieldFirstName().getText();
		String lastName = this.getFieldLastName().getText();
		String userID = this.getFieldUserID().getText();
		String email = this.getEmail().getText();
		String phoneNumber = this.getPhoneNumber().getText();
		String address = this.getAddress().getText();
		String password = String.valueOf(this.getFieldPassword().getPassword());
		String confirm = String.valueOf(this.getFieldConfirm().getPassword());
		String siret = this.getSiret().getText();
		String webaddress = this.getWebAddress().getText();
		this.getSignUpController().signUpSeller(firstName, lastName, userID, email, phoneNumber, address, password, confirm, siret, webaddress);
	}
	
	private void goToLogIn(){
		getSignUpController().goToLogIn();
	}
	
	private void userChoice(ActionEvent e){
		this.getSignUpController().userChoice(e);
	}
	
	public void displayError(String exception){
		JOptionPane.showMessageDialog(null, exception, "Your registration hasn't been performed.", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public String getLayout() {
		return "login";
	}
	
}
