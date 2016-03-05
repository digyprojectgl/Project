package app.services;
import app.model.User;
import app.model.dao.UserFactory;
import app.model.dao.UserJDBC;

/**
 * Class who is in charge of Manage the User.
 * @author francois.beiger
 *
 */
public class UserService {
	/**
	 * Static method.
	 * Create the UserFactory. Ask it to create a new User.
	 * Treat the userID (trim(), toLowerCase()).
	 * Ask the UserJDBC to find a user by his userID.
	 * Compare both user's passwords.
	 * Throw an Exception if the password is not the good one.
	 * @param userID
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public User handleLogIn(String userID, String password) throws Exception{
		UserFactory factory = new UserFactory();
<<<<<<< HEAD
		User myUser = factory.createUser(userID);

		if(password.equals(myUser.getPassword())){
			return myUser;
=======
		User myUser = factory.createUser();
		
		userID.trim();
		userID.toLowerCase();
		myUser.setUserID(userID);
		myUser.setPassword(password);
		
		User userFind = UserJDBC.findUser(myUser.getUserID());
		if(userFind.getPassword().equals(myUser.getPassword())){
			return userFind;
>>>>>>> master
		}
		else{
			throw new Exception("Wrong password !");
		}
		
	}
}
