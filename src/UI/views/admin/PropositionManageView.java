package UI.views.admin;

/**
 * list of propositions of product on admin side
 * @author shui
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import UI.controllers.PropositionManageController;
import UI.core.ViewInterface;
import app.model.Product;
import app.model.ProductList;

public class PropositionManageView implements ViewInterface{
	
	PropositionManageController propositionManageController;
	
	public PropositionManageView(PropositionManageController propositionManageController){
		this.propositionManageController = propositionManageController;	
	}

	@Override
	public String getLayout() {
		// TODO Auto-generated method stub
		return "main";
	}

	@Override
	public void render(Container contentPane) {
		
		ProductList list = null;
		try {
			list = this.propositionManageController.ListProposition();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JPanel all = new JPanel();
		
		JPanel listPanel = new JPanel(new GridLayout());
		JPanel acceptPanel = new JPanel(new GridLayout());
		JPanel refusePanel = new JPanel(new GridLayout());
		
		for(Product p: list.productList){
			JLabel product = new JLabel(p.label);
			JPanel productCell = creatCell(product);
			listPanel.add(productCell);
		
			JButton acceptB = new JButton("Accept");
			JPanel acceptCell = creatCell(acceptB);
			acceptB.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					acceptProduct(p);
					
				}});
			acceptPanel.add(acceptCell);
			
			JButton refuseB =  new JButton("Refuse");
			JPanel refuseCell = creatCell(refuseB);
			refuseB.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					refuseProduct(p);
					
				}});
			refusePanel.add(refuseCell);
		}
		
		all.add(listPanel);
		all.add(acceptPanel);
		all.add(refusePanel);
	}
	
	public JPanel creatCell(Component comp){
		JPanel cell = new JPanel();
		cell.add(comp);
		return cell;
	}
	
	public void acceptProduct(Product p) {
		this.propositionManageController.AcceptProposition(p);
	}
	
	public void refuseProduct(Product p) {
		this.propositionManageController.refuseProposition(p);
	}
}
