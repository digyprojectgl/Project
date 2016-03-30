package app.facades;
/**
 * delegate the functions to handle proposition:accept or refuse
 * @author shui
 */

import app.model.Product;
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
	public void acceptProposition(Product p) throws Exception {
		manageproductService.newProduct(p);
		managepropositionService.deleteProposition(p);
	}
    
	public void refuseProposition(Product p) throws Exception {
		managepropositionService.deleteProposition(p);
	}
}
