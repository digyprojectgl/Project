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
	
	private ProductProposedFactory factory = new ProductProposedFactory();
	
	/**
	 * Create the ProductProposedFactory. 
	 * Ask it to create a new ProductProposed.
	 */
	public Product proposeProduct(String label, String description, ProductCategory category) throws Exception{
		this.checkFields(label, category);
		
		Product myproduct = factory.createProductProposedJDBC(label, description, category);
		if(myproduct.getLabel()!=null){
			throw new Exception("Label has been already used");
		}
		else{
			ProductProposedJDBC aproposition = factory.createProductProposedJDBC(); 
			aproposition.setLabel(label);
			aproposition.setDescription(description);
			aproposition.setCategory(category);
			aproposition.setStatus("false");
			try{
				aproposition.addProductProposed(label, description, category);
			}
			catch (Exception e){
				throw new Exception("Error with the insertion in the DB.");
			}
			Product productproposed = new Product(aproposition.getLabel(),aproposition.getDescription(),aproposition.getCategory(),aproposition.getStatus());
			return productproposed;
		}		
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
	
	/**
	 * check label and category are not null
	 */
	private void checkFields(String label, ProductCategory category) throws Exception{
		if(label.isEmpty()){
			throw new Exception("Label is a required field !");
		}
		if(category.getLabel()== null){
			throw new Exception("Category is a required field !");
		}
	}

}
