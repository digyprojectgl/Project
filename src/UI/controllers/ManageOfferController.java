package UI.controllers;

import java.util.ArrayList;
import app.model.Product;
import app.model.sets.OfferSet;
import app.facades.OfferFacade;
import UI.core.RootController;
import UI.views.seller.ManageOfferView;

public class ManageOfferController extends RootController {
    
	private OfferFacade offerFacade;
	private ManageOfferView manageOfferView;
	private String id;
	
	public ManageOfferController(){
         offerFacade = new OfferFacade();
         OfferSet offers = this.getOfferWithUserID();
         manageOfferView = new ManageOfferView(this, offers);
         this.render(manageOfferView);
    }
    
	public void createOffer(Product prod, float prix, int qte) throws Exception {
		this.setId(RootController.getUser().getUserID());
		offerFacade.createOffer(id,prod, prix, qte);
		
	}
	
	public ArrayList<Product> getProductList() throws Exception {
		return offerFacade.getProducts();
	}
	
	public OfferSet getOfferWithUserID(){
		try{
			id = RootController.getUser().getUserID();
			return offerFacade.getOffersWithUserID(id);	
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	 public OfferFacade getOfferFacade() {
			return offerFacade;
		}

		public void setOfferFacade(OfferFacade offerFacade) {
			this.offerFacade = offerFacade;
		}

		public ManageOfferView getManageOfferView() {
			return manageOfferView;
		}

		public void setMov(ManageOfferView manageOfferView) {
			this.manageOfferView = manageOfferView;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
}
