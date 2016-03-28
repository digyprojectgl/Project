package app.factory;

import app.model.Seller;
import app.model.dao.SellerJDBC;

public class SellerJDBCFactory {
	
	public SellerJDBC createSellerJDBC(String userID) throws Exception{
		return new SellerJDBC(userID);
	}
	
	public SellerJDBC createSellerJDBC(){
		return new SellerJDBC();
	}
}
