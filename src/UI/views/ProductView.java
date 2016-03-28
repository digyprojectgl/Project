package UI.views;

import UI.controllers.ProductController;
import UI.core.ViewInterface;
import app.model.Product;

import javax.swing.*;
import java.awt.*;

/**
 * Created on 27/03/2016.
 *
 * @author Arthur
 */
public class ProductView implements ViewInterface {

    private ProductController productController;
    private Product product;

    public ProductView(ProductController productController) {
        this.productController = productController;
    }

    @Override
    public String getLayout() {
        return "main";
    }

    @Override
    public void render(Container contentPane) {
        JPanel global = new JPanel(new BorderLayout());

        JLabel productLabel = new JLabel(product.getLabel() + " ");
        JLabel productDescription = new JLabel(product.getDescription());
        JLabel productCategory = new JLabel("Category : " + product.getCategory().getLabel());

        JPanel product = new JPanel(new BorderLayout());
        product.add(productLabel, BorderLayout.NORTH);
        product.add(productCategory, BorderLayout.EAST);
        product.add(productDescription, BorderLayout.SOUTH);

        JPanel offers = new JPanel(new GridLayout(0,1));

        global.add(product, BorderLayout.NORTH);
        contentPane.add(global);
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
