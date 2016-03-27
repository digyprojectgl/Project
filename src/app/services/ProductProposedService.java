package app.services;

import app.factory.ProductProposedFactory;
import app.model.Product;
import app.model.ProductCategory;
import app.model.dao.ProductProposedJDBC;
import app.model.dao.ProductProposedListJDBC;

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
		productproposedJDBC.deleteProductProposed(label, description, category);
	}
	
	/**
	 * get the list of all the product proposition
	 * @return
	 */
	public Object getPropositionList() {
	        Object result;
	        ProductProposedListJDBC list = new ProductProposedListJDBC();
	        try {
	            result = list.getPropositionList();
	        } catch (Exception e) {
	            result = e;
	        }
	        return result;
	        }
}
