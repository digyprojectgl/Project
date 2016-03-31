package UI.views.seller;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import UI.controllers.ProposeProductController;
import UI.core.ViewInterface;
import app.model.Product;
import app.model.ProductCategory;
import app.model.ProductCategoryList;

public class ProposeProductView implements ViewInterface {
	ProposeProductController proposeProductController;
	ProductCategoryList categorySet;
	JTextField name = new JTextField(10);
	JComboBox myCombo = new JComboBox();
	JTextArea descr = new JTextArea();

	public ProposeProductView(ProposeProductController proposeProductController, ProductCategoryList categorySet){
		this.proposeProductController = proposeProductController;	
		this.categorySet = categorySet;
	}

	@Override
	public String getLayout() {
		return "main";
	}

	@Override
	public void render(Container contentPane) {
		JPanel all = new JPanel(new BorderLayout());
		JPanel gridLabel = new JPanel(new GridLayout(3,0));
		JPanel gridFields = new JPanel(new GridLayout(3,0));
		JPanel gridAll = new JPanel(new GridLayout(1,2));
		JPanel buttons = new JPanel();
		
		JLabel title = new JLabel("New Product");
		title.setFont(new Font("Arial", Font.BOLD, 18));
	
		JLabel nameLab = new JLabel("Product Name");
		JLabel categoryLab = new JLabel("Category");
		JLabel descrLab = new JLabel("Description");
		
		gridLabel.add(nameLab);
		gridLabel.add(categoryLab);
		gridLabel.add(descrLab);
		
		
		if(this.categorySet !=null){
			this.setMyCombo(new JComboBox(this.categorySet.productCategories.toArray()));
		}
		
		gridFields.add(this.getName());
		gridFields.add(this.getMyCombo());
		gridFields.add(this.getDescr());
		
		gridAll.add(gridLabel);
		gridAll.add(gridFields);
		
		JButton back = new JButton("< Back");
		JButton submit = new JButton("Submit");
		
		back.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		
		submit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				newProduct();
			}
		});
		
		buttons.add(back);
		buttons.add(submit);
		
		all.add(title, BorderLayout.NORTH);
		all.add(gridAll, BorderLayout.CENTER);
		all.add(buttons, BorderLayout.SOUTH);
		
		contentPane.add(all);
	}	
	
	private void back(){
		this.proposeProductController.goTo("productList");
	}
	
	private void newProduct(){
		String label = this.getName().getText();
		String description = this.getDescr().getText();
		ProductCategory category = (ProductCategory) this.myCombo.getSelectedItem();
		this.getProposeProductController().proposeNewProduct(label, description, category);
	}
	
	/**
	 * Create a popUp for displaying errors. Example : Changes haven't been performed.
	 * @param e
	 */
	public void displayError(String e){
		JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Create a popup for displaying a message. Example : your registration have been made.
	 * @param m
	 */
	public void displayMessage(String m){
		JOptionPane.showMessageDialog(null, m, "Perfect !", JOptionPane.INFORMATION_MESSAGE);
	}

	public ProposeProductController getProposeProductController() {
		return proposeProductController;
	}

	public void setProposeProductController(ProposeProductController proposeProductController) {
		this.proposeProductController = proposeProductController;
	}

	public ProductCategoryList getCategorySet() {
		return categorySet;
	}

	public void setCategorySet(ProductCategoryList categorySet) {
		this.categorySet = categorySet;
	}

	public JTextField getName() {
		return name;
	}

	public void setName(JTextField name) {
		this.name = name;
	}

	public JComboBox getMyCombo() {
		return myCombo;
	}

	public void setMyCombo(JComboBox myCombo) {
		this.myCombo = myCombo;
	}

	public JTextArea getDescr() {
		return descr;
	}

	public void setDescr(JTextArea descr) {
		this.descr = descr;
	}

	/**
	 * if the proposition is done successfully, show a message
	 * @param p
	 */
	public void displaySuccess(Product p) {
		String message = "Your proposition "+p.getLabel()+" is sent to Admin";
		JOptionPane.showMessageDialog(null,message);
	}
	
	
}
