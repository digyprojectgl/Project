package app.services;

import app.factory.ProductFactory;
import app.factory.UserFactoryJDBC;
import app.model.Customer;
import app.model.Product;
import app.model.ProductCategory;
import app.model.ProductList;
import app.model.dao.ProductJDBC;
import app.model.User;
import app.model.dao.ProductListJDBC;
import app.model.dao.UserJDBC;

import java.util.HashMap;

/**
 * Created on 20/03/2016.
 *
 * @author Arthur
 */
public class ProductService {
    /**
     * Get the product list from the database.
     * Return the list of products containing all the products
     */
    public ProductList obtainProductList(HashMap<String,String> options) throws Exception {
        return new ProductListJDBC(options);
    }

    public Product getProduct(String label, String category) throws Exception {
        return new ProductJDBC(label, category);
    }
	/**
     * Add function 27/03 
     * Create a new product when valid a proposition of product
     * @author shui
     * @throws Exception 
     */
    public void newProduct(String label, String description, ProductCategory category) throws Exception{
    	if(label.isEmpty()){
    		throw new Exception("Lable is a required field !");
    	}
    	ProductFactory productFactory = new ProductFactory();
    	productFactory.createProduct(label, description, category);
    }
}
