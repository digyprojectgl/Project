package UI.views;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import UI.controllers.*;
import UI.core.ViewInterface;
import app.model.Seller;
import app.model.User;

public class EditProfileView implements ViewInterface{
	EditProfileController editProfileController;
	User myUser;
	
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
	
	public EditProfileView(EditProfileController editProfileController){
		myUser = this.editProfileController.getUser();
		this.setEditProfileController(editProfileController);
		this.viewDidLoad();
	}
	
	@Override
	public String getLayout() {
		// TODO Auto-generated method stub
		return "main";
	}

	@Override
	public void render(Container contentPane) {
		// TODO Auto-generated method stub
		if(myUser instanceof Seller){
			this.renderSeller(contentPane);
		}
		else{
			this.renderCustomer(contentPane);
		}
	}
	
	public void renderCustomer(Container contentPane){
		JPanel all = new JPanel();
		JPanel totalPanel = new JPanel(new GridLayout(2,0));
		
		JPanel globalField = new JPanel(new GridLayout(0,2,0,0));
		
		JPanel labelPanel = new JPanel(new GridLayout(8,0,0,1));
		JPanel fieldPanel = new JPanel(new GridLayout(8,0,0,1));
		
		JPanel buttonPanel = new JPanel();
		
		
		JLabel firstName = new JLabel("First Name");
		JLabel lastName = new JLabel("Last Name");
		JLabel userID = new JLabel("Username");
		JLabel password = new JLabel("Password");
		JLabel confirmPassword = new JLabel("Confirm your password");
		JLabel emailLab = new JLabel("Email");
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
		
		
		this.getSubmit().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				updateUser();
			}
		});
		buttonPanel.add(this.getSubmit());
		
		totalPanel.add(globalField);
		totalPanel.add(buttonPanel);
		all.add(totalPanel);
	
		contentPane.add(all, BorderLayout.CENTER);
	}
	
	public void renderSeller(Container contentPane){
		JPanel all = new JPanel();
		JPanel totalPanel = new JPanel(new GridLayout(2,0));
		
		JPanel globalField = new JPanel(new GridLayout(0,2,0,0));
		
		JPanel labelPanel = new JPanel(new GridLayout(10,0,0,1));
		JPanel fieldPanel = new JPanel(new GridLayout(10,0,0,1));
		
		JPanel buttonPanel = new JPanel();
		
		
		JLabel firstName = new JLabel("First Name");
		JLabel lastName = new JLabel("Last Name");
		JLabel userID = new JLabel("Username");
		JLabel password = new JLabel("Password");
		JLabel confirmPassword = new JLabel("Confirm your password");
		JLabel emailLab = new JLabel("Email");
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
		
	
		
		this.getSubmit().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				updateUser();
			}
		});
		buttonPanel.add(this.getSubmit());
		
		totalPanel.add(globalField);
		totalPanel.add(buttonPanel);
		all.add(totalPanel);
	
		contentPane.add(all, BorderLayout.CENTER);
	}
	
	/**
	 * Function called once, for loading datas into the TExtFields.
	 */
	private void viewDidLoad(){
		//Disable the TextField
		this.getFieldUserID().setEditable(false);
		this.getFieldFirstName().setText(this.getMyUser().getFirstName());
		this.getFieldLastName().setText(this.getMyUser().getLastName());
		this.getFieldUserID().setText(this.getMyUser().getUserID());
		this.getAddress().setText(this.getMyUser().getAdress());
		this.getEmail().setText(this.getMyUser().getEmail());
		this.getPhoneNumber().setText(this.getMyUser().getTel());
		if(this.getMyUser() instanceof Seller){
			this.getSiret().setText(((Seller)this.getMyUser()).getSiret());
			this.getWebAddress().setText(((Seller)this.getMyUser()).getWebAddress());
		}
	}

	/**
	 * Function called for updating the Admin/Customer.
	 */
	private void updateUser(){
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
		this.getEditProfileController().updateUser(getMyUser(), firstName, lastName, userID, email, phoneNumber, address, password, confirm, siret, webaddress);
	}
	
	public void displayError(String e){
		JOptionPane.showMessageDialog(null, e, "Changes haven't been performed.", JOptionPane.ERROR_MESSAGE);
	}
	
	public void displayMessage(String m){
		JOptionPane.showMessageDialog(null, m, "Your changes have been made !", JOptionPane.INFORMATION_MESSAGE);
	}
	

	public EditProfileController getEditProfileController() {
		return editProfileController;
	}

	public void setEditProfileController(EditProfileController editProfileController) {
		this.editProfileController = editProfileController;
	}

	public User getMyUser() {
		return myUser;
	}

	public void setMyUser(User myUser) {
		this.myUser = myUser;
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
