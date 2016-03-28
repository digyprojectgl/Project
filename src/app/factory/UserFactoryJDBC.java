package app.factory;

import app.model.User;
import app.model.dao.UserJDBC;

/**
 * Factory in charge of the User.
 * @author francois.beiger
 *
 */
public class UserFactoryJDBC {

	public UserFactoryJDBC(){
		
	}
	
	public UserJDBC createUserJDBC(){
		return new UserJDBC();
	}
	
	public UserJDBC createUserJDBC(String userID) throws Exception{
		return new UserJDBC(userID);
	}
}
