package app.factory;

import app.model.Offer;
import app.model.Product;
import app.model.dao.OfferJDBC;


public class OfferFactory {

	public OfferFactory(){
		
	}

	
	public Offer createOffer(String userID) throws Exception{
		return new OfferJDBC(userID);
	}
	
	
	public Offer createOffer(Product prod, float price, int quantity) throws Exception{
		String label = prod.getLabel();
		new OfferJDBC(label, price, quantity);
		return  new OfferJDBC(label);
	}
	
}
