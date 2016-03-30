package app.factory;

import app.model.Offer;
import app.model.Product;
import app.model.dao.OfferJDBC;


public class OfferFactory {
	
	/**
	 * Default constructor
	 */
	public OfferFactory(){
		
	}

	/**
	 * Create a new OfferJDBC to create a default offer in the database
	 * @param userID the seller who create the offer
	 * @return the newly created Offer
	 * @throws Exception when problem with database
	 */
	public Offer createOffer(String userID) throws Exception{
		return new OfferJDBC(userID);
	}
	
	/**
	 * Create a new OfferJDBC to create an offer with parameters in the database
	 * @param id the id of the seller who created the offer
	 * @param prod the product concerned by the Offer
	 * @param price the price of the Offer
	 * @param quantity the quantity of products in the Offer
	 * @return a newly created Offer
	 * @throws Exception when problem with database
	 */
	public Offer createOffer(String id, Product prod, float price, int quantity) throws Exception{
		String label = prod.getLabel();
		new OfferJDBC(id, label, price, quantity);
		return  new OfferJDBC(label);
	}

	/**
	 * Create a new OfferJDBC to delete an offer in the database
	 * @param myOffer the Offer we want to delete
	 */
	public void deleteOffer(Offer myOffer) {
		try {
			new OfferJDBC(myOffer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create a new OfferJDBC to update an Offer in the database
	 * @param myOffer the Offer concerned by the update
	 * @param newPrice the new price of the Offer
	 * @param newQuantity the new quantity of products in the Offer
	 * @return an updated Offer
	 */
	public Offer updateOffer(Offer myOffer, float newPrice, int newQuantity) {
		try {
			return new OfferJDBC(myOffer,newPrice,newQuantity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return myOffer;
	}
	
}
