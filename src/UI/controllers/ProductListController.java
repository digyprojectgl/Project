package UI.controllers;

import UI.core.RootController;
import UI.views.ProductListView;
import app.facades.ProductListFacade;

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

    public void obtainProductList(HashMap<String,String> options){
        this.productListView.displayProductList(this.productListFacade.obtainProductList(options));
    }

}
