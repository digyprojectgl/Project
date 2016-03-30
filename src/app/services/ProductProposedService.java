package app.services;

import app.factory.ProductProposedFactory;
import app.model.Product;
import app.model.ProductCategory;
import app.model.ProductList;
import app.model.dao.ProductProposedJDBC;
import app.model.dao.ProductProposedListJDBC;

/**
 * all the functions with product not valid
 * @author shui
 */
public class ProductProposedService {
	
	/**
	 * Create the ProductProposedFactory. 
	 * Ask it to create a new ProductProposed.
	 */
	public Product proposeProduct(String label, String description, ProductCategory category) throws Exception{
		ProductProposedFactory factory = new ProductProposedFactory();
		factory.createProductProposed(label,description, category);
		return null;
		/**
		 *  //TODO
		 *  Changer la méthode pour : 
		 *  tester les champs
		 *  tester si le produit ne se trouve pas déjà en DB
		 *  créer le produit
		 *  le sauver en DB
		 *  le renvoyer
		 */
		
	}
	
	/**
	 * delete a ProductProposed when is valided or refused
	 */
	
	public void deleteProposition(Product p) throws Exception{
		String label = p.label;
	    String description = p.description;
	    ProductCategory category = p.category;
	    String status = p.status;
		ProductProposedJDBC productproposedJDBC = new ProductProposedJDBC(label, description, category, status);
		productproposedJDBC.deleteProductProposed(p);
	}
	
	/**
	 * get the list of all the product proposition
	 * @return
	 * @throws Exception 
	 */
	public ProductList getPropositionList() throws Exception {
	        ProductList result;
	        ProductProposedListJDBC list = new ProductProposedListJDBC();
	        result = list.getPropositionList();
	        return result;
	        }
}
