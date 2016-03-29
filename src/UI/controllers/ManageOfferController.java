package UI.controllers;

import java.util.ArrayList;
import app.model.Product;
import app.facades.OfferFacade;
import UI.core.RootController;
import UI.views.ManageOfferView;

public class ManageOfferController extends RootController {
    
	private OfferFacade offerFacade;
	private ManageOfferView mov;
	private String id;
	
    public ManageOfferController(){
         offerFacade = new OfferFacade();
         mov = new ManageOfferView(this);
         this.render(mov);
    }
    
	public void createOffer(Product prod, float prix, int qte) throws Exception {
		id = RootController.getUser().getUserID();
		offerFacade.createOffer(id,prod, prix, qte);
		
	}
	public ArrayList<Product> getProductList() throws Exception {
		return offerFacade.getProducts();
	}
}
