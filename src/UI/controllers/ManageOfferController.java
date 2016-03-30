package UI.controllers;

import java.util.ArrayList;

import app.model.Offer;
import app.model.Product;
import app.model.sets.OfferSet;
import app.facades.OfferFacade;
import UI.core.RootController;
import UI.views.seller.ManageOfferView;

public class ManageOfferController extends RootController {
    
	private OfferFacade offerFacade;
	private ManageOfferView manageOfferView;
	private String id;
	
	/**
	 * Default Constructor
	 */
	public ManageOfferController(){
         offerFacade = new OfferFacade();
         OfferSet offers = this.getOfferWithUserID();
         manageOfferView = new ManageOfferView(this, offers);
         this.render(manageOfferView);
    }
    
	/**
	 * Get the id of the Seller and call the createOffer method of OfferFacade
	 * @param prod The product concerned by the offer
	 * @param prix The price of the offer
	 * @param qte The quantity of product in the offer
	 * @throws Exception when problem with the database or bad UserId
	 */
	public void createOffer(Product prod, float prix, int qte) throws Exception {
		this.setId(RootController.getUser().getUserID());
		offerFacade.createOffer(id,prod, prix, qte);
		
	}
	
	/**
	 * Call the getProducts method of OfferFacade
	 * @return an ArrayList containing all the products
	 * @throws Exception when problem with database
	 */
	public ArrayList<Product> getProductList() throws Exception {
		return offerFacade.getProducts();
	}
	
	/**
	 * Get the id of the User and call the gerOffersWithUserID of OfferFacade
	 * @return an OfferSet containing the offers created by this Seller
	 */
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

	/**
	 * Call the deleteOffer method of OfferFacade
	 * @param myOffer The Offer we want to delete
	 */
	public void deleteOffer(Offer myOffer) {
		this.getOfferFacade().deleteOffer(myOffer);
	}

	/**
	 * Call the updateOffer method of OfferFacade
	 * @param myOffer The Offer we want to update
	 * @param newPrice The new price of the offer
	 * @param newQantity The new quantity of product in the offer
	 * @return
	 */
	public Offer updateOffer(Offer myOffer, float newPrice, int newQantity) {
		return this.getOfferFacade().updateOffer(myOffer, newPrice, newQantity);
	}
}
