package app.facades;
/**
 * @author shui
 */

import app.model.ProductList;
import app.services.ProductProposedService;

public class PropositionListFacade {
	private ProductProposedService productproposedService;

    public PropositionListFacade() {
        productproposedService = new ProductProposedService();
    }

    public ProductList getProductProposedList() throws Exception {
        return productproposedService.getPropositionList();
    }
}
