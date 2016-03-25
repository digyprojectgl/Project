package app.facades;
import app.model.Customer;
import app.model.User;
import app.services.UserService;

public class SignUpFacade {
	
	public Customer signUpCustomer(String firstName, String lastName, String userID, String email, String phoneNumber, String address, String password, String confirm) throws Exception{
		UserService userService = new UserService();
		return userService.signUpCustomer(firstName, lastName, userID, email, phoneNumber, address, password, confirm);
	}
}
