package app.facades;

import java.util.ArrayList;

import app.model.Product;
import app.services.OfferService;

public class OfferFacade {
    private OfferService offerService; 
    
    public OfferFacade(){
    	offerService = new OfferService();
    }
    
    public ArrayList<Product> getProducts() throws Exception{
    	
    	return offerService.getProducts();
    }
    
	public void createOffer(Product prod, float prix, int qte) throws Exception {
		
		offerService.createOffer(prod, prix, qte);
		
	}
	
	
}
