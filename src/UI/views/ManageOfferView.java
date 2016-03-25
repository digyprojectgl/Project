package UI.views;

import UI.controllers.ManageOfferController;
import UI.core.ViewInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import app.model.Offer;
import app.model.Product;
public class ManageOfferView implements ViewInterface{
	
	ArrayList<Product> products = new ArrayList<Product>();
	ManageOfferController moc = new ManageOfferController();

	JPanel manageOffer;
	JButton createOffer;
	JButton updateOffer;
	JButton deleteOffer;
	JTextField priceOffer;
	JTextField qtyOffer;
	JLabel price;
	JLabel qty;
	JComboBox<Product> productOffer;
	
	
	public ManageOfferView(Offer[] offres){
		this.manageOffer = new JPanel();
		this.createOffer = new JButton("Create");
		this.updateOffer = new JButton("update");
		this.deleteOffer = new JButton("delete");
		this.priceOffer = new JTextField("price");
		this.qtyOffer = new JTextField("qty");
		this.price = new JLabel("Price : ");
		this.qty = new JLabel("Quantity : ");
		this.productOffer = new JComboBox<Product>();
		
		for(int i=0;i<ManageOfferController.getProductList().size();i++){
			this.productOffer.addItem(ManageOfferController.getProductList().get(i));
		}
		
		this.manageOffer.add(productOffer,BorderLayout.WEST);
		this.manageOffer.add(price,BorderLayout.NORTH);
		this.manageOffer.add(priceOffer,BorderLayout.EAST);
		this.manageOffer.add(qty,BorderLayout.NORTH);
		this.manageOffer.add(qtyOffer,BorderLayout.NORTH);
		this.manageOffer.add(createOffer,BorderLayout.SOUTH);
		
		

		this.createOffer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product selectedProduct = (Product)productOffer.getSelectedItem();
				String prix = priceOffer.getText();
				String qte = qtyOffer.getText();
				moc.createOffer(selectedProduct,Float.parseFloat(prix), Integer.parseInt(qte));
			}
		});
	}


	@Override
	public String getLayout() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void render(Container contentPane) {
		// TODO Auto-generated method stub
		
	}
}