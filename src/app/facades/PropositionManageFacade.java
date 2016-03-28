package app.facades;
/**
 * delegate the functions to handle proposition:accept or refuse
 * @author shui
 */

import app.model.ProductCategory;
import app.services.ProductProposedService;
import app.services.ProductService;

public class PropositionManageFacade {
	private ProductService manageproductService;
	private ProductProposedService managepropositionService; 
	/**
	 * constructor
	 */
	public PropositionManageFacade(){
		manageproductService = new ProductService();
		managepropositionService = new ProductProposedService();
		
	}
/**
 * valid/refuse a proposition
 * @throws Exception 
 */
	public void acceptProposition(String label, String description, ProductCategory category) throws Exception {
		manageproductService.newProduct(label, description, category);
		managepropositionService.deleteProposition(label, description, category);
	}
    
	public void refuseProposition(String label, String description, ProductCategory category) throws Exception {
		managepropositionService.deleteProposition(label, description, category);
	}
}
