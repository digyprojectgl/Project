package UI.controllers;

import UI.views.ViewLogIn;
import app.facades.LogInFacade;

/**
 * Class who is in charge of the LogInView.
 * All the "logic" part of the LogInView is here.
 * @author francois.beiger
 *
 */
public class LogInController {
	private LogInFacade loginfacade;
	private RootController rootController;

	
	public LogInController(RootController rootController){
		this.setRootController(rootController);
		new ViewLogIn(rootController.getContentPane(), this);
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

		loginfacade = new LogInFacade();
		Object answer;
		try {
			answer = ("Hi " + loginfacade.handleLogIn(username, password).getUserID() + " !");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			answer = e;
		}	
		return answer;
	}

	public RootController getRootController() {
		return rootController;
	}

	public void setRootController(RootController rootController) {
		this.rootController = rootController;
	}
	
	public void goToSignUp(){
		this.getRootController().goToSignUp();
	}
}
