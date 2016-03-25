package app.model.dao;

import app.model.Customer;

public class CustomerFactory {
	
	public Customer CustomerFactory(String userID, String firstName, String lastName, String password, String email, String telephone, String adress){
		return new Customer(userID, password, lastName, firstName, adress, telephone, email);
	}
}
