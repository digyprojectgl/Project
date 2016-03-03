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
	
	public User createUser(){
		return new UserJDBC();
	}
	
}
