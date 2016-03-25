package app.factory;

import app.model.Seller;
import app.model.dao.SellerJDBC;

public class SellerJDBCFactory {
	
	public Seller createSellerJDBC(String userID){
		return new SellerJDBC(userID);
	}
}
