package UI.controllers;

import java.util.ArrayList;
import app.model.Product;
import app.facades.OfferFacade;

public class ManageOfferController {
    private OfferFacade offerFacade = new OfferFacade();
    public ManageOfferController(RootController rootController){
    }
	public static void createOffer(Product prod, float prix, int qte) {
		
		ManageOfferFacade.createOffer(prod, prix, qte);
		
	}
	public static ArrayList<Product> getProductList() {
		ArrayList<Product> prod = new ArrayList<Product>();
		return prod;
	}
}
