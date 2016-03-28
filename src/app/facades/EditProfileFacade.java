package app.facades;

import app.model.User;
import app.services.UserService;

public class EditProfileFacade {
	UserService userService = new UserService();
	
	public User updateUser(User myUser, String firstName, String lastName, String userID, String email, String phoneNumber, String address, String password, String confirm, String siret, String webaddress) throws Exception{
		return this.userService.updateUser(myUser, firstName, lastName, userID, email, phoneNumber, address, password, confirm, siret, webaddress);
	}
		
}
