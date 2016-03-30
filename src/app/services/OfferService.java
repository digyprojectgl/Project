package app.services;

import java.util.ArrayList;
import java.util.HashMap;

import app.factory.OfferFactory;
import app.factory.OfferSetFactory;
import app.model.Offer;
import app.model.Product;
import app.model.dao.ProductListJDBC;
import app.model.sets.OfferSet;

public class OfferService {

	public OfferFactory offerFactory = new OfferFactory();
	public OfferSetFactory offerSetFactory = new OfferSetFactory();
	
	/**
	 * Call the createOffer method of OfferFactory
	 * @param id the id of the seller who created the Offer
	 * @param prod the product concerned by the offer
	 * @param prix the price of the offer
	 * @param qte the quantity of product in the offer
	 * @throws Exception when problem with database
	 */
	public void createOffer(String id, Product prod, float prix, int qte) throws Exception {

		offerFactory.createOffer(id,prod, prix, qte);
	}
	
	/**
	 * Call the OfferSetFactory to create an OfferSet of the offers created by this Seller
	 * @param userId the Id of the seller who created the offers
	 * @return an OfferSet containing the offers created by this Seller
	 * @throws Exception when problem with database
	 */
	public OfferSet getOfferWithUserID(String userId) throws Exception{
		try{
			OfferSet mySet = this.getOfferSetFactory().createOfferSet();
			return mySet.getOffersWithUserID(userId);
		}
		catch(Exception e){
			throw new Exception("Error when getting data.");
		}
	}
	
	/**
	 * Call the OfferFactory to create an OfferSet of all the offers
	 * @return an OfferSet containing all the offers
	 * @throws Exception when problem with the database
	 */
	public OfferSet getAllOffers() throws Exception{
		try{
			OfferSet mySet = this.getOfferSetFactory().createOfferSet();
			return mySet.getAllOffers();
		}
		catch(Exception e){
			throw new Exception("Error when getting data.");
		}
	}
	
	public ArrayList<Product> getProducts() throws Exception{
		return new ProductListJDBC(new HashMap<String, String>()).productList;
	}

	public OfferFactory getOfferFactory() {
		return offerFactory;
	}

	public void setOfferFactory(OfferFactory offerFactory) {
		this.offerFactory = offerFactory;
	}

	public OfferSetFactory getOfferSetFactory() {
		return offerSetFactory;
	}

	public void setOfferSetFactory(OfferSetFactory offerSetFactory) {
		this.offerSetFactory = offerSetFactory;
	}

	/**
	 * Call the deleteOffer method of OfferFactory
	 * @param myOffer the offer we want to delete
	 */
	public void deleteOffer(Offer myOffer) {
		offerFactory.deleteOffer(myOffer);
	}

	/**
	 * Call the updateOffer method of offerFactory
	 * @param myOffer the Offer we want to update
	 * @param newPrice the new price of the offer
	 * @param newQuantity the new quantity of products in the offer
	 * @return the updated offer
	 */
	public Offer updateOffer(Offer myOffer, float newPrice, int newQuantity) {
		return offerFactory.updateOffer(myOffer,newPrice,newQuantity);
	}

}
