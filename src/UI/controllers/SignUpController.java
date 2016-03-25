package UI.controllers;
import java.awt.event.ActionEvent;
import java.util.Objects;
import javax.swing.JComboBox;

import UI.core.RootController;
import UI.views.SignUpView;
import app.facades.SignUpFacade;
import app.model.*;


/**
 * Controller who is in charge of SignUpView.
 * @author francois
 *
 */
public class SignUpController extends RootController {
	public SignUpController(){
		this.render(new SignUpView(this, "customer"));
	}
	
	public void goToLogIn(){
		this.goTo("login");
	}
	
	public void userChoice(ActionEvent e){
		JComboBox cb = (JComboBox)e.getSource();
		String choice = (String)cb.getSelectedItem();
		System.out.println(choice);
		if(Objects.equals(choice, "Customer")){
			System.out.println(4);
			this.render(new SignUpView(this, "customer"));
		}
		else{
			this.render(new SignUpView(this, "seller"));
		}
	}
	
	public void signUpCustomer(String firstName, String lastName, String userID, String email, String phoneNumber, String address, String password, String confirm){
		SignUpFacade facade = new SignUpFacade();
		try{
			User myUser = facade.signUpCustomer(firstName, lastName, userID, email, phoneNumber, address, password, confirm);
			this.goTo("home");
		}
		catch(Exception e){
			SignUpView myView = new SignUpView(this, "customer");
			myView.displayError(e.getMessage());
		}
	}
}
