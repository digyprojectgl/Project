package app.services;
import app.model.Customer;
import app.model.User;
import app.model.dao.CustomerFactory;
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
		
		if(userID.isEmpty()){
			throw new Exception("Username empty !");
		}
		userID.trim();
		userID.toLowerCase();
		UserFactory factory = new UserFactory();
		User myUser = factory.createUser(userID);

		if(password.isEmpty()){
			throw new Exception("Password empty !");
		}
		
		if(password.equals(myUser.getPassword())){
			return myUser;
		}
		else{
			throw new Exception("Wrong password !");
		}
	}
	
	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param userID
	 * @param email
	 * @param telephone
	 * @param address
	 * @param password
	 * @param confirm
	 * @return
	 * @throws Exception
	 */
	public Customer signUpCustomer(String firstName, String lastName, String userID, String email, String telephone, String address, String password, String confirm) throws Exception{

		if(userID.isEmpty()){
			throw new Exception("Username is a required field !");
		}
		
		userID.trim();
		userID.toLowerCase();
		
		
		if(password.isEmpty()){
			throw new Exception("Password empty !");
		}
		if(!password.equals(confirm)){
			throw new Exception("Passwords are not equals !");
		}
		
		if(firstName.isEmpty()){
			throw new Exception("First name is a required field !");
		}
		
		if(lastName.isEmpty()){
			throw new Exception("Last name is a required field !");
		}
		
		if(email.isEmpty()){
			throw new Exception("E-mail is a required field !");
		}
		
		UserFactory userFactory = new UserFactory();
		
		//Get the user in the DB
		User myUser = userFactory.createUser(userID);
		if(myUser.getUserID() != null){
			throw new Exception("UserID already taken !");
		}
		else{
			CustomerFactory customerFactory = new CustomerFactory();
			return customerFactory.createCustomer(userID, firstName, lastName, password, email, telephone, address);
		}
		
	}
}
