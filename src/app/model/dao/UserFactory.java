package app.model.dao;

import app.model.User;

/**
 * Factory in charge of the User.
 * @author francois.beiger
 *
 */
public class UserFactory {

	public UserFactory(){
		
	}
	
	public User createUser(String userID) throws Exception{
		return new UserJDBC(userID);
	}
	
}
