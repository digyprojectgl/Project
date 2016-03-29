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

    public ProductList obtainProductList(HashMap<String,String> options){
        try {
            return this.productListFacade.obtainProductList(options);
        } catch (Exception e) {
            productListView = new ProductListView(this);
            productListView.displayError(e.toString());
        }
        return new ProductList();
    }

    public ProductCategoryList obtainCategoryList()  {
        ProductCategoryList productCategoryList;
        try {
            productCategoryList = this.productListFacade.obtainCategoryList();
        } catch (Exception e) {
            productListView.displayError(e.toString());
            productCategoryList = new ProductCategoryList();
        }
        return productCategoryList;
    }
    
}
