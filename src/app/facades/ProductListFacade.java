package app.facades;

import app.model.ProductCategoryList;
import app.model.ProductList;
import app.services.ProductCategoryService;
import app.services.ProductService;

import java.util.HashMap;

/**
 * Created on 20/03/2016.
 *
 * @author Arthur
 */
public class ProductListFacade {
    private ProductService productService;
    private ProductCategoryService categoryService;

    public ProductListFacade() {
        productService = new ProductService();
        categoryService = new ProductCategoryService();
    }

    /**
     * Get the list of products corresponding to the options
     * @param options HashMap containing the options for the list of product
     * @return the productList containing all the products that meet the options
     * @throws Exception  if no product is found or the database has a problem
     */
    public ProductList obtainProductList(HashMap<String,String> options) throws Exception {
        return productService.obtainProductList(options);
    }

    /**
     * Get the list containing all the categories
     * @return the ProductCategoryList containing all the categories
     * @throws Exception  if no category is found or the database has a problem
     */
    public ProductCategoryList obtainCategoryList() throws Exception {
        return categoryService.obtainCategoryList();
    }
}
