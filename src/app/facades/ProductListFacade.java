package app.facades;

import app.model.ProductList;
import app.services.ProductService;

import java.util.HashMap;

/**
 * Created on 20/03/2016.
 *
 * @author Arthur
 */
public class ProductListFacade {
    private ProductService productService;

    public ProductListFacade() {
        productService = new ProductService();
    }

    public Object obtainProductList(HashMap<String,String> options) {
        return productService.obtainProductList(options);
    }
}
