package UI.controllers;

import UI.core.RootController;
import UI.views.ViewLogIn;
import app.facades.LogInFacade;

/**
 * Class who is in charge of the LogInView.
 * All the "logic" part of the LogInView is here.
 * @author francois.beiger
 *
 */
public class LogInController extends RootController {
	private LogInFacade loginfacade;
	
	public LogInController(){
		loginfacade = new LogInFacade();
		this.render(new ViewLogIn(this));
	}
	
	/**
	 * Ask if the user is real or not.
	 * First call the same name method on the LogInFacade.
	 * Then create the new HomeView with the answer.
	 * @param username
	 * @param password
	 */
	public Object handleLogIn(String username, String password){
		//Todo appel à la façade puis mets à jour la vue

		
		Object answer;
		try {
			answer = ("Hi " + loginfacade.handleLogIn(username, password).getUserID() + " !");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			answer = e.getMessage();
		}	
		return answer;
	}
	
	public void goToSignUp(){
		this.goTo("signup");
	}
}
