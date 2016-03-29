package app.facades;

import app.model.Product;
import app.model.ProductCategory;
import app.model.ProductCategoryList;
import app.services.ProductCategoryService;
import app.services.ProductProposedService;

/**
 * @author shui
 */
public class ProposeProductFacade {
	private ProductProposedService proposeProductservice = new ProductProposedService();
	private ProductCategoryService productCategoryService = new ProductCategoryService();
	
	public Product proposeproduct(String label, String description, ProductCategory category) throws Exception{
		return proposeProductservice.proposeProduct(label, description, category);
	}
	
	public void deleteproductproposed(String label, String description, ProductCategory category) throws Exception{
		proposeProductservice.deleteProposition(label, label, category);
	}
	
	public ProductCategoryList obtainCategoryList() throws Exception{
		return this.productCategoryService.obtainCategoryList();
	}
}
