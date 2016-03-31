package UI.controllers;

import UI.core.RootController;
import UI.views.ProductView;
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
    private ProductView view;

    public ProductController(String[] params) {
        this.productFacade = new ProductFacade();
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
    public Object getOffers(Product product) {
        Object offers;
        try {
            offers = productFacade.getOffers(product.getLabel()).getOffers();
        } catch (Exception e) {
            offers = "No offer found";
        }
        return offers;
    }

    public void createOffer(Product product, int quantity, float price) {
        try {
            productFacade.createOffer(ProductController.getUser().getUserID(), product, quantity, price);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error while creating the offer", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
