package UI.controllers;
import java.awt.Container;

import UI.MainView;
import UI.views.HomeView;
import UI.views.ViewLogIn;
import app.facades.LogInFacade;

public class LogInController {
	private Container contentPane;
	
	public LogInController(Container contentPane){
		this.contentPane = contentPane;
	}
	
	public void displayViewLogIn(){
		new ViewLogIn(contentPane);
	}
	
	
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
