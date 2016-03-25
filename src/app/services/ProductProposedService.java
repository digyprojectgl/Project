package app.services;

import app.factory.ProductProposedFactory;
import app.model.Product;
import app.model.ProductCategory;
import app.model.dao.ProductProposedJDBC;

/**
 * @author shui
 */
public class ProductProposedService {
	/**
	 * Static method.
	 * Create the ProductProposedFactory. 
	 * Ask it to create a new ProductProposed.
	 */
	public Product proposeProduct(String label, String description, ProductCategory category) throws Exception{
		ProductProposedFactory factory = new ProductProposedFactory();
		factory.createProductProposed(label,description, category);
		return null;
		
	}
	
	/**
	 * delete a ProductProposed when is valided or refused
	 */
	
	public void deleteProposition(String label, String description, ProductCategory category) throws Exception{
		ProductProposedJDBC productproposedJDBC = new ProductProposedJDBC(label, description, category);
		productproposedJDBC.DeleteProductProposed(label, description, category);
	}
	
	/**
	 * wait for admin side
	 * display the list of product proposed
	 *
	 * public Object listproposedProduct(String options) {
        Object list;
        try {
            list = new PropositionManageJDBC(options);
        } catch (Exception e) {
            list = e;
        }
        return list;
    }
    */
}
