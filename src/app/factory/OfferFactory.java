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
	
	
	public Offer createOffer(String id, Product prod, float price, int quantity) throws Exception{
		String label = prod.getLabel();
		new OfferJDBC(id, label, price, quantity);
		return  new OfferJDBC(label);
	}


	public void deleteOffer(Offer myOffer) {
		try {
			new OfferJDBC(myOffer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public Offer updateOffer(Offer myOffer, float newPrice, int newQuantity) {
		try {
			return new OfferJDBC(myOffer,newPrice,newQuantity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myOffer;
	}
	
}
