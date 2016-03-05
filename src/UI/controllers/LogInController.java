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
<<<<<<< HEAD
	private Container contentPane;
	private LogInFacade loginfacade;
	
	public LogInController(Container contentPane){
		this.contentPane = contentPane;
	}
=======
	private SuperController superController;
>>>>>>> master
	
	public LogInController(SuperController superController){
		this.setSuperController(superController);
		new ViewLogIn(superController.getContentPane(), this);
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
<<<<<<< HEAD
		String answer;
		loginfacade = new LogInFacade();
=======
		Object answer;
>>>>>>> master
		try {
			answer = ("Hi " + loginfacade.handleLogIn(username, password).getUserID() + " !");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			answer = e;
		}	
		return answer;
	}

	public SuperController getSuperController() {
		return superController;
	}

	public void setSuperController(SuperController superController) {
		this.superController = superController;
	}
}
