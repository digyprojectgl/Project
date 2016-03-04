package app.facades;

import app.model.User;
import app.services.UserService;
/**
 * Simply delegates all methods from the LogInController to the UserService class.
 * @author francois.beiger
 *
 */
public class LogInFacade {
	
	private UserService userservice;
	
	public User handleLogIn(String userID, String password) throws Exception{
		userservice = new UserService();
		return userservice.handleLogIn(userID, password);
	}
}
