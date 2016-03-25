package app.factory;

import app.model.Admin;

public class AdminFactory {
	
	public Admin createAdmin(String userID, String firstName, String lastName, String password, String email, String telephone, String address){
		return new Admin(userID, password, lastName, firstName, address, telephone, email);
	}
}
