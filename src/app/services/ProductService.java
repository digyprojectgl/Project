package app.services;

import app.model.Product;
import app.model.ProductList;
import app.model.dao.ProductJDBC;
import app.model.dao.ProductListJDBC;

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
}
