package app.services;

import app.factory.SellerJDBCFactory;
import app.factory.UserFactoryJDBC;
import app.model.Admin;
import app.model.Customer;
import app.model.Seller;
import app.model.User;
import app.model.dao.SellerJDBC;
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
		
		if(password.isEmpty()){
			throw new Exception("Password empty !");
		}
		
		//Username treatment
		userID.trim();
		userID.toLowerCase();
		
		//First we get the User, if the user exists
		UserFactoryJDBC userFactoryJDBC = new UserFactoryJDBC();
		User myUser = userFactoryJDBC.createUserJDBC(userID);
		
		//We have to check if the userId is_set
		if(myUser.getUserID().isEmpty()){
			throw new Exception("Username doesn't exists !");
		}
		
		//Check passwords
		if(password.equals(myUser.getPassword())){
			String admin = "admin";
			String seller = "seller";
			String customer = "customer";
			
			//We have to check if the user is a Seller/Trader or Admin
			// TODO: factoryAdmin, factoryCustomer are useless
			if(myUser.getType().equals(customer)){
				Customer myCustomer = new Customer(myUser.getUserID(), myUser.getFirstName(), myUser.getLastName(), myUser.getPassword(), myUser.getEmail(), myUser.getTel(), myUser.getAdress());
				return myCustomer;
			}
			else if(myUser.getType().equals(admin)){
				Admin myAdmin = new Admin(myUser.getUserID(), myUser.getFirstName(), myUser.getLastName(), myUser.getPassword(), myUser.getEmail(), myUser.getTel(), myUser.getAdress());
				return myAdmin;
			}
			else if(myUser.getType().equals(seller)){
				SellerJDBCFactory sellerJDBCFactory = new SellerJDBCFactory();
				Seller mySeller = sellerJDBCFactory.createSellerJDBC(userID);
				return mySeller;
			}
		}
		else{
			throw new Exception("Wrong password !");
		}
		throw new Exception("Wrong log in");
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
		User myUser = userFactory.createUserJDBC(userID);
		if(myUser.getUserID() != null){
			throw new Exception("UserID already taken !");
		}
		else{
			UserJDBC anUser = userFactory.createUserJDBC();
			anUser.setUserID(userID);
			anUser.setFirstName(firstName);
			anUser.setLastName(lastName);
			anUser.setPassword(password);
			anUser.setEmail(email);
			anUser.setAdress(address);
			anUser.setTel(telephone);
			try{
				anUser.insertCustomer();
			}
			catch (Exception e){
				throw new Exception("Error with the insertion in the DB.");
			}
			
			Customer myCustomer = new Customer(anUser.getUserID(), anUser.getFirstName(), anUser.getLastName(), anUser.getPassword(), anUser.getEmail(), anUser.getTel(), anUser.getAdress());
			System.out.println(myCustomer.getUserID());
			return myCustomer;
		}
	}
	
	public Seller sigUpSeller(String firstName, String lastName, String userID, String email, String phoneNumber, String address, String password, String confirm, String siret, String webaddress) throws Exception{

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
		User myUser = userFactory.createUserJDBC(userID);
		if(myUser.getUserID() != null){
			throw new Exception("UserID already taken !");
		}
		else{
			SellerJDBCFactory sellerFactory = new SellerJDBCFactory(); 
			SellerJDBC aSeller = sellerFactory.createSellerJDBC();
			aSeller.setUserID(userID);
			aSeller.setFirstName(firstName);
			aSeller.setLastName(lastName);
			aSeller.setPassword(password);
			aSeller.setEmail(email);
			aSeller.setAdress(address);
			aSeller.setTel(phoneNumber);
			aSeller.setSiret(siret);
			aSeller.setWebAddress(webaddress);
			return aSeller;
		}
	}
}
