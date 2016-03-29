package app.services;

import java.util.ArrayList;
import java.util.HashMap;

import app.factory.OfferFactory;
import app.factory.OfferSetFactory;
import app.model.Product;
import app.model.dao.ProductListJDBC;
import app.model.sets.OfferSet;

public class OfferService {

	public OfferFactory offerFactory = new OfferFactory();
	public OfferSetFactory offerSetFactory = new OfferSetFactory();
	
	public void createOffer(String id, Product prod, float prix, int qte) throws Exception {

		offerFactory.createOffer(id,prod, prix, qte);
	}
	
	
	public OfferSet getOfferWithUserID(String userId) throws Exception{
		try{
			OfferSet mySet = this.getOfferSetFactory().createOfferSet();
			return mySet.getOffersWithUserID(userId);
		}
		catch(Exception e){
			throw new Exception("Error when getting data.");
		}
	}
	/*
	public OfferSet getAllOffers() throws Exception{
		try{
			OfferSet mySet = this.getOfferSetFactory().createOfferSet();
			return mySet.getOffersWithUserID(userId);
		}
		catch(Exception e){
			throw new Exception("Error when getting data.");
		}
	}
	*/
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

}
