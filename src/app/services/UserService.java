package app.services;

import app.model.User;
import app.model.dao.UserFactory;
import app.model.dao.UserJDBC;

public class UserService {
	public static User handleLogIn(String userID, String password) throws Exception{
		UserFactory factory = new UserFactory();
		User myUser = factory.createUser();
		
		userID.trim();
		userID.toLowerCase();
		myUser.setUserID(userID);
		myUser.setPassword(password);
		
		User userFind = UserJDBC.findUser(myUser.getUserID());
		System.out.println(userFind.getPassword());
		System.out.println(myUser.getPassword());
		if(userFind.getPassword().equals(myUser.getPassword())){
			return userFind;
		}
		else{
			throw new Exception("Wrong password !");
		}
		
	}
}
