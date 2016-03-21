package UI.controllers;
import java.awt.event.ActionEvent;
import java.util.Objects;
import javax.swing.JComboBox;

import UI.views.SignUpView;
import app.model.User;


/**
 * Controller who is in charge of SignUpView.
 * @author francois
 *
 */
public class SignUpController {
	RootController rootController;
	
	public SignUpController(RootController rootController){
		this.rootController = rootController;
		new SignUpView(rootController.getContentPane(), this);
	}
	
	public void goToLogIn(){
		this.rootController.goToLogIn();
	}
	
	public void userChoice(ActionEvent e){
		this.rootController.eraseContainer();
		JComboBox cb = (JComboBox)e.getSource();
		String choice = (String)cb.getSelectedItem();
		if(Objects.equals(choice, "Customer")){
			new SignUpView(rootController.getContentPane(), this);
		}
		else{
			new SignUpView(rootController.getContentPane(), this, choice);
		}
		this.rootController.displayContentPane();
	}
	
	public User signUpCustomer(String firstName, String lastName, String userID, String email, String phoneNumber, String address, String password, String confirm){
		return null;
	}
}
