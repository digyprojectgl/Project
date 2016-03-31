package UI.views.seller;

import UI.controllers.ManageOfferController;
import UI.core.ViewInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import app.model.Offer;
import app.model.Product;
import app.model.sets.OfferSet;
public class ManageOfferView implements ViewInterface{
	
	ArrayList<Product> products = new ArrayList<Product>();
	OfferSet offers;
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
	
	/**
	 * Constructor with parameters
	 * @param moc The ManageOfferController who brings the data
	 * @param offers The OfferSet containing the offers
	 */
	public ManageOfferView(ManageOfferController moc, OfferSet offers){
		this.offers = offers;
		this.moc = moc;
	}

	@Override
	public String getLayout() {
		// TODO Auto-generated method stub
		return "main";
	}


	
	@Override
	public void render(Container contentPane) {
		
		int nbElem = 3;		//	NbElem/line
		int c = nbElem;
		int r ;
		
		this.manageOffer = new JPanel(new BorderLayout());
		JPanel panelCreate = new JPanel();

		this.createOffer = new JButton("Create");
		this.updateOffer = new JButton("update");
		this.deleteOffer = new JButton("delete");
		this.priceOffer = new JTextField(5);
		this.qtyOffer = new JTextField(5);
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
		
		panelCreate.add(productOffer);
		panelCreate.add(price);
		panelCreate.add(priceOffer);
		panelCreate.add(qty);
		panelCreate.add(qtyOffer);
		panelCreate.add(createOffer);
		
		this.manageOffer.add(panelCreate, BorderLayout.NORTH);
		
		

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
	
		if(offers.count()%nbElem == 0){
			r = offers.count()/nbElem ;
		}
		else{
			r = offers.count()/nbElem + 1;
		}
		JPanel gridPanel = new JPanel(new GridLayout(r, c));

		for(final Offer myOffer: offers.getOffers()){
			JPanel bloc = new JPanel();
			JPanel columns = new JPanel(new GridLayout(7,0));
			JLabel labelOffer =  new JLabel("Name : " +myOffer.getLabelProduct());
			JLabel priceLabel = new JLabel("Price : ");
			final JTextField price = new JTextField(Float.toString(myOffer.getPrice()));
			JLabel quantityLabel = new JLabel("Quantity : ");
			final JTextField quantity = new JTextField(Integer.toString(myOffer.getQuantity()));
			JButton update = new JButton("Update");
			JButton delete = new JButton("Delete");
			
			update.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					int newQuantity = Integer.parseInt(quantity.getText());
					float newPrice = Float.parseFloat(price.getText());
					updateOffer(myOffer, newPrice, newQuantity);
				}
			});
			
			delete.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					deleteOffer(myOffer);
				}
			});
			
			columns.add(labelOffer);
			columns.add(priceLabel);
			columns.add(price);
			columns.add(quantityLabel);
			columns.add(quantity);
			columns.add(update);
			columns.add(delete);
			bloc.add(columns);
			gridPanel.add(bloc);
			
			this.manageOffer.add(gridPanel, BorderLayout.CENTER);

		}
		
		
		contentPane.add(manageOffer);
		
	}


	public ManageOfferController getMoc() {
		return moc;
	}


	public void setMoc(ManageOfferController moc) {
		this.moc = moc;
	}
	/**
	 * Call the deleteOffer method of ManageOfferController
	 * @param myOffer The offer we want to delete
	 */
	public void deleteOffer(Offer myOffer){
		this.getMoc().deleteOffer(myOffer);
	}
	
	/**
	 * Call the updateOffer method of ManageOfferController
	 * @param myOffer The Offer we want to update
	 * @param newPrice The new price of the offer
	 * @param newQuantity The new quantity of product in the Offer
	 * @return
	 */
	public Offer updateOffer(Offer myOffer, float newPrice, int newQuantity){
		return this.getMoc().updateOffer(myOffer,newPrice,newQuantity);
	}
}