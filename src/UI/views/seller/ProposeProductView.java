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
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import UI.controllers.ProposeProductController;
import UI.core.ViewInterface;
import app.model.ProductCategory;

public class ProposeProductView implements ViewInterface {
	ProposeProductController proposeProductController;

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
		
		JTextField name = new JTextField(10);
		JComboBox myCombo = new JComboBox();
		JTextArea descr = new JTextArea();
		
		gridFields.add(name);
		gridFields.add(myCombo);
		gridFields.add(descr);
		
		gridAll.add(gridLabel);
		gridAll.add(gridFields);
		
		JButton back = new JButton("< Back");
		JButton submit = new JButton("Submit");
		
		back.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				back();
			}
		});
		
		submit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				newProduct();
			}
		});
		
		buttons.add(back);
		buttons.add(submit);
		
		all.add(title, BorderLayout.NORTH);
		all.add(gridAll, BorderLayout.CENTER);
		all.add(buttons, BorderLayout.SOUTH);
		
		contentPane.add(all);
		
		/**
		 * //TODO
		 * Ajouter les action Listener
		 * Ajouter les fonctions d'appel au controller
		 * Ajouter les fonctions display
		 */
	}	
	
	private void back(){
		this.proposeProductController.goTo("productList");
	}
	
	private void newProduct(){
		
	}
}
