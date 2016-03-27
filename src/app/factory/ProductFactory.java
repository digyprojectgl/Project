package app.factory;
/**
 * create a new product(valid by admin)
 * @author shui
 */

import app.model.ProductCategory;
import app.model.dao.ProductJDBC;

public class ProductFactory {
	public ProductFactory(){
	}
	
	public void createProduct(String label, String description, ProductCategory category) throws Exception{
		ProductJDBC newproductJDBC = new ProductJDBC(label,description, category);
		newproductJDBC.addProduct();
		}
}
