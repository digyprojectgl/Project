package UI.views.customer;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import UI.controllers.ProposeCategoryController;
import UI.core.ViewInterface;

public class ProposeCategoryView implements ViewInterface{
	ProposeCategoryController myController;
	JTextField labelField = new JTextField();
	JTextArea descrField = new JTextArea();
	

	public ProposeCategoryView(ProposeCategoryController myController){
		this.myController = myController;
	}
	
	@Override
	public String getLayout() {
		return "main";
	}

	@Override
	public void render(Container contentPane) {
		
		JLabel title = new JLabel("Enter your new activity category");
		JPanel titlePanel = new JPanel();
		titlePanel.add(title);
		title.setFont(new Font("Arial", Font.BOLD, 18));
		
		JPanel gridPanel = new JPanel(new GridLayout(0,2,1,2));
		
		JPanel labelPanel = new JPanel(new GridLayout(2,0));
		JPanel fieldPanel = new JPanel(new GridLayout(2,0));
		
		JLabel labelAC = new JLabel("Label Activity :");
		JLabel shortDescr = new JLabel("Short Description :");
		
		labelPanel.add(labelAC);
		labelPanel.add(shortDescr);
		
		fieldPanel.add(this.getLabelField());
		fieldPanel.add(this.getDescrField());
		
		gridPanel.add(labelPanel);
		gridPanel.add(fieldPanel);
		
		JPanel buttons = new JPanel();
		
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
				submit();
			}
		});
		
		
		buttons.add(back);
		buttons.add(submit);
		
		JPanel all = new JPanel(new BorderLayout());
		all.add(titlePanel, BorderLayout.NORTH);
		all.add(gridPanel, BorderLayout.CENTER);
		all.add(buttons, BorderLayout.SOUTH);
		
		contentPane.add(all);
		
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
		JOptionPane.showMessageDialog(null, m, "Great !", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Call the controller and go back to the HomeView.
	 */
	private void back(){
		this.getMyController().back();;
	}
	
	/**
	 * Submit the new category.
	 */
	private void submit(){
		String labelAC = this.getLabelField().getText();
		String shortDescription = this.getDescrField().getText();
		this.getMyController().insertActivityCategory(labelAC, shortDescription);
	}

	public JTextField getLabelField() {
		return labelField;
	}

	public void setLabelField(JTextField labelField) {
		this.labelField = labelField;
	}

	public JTextArea getDescrField() {
		return descrField;
	}

	public void setDescrField(JTextArea descrField) {
		this.descrField = descrField;
	}

	public ProposeCategoryController getMyController() {
		return myController;
	}

	public void setMyController(ProposeCategoryController myController) {
		this.myController = myController;
	}
}
