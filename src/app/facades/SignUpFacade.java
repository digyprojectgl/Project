package app.facades;
import app.model.User;
import app.services.UserService;

public class SignUpFacade {
	
	public User signUpCustomer(String firstName, String lastName, String userID, String email, String phoneNumber, String address, String password, String confirm){
		UserService userService = new UserService();
		return userService.signUpCustomer(firstName, lastName, userID, email, phoneNumber, address, password, confirm);
	}
}
