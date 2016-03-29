package UI.controllers;

import UI.core.RootController;
import UI.views.ProductView;
import app.facades.OfferListFacade;
import app.facades.ProductFacade;
import app.model.Offer;
import app.model.Product;

import javax.swing.*;
import java.util.ArrayList;


/**
 * Created on 27/03/2016.
 *
 * @author Arthur
 */
public class ProductController extends RootController {
    private ProductFacade productFacade;
    private OfferListFacade offerFacade;
    private ProductView view;

    public ProductController(String[] params) {
        this.productFacade = new ProductFacade();
        this.offerFacade = new OfferListFacade();
        Product product = null;
        this.view = new ProductView(this);
        try {
            product = this.productFacade.getProduct(params[1],params[0]);
            this.view.setProduct(product);
            this.render(view);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error while retrieving the product", "Error", JOptionPane.INFORMATION_MESSAGE);
            this.goTo("productList");
        }
    }

    /**
     * Get all the public offers associated with a product
     * @param product the product concerned by the offers
     * @return the ArrayList containing all the offers
     */
    // TODO: 28/03/2016 complete the method 
    public ArrayList<Offer> getOffers(Product product) {
        return null;
    }
}
