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

    public ProductList obtainProductList(HashMap<String,String> options) throws Exception {
        return productService.obtainProductList(options);
    }

    public ProductCategoryList obtainCategoryList() throws Exception {
        return categoryService.obtainCategoryList();
    }
}
