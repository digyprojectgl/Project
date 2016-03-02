package app.facades;

import app.model.User;
import app.services.UserService;

public class LogInFacade {
	
	public static String handleLogIn(String userID, String password) throws Exception{
		User answer = UserService.handleLogIn(userID, password);
		return answer.getUserID();
	}
}
