package app.facades;

import app.model.User;
import app.services.UserService;

public class LogInFacade {
	
	public static String handleLogIn(String username, String password){
		User answer = UserService.handleLogIn(username, password);
		return answer.name;
	}
}
