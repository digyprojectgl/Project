package app.services;

import app.model.ProductList;
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
    public Object obtainProductList(HashMap<String,String> options) {
        Object list;
        try {
            list = new ProductListJDBC(options);
        } catch (Exception e) {
            list = e;
        }
        return list;
    }
}
