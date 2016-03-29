package UI.views.seller;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import UI.controllers.ProposeProductController;
import UI.core.ViewInterface;
import app.model.ProductCategory;

public class ProposeProductView implements ViewInterface {
	ProposeProductController proposeProductController;
	JTextField fieldLabel = new JTextField(15);
	JTextField fieldDescription = new JTextField(15);
	JButton submit = new JButton("Submit");	
	private JTextField textField;
	private JTextField textField_1;
	
	public ProposeProductView(ProposeProductController proposeProductController){
		this.proposeProductController = proposeProductController;	
	}

	@Override
	public String getLayout() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void render(Container contentPane) {
		JPanel all = new JPanel();
		all.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(186, 58, 183, 27);
		all.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(186, 100, 183, 88);
		all.add(textField_1);
		textField_1.setColumns(10);
		
		JList<ProductCategory> list = new JList<ProductCategory>();
		list.setBounds(186, 203, 183, 27);
		all.add(list);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(160, 245, 123, 29);
		all.add(btnSubmit);
		
		JLabel lblNewProduct = new JLabel("New Product");
		lblNewProduct.setBounds(25, 15, 123, 28);
		all.add(lblNewProduct);
		
		JLabel lblLabel = new JLabel("Label");
		lblLabel.setBounds(66, 61, 81, 21);
		all.add(lblLabel);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(67, 100, 104, 21);
		all.add(lblDescription);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(66, 204, 81, 21);
		all.add(lblCategory);
		JPanel totalPanel = new JPanel(new GridLayout(2,0));	
		
		/**
		 * //TODO
		 * Ajouter les action Listener
		 * Ajouter les fonctions d'appel au controller
		 * Ajouter les fonctions display
		 */
	}	
}
