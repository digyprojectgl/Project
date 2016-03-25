package app.services;

import app.model.Product;
import app.model.dao.ProductProposedFactory;

public class ProductProposedService {
	/**
	 * Static method.
	 * Create the ProductProposedFactory. Ask it to create a new ProductProposed.
	 * @author shui
	 */
	public Product proposeProduct(String label, String description) throws Exception{
		label.trim();
		//description?
		ProductProposedFactory factory = new ProductProposedFactory();
		factory.createProductProposed(label,description);
		return null;
		
	}
}
