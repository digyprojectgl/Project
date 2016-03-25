package app.facades;

import app.model.Product;
import app.services.OfferService;

public class OfferFacade {
    private OfferService offerService;

	public void createOffer(Product prod, float prix, int qte) {

		offerService.createOffer(prod, prix, qte);
		
	}
}
