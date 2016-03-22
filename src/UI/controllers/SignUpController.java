package UI.controllers;
import java.awt.event.ActionEvent;
import java.util.Objects;
import javax.swing.JComboBox;

import UI.views.SignUpView;
import app.facades.SignUpFacade;
import app.model.*;


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
	
	public Object signUpCustomer(String firstName, String lastName, String userID, String email, String phoneNumber, String address, String password, String confirm){
		SignUpFacade facade = new SignUpFacade();
		try{
			User myUser = facade.signUpCustomer(firstName, lastName, userID, email, phoneNumber, address, password, confirm);
			return myUser;
		}
		catch(Exception e){
			return e.getMessage();
		}
	}
}
