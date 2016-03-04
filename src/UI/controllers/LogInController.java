package UI.controllers;
import java.awt.Container;

import UI.views.HomeView;
import UI.views.ViewLogIn;
import app.facades.LogInFacade;

/**
 * Class who is in charge of the LogInView.
 * All the "logic" part of the LogInView is here.
 * @author francois.beiger
 *
 */
public class LogInController {
	private Container contentPane;
	
	public LogInController(Container contentPane){
		this.contentPane = contentPane;
	}
	
	/**
	 * Method which creates the viewLogIn.
	 */
	public void displayViewLogIn(){
		new ViewLogIn(contentPane);
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
		String answer;
		try {
			answer = ("Hi " + LogInFacade.handleLogIn(username, password) + " !");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			answer = e.toString();
		}
		new HomeView(contentPane, answer);
		
	}
}
