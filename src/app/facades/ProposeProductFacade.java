package app.facades;

import app.model.Product;
import app.services.ProductProposedService;

public class ProposeProductFacade {
	private ProductProposedService proposeProductservice;
	
	public Product proposeproduct(String ProposeProductLabel, String ProposeProductDescription) throws Exception{
		proposeProductservice = new ProductProposedService();
		return proposeProductservice.proposeProduct(ProposeProductLabel, ProposeProductDescription);
	}
}
/**
 * @author shui
 */