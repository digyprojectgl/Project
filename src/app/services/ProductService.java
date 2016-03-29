package app.services;

import app.model.Product;
import app.model.ProductList;
import app.model.dao.ProductJDBC;
import app.model.dao.ProductListJDBC;
import app.model.dao.ProductProposedJDBC;
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
     * update 'status=true' when valid a proposition of product
     * @author shui
     * @throws Exception 
     */
    public void newProduct(Product p) throws Exception{
    	ProductProposedJDBC productproposedJDBC = new ProductProposedJDBC(p.label, p.description, p.category, p.status);
    	productproposedJDBC.acceptProposition(p);
    	
    }
}
