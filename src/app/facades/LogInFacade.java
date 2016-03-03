package app.facades;

import app.model.User;
import app.services.UserService;
/**
 * Simply delegates all methods from the LogInController to the UserService class.
 * @author francois.beiger
 *
 */
public class LogInFacade {
	
	public static String handleLogIn(String userID, String password) throws Exception{
		User answer = UserService.handleLogIn(userID, password);
		return answer.getUserID();
	}
}
