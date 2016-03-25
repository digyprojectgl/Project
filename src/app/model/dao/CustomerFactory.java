package app.model.dao;

import app.model.Customer;

public class CustomerFactory {
	
	public CustomerFactory(){
		
	}
	
	public Customer createCustomer(String userID, String firstName, String lastName, String password, String email, String telephone, String address){
		return new Customer(userID, password, lastName, firstName, address, telephone, email);
	}
}
