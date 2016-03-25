package UI.controllers;

import UI.core.RootController;
import app.facades.CartFacade;

/**
 * Created on 21/03/2016.
 *
 * @author Arthur
 */
public class CartController extends RootController {
    private CartFacade cartFacade;

    public CartController(){
        this.cartFacade = new CartFacade();
    }
}
