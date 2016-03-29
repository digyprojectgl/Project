package app.facades;

import app.model.Product;
import app.model.ProductCategory;
import app.services.ProductProposedService;

/**
 * @author shui
 */
public class ProposeProductFacade {
	private ProductProposedService proposeProductservice;
	
	public Product proposeproduct(String label, String description, ProductCategory category) throws Exception{
		return proposeProductservice.proposeProduct(label, description, category);
	}
	
	public void deleteproductproposed(String label, String description, ProductCategory category) throws Exception{
		proposeProductservice.deleteProposition(label, label, category);
	}
}
