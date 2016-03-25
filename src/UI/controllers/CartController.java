package UI.controllers;

import app.facades.CartFacade;

/**
 * Created on 21/03/2016.
 *
 * @author Arthur
 */
public class CartController {
    private CartFacade cartFacade;
    private RootController rootController;

    public CartController(RootController rootController){
        this.rootController = rootController;
        this.cartFacade = new CartFacade();


    }
}
