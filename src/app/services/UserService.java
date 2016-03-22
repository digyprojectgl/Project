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
		userID.trim();
		userID.toLowerCase();
		UserFactory factory = new UserFactory();
		User myUser = factory.createUser(userID);

		if(password.equals(myUser.getPassword())){
			return myUser;
		}
		else{
			throw new Exception("Wrong password !");
		}
	}
	
	public User signUpCustomer(String firstName, String lastName, String userID, String email, String phoneNumber, String address, String password, String confirm) throws Exception{
		userID.trim();
		userID.toLowerCase();
		UserFactory factory = new UserFactory();
		
		User myUser = factory.createUser(userID);
		if(myUser.getUserID() != null){
			throw new Exception("UserID already taken !");
		}
		else{
			factory.createUser(firstName, lastName, userID, email, phoneNumber, address, password);
			return factory.createUser(userID);
		}
	}
}
