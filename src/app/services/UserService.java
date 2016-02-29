package app.services;

import app.model.User;
import app.model.dao.UserFactory;

public class UserService {
	public static User handleLogIn(String username, String password){
		UserFactory f = new UserFactory();
		User myUser = f.createUser();
		return myUser;
	}
}
