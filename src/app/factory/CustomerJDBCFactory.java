package app.factory;

import app.model.dao.CustomerJDBC;

public class CustomerJDBCFactory {
	
	public CustomerJDBCFactory(){
		
	}
	
	public CustomerJDBC createCustomerJDBC(String userID) throws Exception{
		return new CustomerJDBC(userID);
	}
}
