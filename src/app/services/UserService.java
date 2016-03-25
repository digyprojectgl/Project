package app.services;
import app.factory.CustomerFactory;
import app.factory.CustomerJDBCFactory;
import app.factory.UserFactoryJDBC;
import app.model.Customer;
import app.model.User;
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
		
		//Username treatment
		userID.trim();
		userID.toLowerCase();
		
		//We have to check if the user is a Seller/Trader or Admin
		CustomerJDBCFactory customerJDBCFactory = new CustomerJDBCFactory();
		Customer customerJDBC = customerJDBCFactory.createCustomerJDBC(userID);
		
		//case customer
		if(customerJDBC.getUserID() == userID){
			CustomerFactory customerFactory = new CustomerFactory();
			Customer myCustomer = customerFactory.createCustomer();
			myCustomer.setUserID(userID);
			
			
		}
		
		UserFactoryJDBC factory = new UserFactoryJDBC();
		//Get the user, throws an error if the user isn't into the DB. 
		User myUser = factory.createUser(userID);

		if(password.isEmpty()){
			throw new Exception("Password empty !");
		}
		
		if(!password.equals(myUser.getPassword())){
			throw new Exception("Wrong password !");
		}
		
		
		
		return myUser;
	}
	
	/**
	 * Method called when the customer wants to sign up.
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
		
		UserFactoryJDBC userFactory = new UserFactoryJDBC();
		
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
