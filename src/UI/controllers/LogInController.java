package UI.controllers;

import UI.core.RootController;
import UI.views.ViewLogIn;
import app.facades.LogInFacade;
import app.model.User;

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
	public void handleLogIn(String username, String password){
		//Todo appel à la façade puis mets à jour la vue
		User user;
		try {
			user = loginfacade.handleLogIn(username, password);
			setUser(user);
			this.goTo("home");
		} catch (Exception e) {
			
		}
	}
	
	public void goToSignUp(){
		this.goTo("signup");
	}
}
