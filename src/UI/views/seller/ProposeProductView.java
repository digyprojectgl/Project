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
		return "main";
	}

	@Override
	public void render(Container contentPane) {
		JPanel flow = new JPanel();
		
		JPanel all = new JPanel();
		
		textField = new JTextField();
		
		all.add(textField);
		
		
		textField_1 = new JTextField();
		
		all.add(textField_1);
		
		
		JList<ProductCategory> list = new JList<ProductCategory>();
		
		all.add(list);
		
		JButton btnSubmit = new JButton("Submit");
		
		all.add(btnSubmit);
		
		JLabel lblNewProduct = new JLabel("New Product");
		
		all.add(lblNewProduct);
		
		JLabel lblLabel = new JLabel("Label");
		
		all.add(lblLabel);
		
		JLabel lblDescription = new JLabel("Description");
		
		all.add(lblDescription);
		
		JLabel lblCategory = new JLabel("Category");
		
		all.add(lblCategory);
		JPanel totalPanel = new JPanel(new GridLayout(2,0));	
		
		contentPane.add(all);
		
		/**
		 * //TODO
		 * Ajouter les action Listener
		 * Ajouter les fonctions d'appel au controller
		 * Ajouter les fonctions display
		 */
	}	
}
