package app.facades;

import java.util.ArrayList;

import app.model.Offer;
import app.model.Product;
import app.model.sets.OfferSet;
import app.services.OfferService;

public class OfferFacade {
    private OfferService offerService; 
    
    /**
     * Default Constructor
     */
    public OfferFacade(){
    	offerService = new OfferService();
    }
    
    /**
     * Call the getProducts method of OfferService
     * @return an ArrayList of Product
     * @throws Exception when problem with database
     */
    public ArrayList<Product> getProducts() throws Exception{
    	
    	return offerService.getProducts();
    }
    
    /**
     * Call the createOffer method of OfferService
     * @param id The id of the Seller
     * @param prod The Product concerned by the Offer
     * @param prix The price of the Offer
     * @param qte The quantity of Products in the Offer
     * @throws Exception when problems with database
     */
	public void createOffer(String id, Product prod, float prix, int qte) throws Exception {
		
		offerService.createOffer(id,prod, prix, qte);
		
	}
	
	/**
	 * Call the getAllOffer method of OfferService
	 * @return an OfferSet containing all the offers
	 * @throws Exception when problem with database
	 */
	public OfferSet getAllOffer() throws Exception{
		return this.offerService.getAllOffers();
	}
	
	/**
	 * Call the getOffersWithUserID method of offerService
	 * @param userId the Id of the Seller
	 * @return an OfferSet containing the offers created by this Seller
	 * @throws Exception when problem with database
	 */
	public OfferSet getOffersWithUserID(String userId) throws Exception{
		return this.offerService.getOfferWithUserID(userId);
	}

	/**
	 * Call the deleteOffer method of OfferService
	 * @param myOffer the offer we need to delete
	 */
	public void deleteOffer(Offer myOffer) {
		offerService.deleteOffer(myOffer);
	}

	/**
	 * Call the updateOffer method of OfferService
	 * @param myOffer the offer we want to update
	 * @param newPrice the new price of the offer
	 * @param newQuantity the new quantity of the offer
	 * @return a modified offer
	 */
	public Offer updateOffer(Offer myOffer, float newPrice, int newQuantity) {
		return offerService.updateOffer(myOffer, newPrice, newQuantity);
	}
}
