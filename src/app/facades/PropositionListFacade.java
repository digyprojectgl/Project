package app.facades;
/**
 * @author shui
 */

import app.services.ProductProposedService;

public class PropositionListFacade {
	private ProductProposedService productproposedService;

    public PropositionListFacade() {
        productproposedService = new ProductProposedService();
    }

    public Object getProductProposedList() {
        return productproposedService.getPropositionList();
    }
}
