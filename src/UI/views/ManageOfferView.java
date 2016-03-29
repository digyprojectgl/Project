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
	ManageOfferController moc;
	JPanel manageOffer;
	JButton createOffer;
	JButton updateOffer;
	JButton deleteOffer;
	JTextField priceOffer;
	JTextField qtyOffer;
	JLabel price;
	JLabel qty;
	JComboBox<Product> productOffer;
	
	
	public ManageOfferView(ManageOfferController moc){
		this.moc = moc;
	}


	@Override
	public String getLayout() {
		// TODO Auto-generated method stub
		return "main";
	}


	/**
	 * @throws  
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void render(Container contentPane) {
		
		this.manageOffer = new JPanel();
		this.createOffer = new JButton("Create");
		this.updateOffer = new JButton("update");
		this.deleteOffer = new JButton("delete");
		this.priceOffer = new JTextField("price");
		this.qtyOffer = new JTextField("qty");
		this.price = new JLabel("Price : ");
		this.qty = new JLabel("Quantity : ");
		this.productOffer = new JComboBox<Product>();
		
		try {
			for(int i=0;i<moc.getProductList().size();i++){
				this.productOffer.addItem(moc.getProductList().get(i));
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
				try {
					moc.createOffer(selectedProduct,Float.parseFloat(prix), Integer.parseInt(qte));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		contentPane.add(manageOffer);
		
	}
}