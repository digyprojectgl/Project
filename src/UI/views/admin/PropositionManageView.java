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

public class PropositionManageView implements ViewInterface {
	private JPanel all; 

	PropositionManageController propositionManageController;

	public PropositionManageView(PropositionManageController propositionManageController) {
		this.propositionManageController = propositionManageController;
	}

	@Override
	public String getLayout() {
		return "main";
	}

	@Override
	public void render(Container contentPane) {

		ProductList list = null;
		try {
			list = this.propositionManageController.ListProposition();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		all = new JPanel();

		/**
		 * if there are propositions to handle, show the list
		 * if not, show a message "no proposition"
		 */
		if(!list.isEmpty()){

			JPanel listPanel = new JPanel(new GridLayout());
			JPanel acceptPanel = new JPanel(new GridLayout());
			JPanel refusePanel = new JPanel(new GridLayout());

			for(final Product p: list.productList){
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
						all.updateUI();
					}});
				refusePanel.add(refuseCell);
			}

			all.add(listPanel);
			all.add(acceptPanel);
			all.add(refusePanel);
			
			contentPane.add(all);
		}
		else{
			JLabel noproposition = new JLabel("no Proposition");
			contentPane.add(noproposition);
		}
		
	}

	public JPanel creatCell(Component comp) {
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
