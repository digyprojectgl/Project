package UI.controllers;

import UI.core.RootController;
import UI.views.ProductListView;
import app.facades.ProductListFacade;
import app.model.ProductCategoryList;
import app.model.ProductList;

import java.util.HashMap;

/**
 * Created on 20/03/2016.
 *
 * @author Arthur
 */
public class ProductListController extends RootController {
    private ProductListFacade productListFacade;
    private ProductListView productListView;

    public ProductListController() {
        productListFacade = new ProductListFacade();
        this.productListView = new ProductListView(this);
        this.render(productListView);
    }

    /**
     * Get the product list from the database.
     * @param options HashMap containing the options for the list of product
     * @return the productList containing all the products that meet the options
     */
    public ProductList obtainProductList(HashMap<String,String> options){
        try {
            return this.productListFacade.obtainProductList(options);
        } catch (Exception e) {
            productListView = new ProductListView(this);
            productListView.displayError("No product found");
        }
        return new ProductList();
    }

    /**
     * Get all the categories
     * If an error is caught, display it
     * @return the ProductCategoryList containing all the categories
     */
    public ProductCategoryList obtainCategoryList()  {
        ProductCategoryList productCategoryList;
        try {
            productCategoryList = this.productListFacade.obtainCategoryList();
        } catch (Exception e) {
            productListView.displayError("No category found");
            productCategoryList = new ProductCategoryList();
        }
        return productCategoryList;
    }
    
}
