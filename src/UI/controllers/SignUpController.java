package UI.controllers;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

import UI.views.SignUpView;


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
		JComboBox cb = (JComboBox)e.getSource();
		String choice = (String)cb.getSelectedItem();
		if(choice=="Customer"){
			new SignUpView(rootController.getContentPane(), this);
		}
		else{
			new SignUpView(rootController.getContentPane(), this, choice);
		}
	}
}
