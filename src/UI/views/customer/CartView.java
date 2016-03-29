package UI.views.customer;

import UI.controllers.CartController;
import UI.core.ViewInterface;

import java.awt.*;

import javax.swing.JLabel;

/**
 * Created on 25/03/2016.
 *
 * @author Arthur
 */
public class CartView implements ViewInterface {

    private CartController cartController;

    public CartView(CartController cartController) {
        this.cartController = cartController;
    }

    @Override
    public String getLayout() {
        return "main";
    }

    @Override
    public void render(Container contentPane) {
    	contentPane.add(new JLabel("cart"));
        // TODO: 25/03/2016 complete the function 
    }
}
