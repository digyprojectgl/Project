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

    /**
     * Get a product from the database
     * @param label the name of the product
     * @param category the name of the category
     * @return the product whose name and category correspond the parameters
     * @throws Exception if no product is found or the database has a problem
     */
    public Product getProduct(String label, String category) throws Exception {
        return productService.getProduct(label, category);
    }
}
