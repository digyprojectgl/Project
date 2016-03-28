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
	SignUpFacade facade = new SignUpFacade();
	
	public SignUpController(){
		this.render(new SignUpView(this, "customer"));
	}
	
	public void goToLogIn(){
		this.goTo("login");
	}
	
	public void userChoice(ActionEvent e){
		JComboBox cb = (JComboBox)e.getSource();
		String choice = (String)cb.getSelectedItem();
		if(Objects.equals(choice, "Customer")){
			this.render(new SignUpView(this, "customer"));
		}
		else{
			this.render(new SignUpView(this, "seller"));
		}
	}
	
	public void signUpCustomer(String firstName, String lastName, String userID, String email, String phoneNumber, String address, String password, String confirm){
	
		try{
			Customer myCustomer = this.facade.signUpCustomer(firstName, lastName, userID, email, phoneNumber, address, password, confirm);
			setUser(myCustomer);
			this.goTo("home");
		}
		catch(Exception e){
			SignUpView myView = new SignUpView(this, "customer");
			this.render(myView);
			myView.displayError(e.getMessage());
		}
	}
	
	public void signUpSeller(String firstName, String lastName, String userID, String email, String phoneNumber, String address, String password, String confirm, String siret, String webaddress){
		try{
			Seller mySeller = this.facade.signUpSeller(firstName, lastName, userID, email, phoneNumber, address, password, confirm, siret, webaddress);
			setUser(mySeller);
			this.goTo("home");
		}
		catch(Exception e){
			SignUpView myView = new SignUpView(this, "seller");
			this.render(myView);
			myView.displayError(e.getMessage());
		}
	}
}
