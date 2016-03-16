package UI.controllers;
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
}
