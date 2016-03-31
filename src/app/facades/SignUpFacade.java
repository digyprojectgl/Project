package app.facades;
import app.model.Customer;
import app.model.Seller;
import app.model.User;
import app.services.UserService;

public class SignUpFacade {
	UserService userService = new UserService();
	
	public Customer signUpCustomer(String firstName, String lastName, String userID, String email, String phoneNumber, String address, String password, String confirm) throws Exception{
		return this.userService.signUpCustomer(firstName, lastName, userID, email, phoneNumber, address, password, confirm);
	}
	
	public Seller signUpSeller(String firstName, String lastName, String userID, String email, String phoneNumber, String address, String password, String confirm, String siret, String webaddress) throws Exception{
		return this.userService.signUpSeller(firstName, lastName, userID, email, phoneNumber, address, password, confirm, siret, webaddress);
	}
}
