package app.facades;

import app.model.Product;
import app.services.ProductService;

/**
 * Created on 27/03/2016.
 *
 * @author Arthur
 */
public class ProductFacade {
    private ProductService productService;

    public ProductFacade() {
        this.productService = new ProductService();
    }

    public Product getProduct(String label, String category) throws Exception {
        return productService.getProduct(label, category);
    }
}
