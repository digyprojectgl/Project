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
	private UserFactoryJDBC userFactoryJDBC = new UserFactoryJDBC();
	private SellerJDBCFactory sellerFactory = new SellerJDBCFactory();
	
	public UserFactoryJDBC getUserFactoryJDBC() {
		return userFactoryJDBC;
	}

	public void setUserFactoryJDBC(UserFactoryJDBC userFactoryJDBC) {
		this.userFactoryJDBC = userFactoryJDBC;
	}

	public SellerJDBCFactory getSellerFactory() {
		return sellerFactory;
	}

	public void setSellerFactory(SellerJDBCFactory sellerFactory) {
		this.sellerFactory = sellerFactory;
	}

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
		
		User myUser = this.getUserFactoryJDBC().createUserJDBC(userID);
		
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
	
		this.checkFields(firstName, lastName, userID, email, telephone, address);
		
		//Get the user in the DB
		User myUser = this.getUserFactoryJDBC().createUserJDBC(userID);
		if(myUser.getUserID() != null){
			throw new Exception("UserID already taken !");
		}
		else{
			UserJDBC anUser = this.getUserFactoryJDBC().createUserJDBC();
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
	
	/**
	 * Methods called when a Seller wants to sign up.
	 * @param firstName
	 * @param lastName
	 * @param userID
	 * @param email
	 * @param phoneNumber
	 * @param address
	 * @param password
	 * @param confirm
	 * @param siret
	 * @param webaddress
	 * @return
	 * @throws Exception
	 */
	public Seller sigUpSeller(String firstName, String lastName, String userID, String email, String phoneNumber, String address, String password, String confirm, String siret, String webaddress) throws Exception{

		this.checkFields(firstName, lastName, userID, email, password, confirm);
		
		//Get the user in the DB
		User myUser = this.getUserFactoryJDBC().createUserJDBC(userID);
		if(myUser.getUserID() != null){
			throw new Exception("UserID already taken !");
		}
		else{ 
			SellerJDBC aSeller = this.getSellerFactory().createSellerJDBC();
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

	
	public User updateUser(User myUser, String firstName, String lastName, String userID, String email, String phoneNumber, String address, String password, String confirm, String siret, String webaddress) throws Exception{
		
		if(myUser instanceof Seller){
			return this.updateSeller((Seller)myUser, firstName, lastName, userID, email, phoneNumber, address, password, confirm, siret, webaddress);
		}
		else{
			//Create a new UserJDBC from myUser
		
			UserJDBC newUser = this.getUserFactoryJDBC().createUserJDBC();
			newUser.setUserID(myUser.getUserID());
			newUser.setFirstName(myUser.getFirstName());
			newUser.setLastName(myUser.getLastName());
			newUser.setPassword(myUser.getPassword());
			newUser.setEmail(myUser.getEmail());
			newUser.setAdress(myUser.getAdress());
			newUser.setTel(myUser.getTel());
			
		
			//Check if there is some updates.
			if(!firstName.isEmpty()){
				if(!newUser.getFirstName().equals(firstName)){
					newUser.setFirstName(firstName);
				}
			}
			
			if(!lastName.isEmpty()){
				if(!newUser.getLastName().equals(lastName)){
					newUser.setLastName(lastName);
				}
			}
			
			if(!password.isEmpty()){
				if(password.equals(confirm)){
					newUser.setPassword(password);
				}
				else{
					throw new Exception("Passwords are not equals !");
				}
			}
			
			if(!email.isEmpty()){
				if(!newUser.getEmail().equals(email)){
					newUser.setEmail(email);
				}
			}
			
			if(!address.isEmpty()){
				if(!newUser.getAdress().equals(address)){
					newUser.setAdress(address);
				}
			}
			
			if(!phoneNumber.isEmpty()){
				if(!newUser.getTel().equals(phoneNumber)){
					newUser.setTel(phoneNumber);
				}
			}
			
			newUser.updateUser();
			if(myUser instanceof Admin){
				Admin myAdmin = new Admin(newUser.getUserID(), newUser.getFirstName(), newUser.getLastName(), newUser.getPassword(), newUser.getEmail(), newUser.getTel(), newUser.getAdress());
				return myAdmin;
			}
			else{
				Customer myCustomer = new Customer(newUser.getUserID(), newUser.getFirstName(), newUser.getLastName(), newUser.getPassword(), newUser.getEmail(), newUser.getTel(), newUser.getAdress());
				return myCustomer;
			}
		}
	}
	
	public Seller updateSeller(Seller mySeller, String firstName, String lastName, String userID, String email, String phoneNumber, String address, String password, String confirm, String siret, String webaddress) throws Exception{
		
		return mySeller;
	}
	
	/**
	 * When sign up, check if all required fields are setted.
	 * @param firstName
	 * @param lastName
	 * @param userID
	 * @param email
	 * @param password
	 * @param confirm
	 * @throws Exception
	 */
	private void checkFields(String firstName, String lastName, String userID, String email, String password, String confirm) throws Exception{
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
	}
}


