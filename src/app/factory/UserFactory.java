package app.factory;

import app.model.User;
import app.model.dao.UserJDBC;

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
	
	public User createUser(String firstName, String lastName, String userID, String email, String phoneNumber, String address, String password) throws Exception{
		new UserJDBC(firstName, lastName, userID, email, phoneNumber, address, password);
		return  new UserJDBC(userID);
	}
}
