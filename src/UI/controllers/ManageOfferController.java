package UI.controllers;

import java.util.ArrayList;
import app.model.Product;
import app.facades.OfferFacade;
import UI.core.RootController;

public class ManageOfferController extends RootController {
    private OfferFacade offerFacade = new OfferFacade();
    
    public ManageOfferController(){
    }
    
	public void createOffer(Product prod, float prix, int qte) {
		
		offerFacade.createOffer(prod, prix, qte);
		
	}
	public static ArrayList<Product> getProductList() {
		ArrayList<Product> prod = new ArrayList<Product>();
		return prod;
	}
}
