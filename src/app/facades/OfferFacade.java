package app.facades;

import java.util.ArrayList;

import app.model.Product;
import app.model.sets.OfferSet;
import app.services.OfferService;

public class OfferFacade {
    private OfferService offerService; 
    
    public OfferFacade(){
    	offerService = new OfferService();
    }
    
    public ArrayList<Product> getProducts() throws Exception{
    	
    	return offerService.getProducts();
    }
    
	public void createOffer(String id, Product prod, float prix, int qte) throws Exception {
		
		offerService.createOffer(id,prod, prix, qte);
		
	}
	
	public OfferSet getAllOffer() throws Exception{
		return this.offerService.getAllOffers();
	}
	
	public OfferSet getOffersWithUserID(String userId) throws Exception{
		return this.offerService.getOfferWithUserID(userId);
	}
}
