package UI.controllers;

import UI.views.ProductListView;
import app.facades.ProductListFacade;

import java.util.HashMap;

/**
 * Created on 20/03/2016.
 *
 * @author Arthur
 */
public class ProductListController {
    private ProductListFacade productListFacade;
    private RootController rootController;
    private ProductListView productListView;

    public ProductListController(RootController rootController) {
        this.rootController = rootController;
        productListView = new ProductListView(this.rootController.getContentPane(),this);
        productListFacade = new ProductListFacade();
    }

    public Object obtainProductList(HashMap<String,String> options){
        return this.productListFacade.obtainProductList(options);
    }

}
