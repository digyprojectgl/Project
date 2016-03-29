package UI.controllers;

import java.util.ArrayList;
import app.model.Product;
import app.facades.OfferFacade;
import UI.core.RootController;
import UI.views.ManageOfferView;

public class ManageOfferController extends RootController {
    
	private OfferFacade offerFacade;
	private ManageOfferView mov;
	
    public ManageOfferController(){
         offerFacade = new OfferFacade();
         mov = new ManageOfferView(this);
         this.render(mov);
    }
    
	public void createOffer(Product prod, float prix, int qte) {
		
		offerFacade.createOffer(prod, prix, qte);
		
	}
	public static ArrayList<Product> getProductList() {
		return offerFacade.getProductList();
	}
}
