package UI.views;

import UI.controllers.ProductController;
import UI.core.ViewInterface;
import app.model.Customer;
import app.model.Offer;
import app.model.Product;
import app.model.Seller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

        JPanel productPane = new JPanel(new BorderLayout());
        productPane.add(productLabel, BorderLayout.NORTH);
        productPane.add(productCategory, BorderLayout.CENTER);
        productPane.add(productDescription, BorderLayout.SOUTH);

        JPanel offers = new JPanel(new BorderLayout());
        if (ProductController.getUser() instanceof Customer) {
            JPanel header = new JPanel(new GridLayout(2,0));
            header.add(new JSeparator());
            header.add(new JLabel("Offers :"));
            offers.add(header, BorderLayout.NORTH);
            JPanel offerPane = new JPanel(new GridLayout(0,1));
            offers.add(offerPane, BorderLayout.CENTER);
            Object offerSet = productController.getOffers(product);
            if (offerSet instanceof ArrayList) {
                ArrayList<Offer> offerArrayList = (ArrayList<Offer>) offerSet;
                for (int i=0; i< offerArrayList.size() ; i++) {
                    JPanel offer = new JPanel(new GridLayout(4,0));
                    offer.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    offer.add(new JLabel("Seller : " + offerArrayList.get(i).getIdUser()));
                    offer.add(new JLabel("Price : " + offerArrayList.get(i).getPrice()));
                    offer.add(new JLabel("Quantity available : " + offerArrayList.get(i).getQuantity()));
                    offer.add(new JSeparator());
                    offerPane.add(offer);
                }
            } else {
                offers.add(new JLabel("No offer available for this product"));
            }
        } else if (ProductController.getUser() instanceof Seller) {
            JPanel labels = new JPanel(new GridLayout(2,0));
            labels.add(new JLabel("Quantity : "));
            labels.add(new JLabel("Price per unit : "));

            JPanel fields = new JPanel(new GridLayout(2,0));
            final JTextField qty = new JTextField();
            final JTextField price = new JTextField();
            fields.add(qty);
            fields.add(price);

            JPanel setter = new JPanel(new GridLayout(0,2));
            setter.add(labels);
            setter.add(fields);

            JButton addOffer = new JButton("Add offer");
            addOffer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    createOffer(Integer.parseInt(qty.getText()), Float.parseFloat(price.getText()));
                }
            });
            offers.add(setter, BorderLayout.CENTER);
            offers.add(addOffer, BorderLayout.EAST);
        }


        global.add(productPane, BorderLayout.NORTH);
        global.add(offers, BorderLayout.CENTER);
        contentPane.add(global);
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void createOffer(int quantity, float price) {
        this.productController.createOffer(this.product, quantity, price);
    }
}