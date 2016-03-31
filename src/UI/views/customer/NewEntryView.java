package UI.views.customer;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import UI.controllers.CustomerEntryController;
import UI.controllers.HomeViewController;
import UI.core.ViewInterface;
import app.model.Entry;

public class NewEntryView implements ViewInterface {
	
	CustomerEntryController controller;
	ArrayList<Entry> entries;
	public NewEntryView(CustomerEntryController customerEntryController, ArrayList<Entry> entries) {
		this.controller = customerEntryController;
		this.entries = entries;
	}
	@Override
	public String getLayout() {
		// TODO Auto-generated method stub
		return "main";
	}

	@Override
	public void render(Container contentPane) {
		JPanel container = new JPanel(new BorderLayout());
		JPanel form = new JPanel(new FlowLayout());
		JLabel label = new JLabel("Nouvel entrée: ");		//Label "User ID"
		final JTextField input = new JTextField(10);	//Text Field dans lequel le user va entrer son id
		JButton submit = new JButton("Insérer");
		form.add(label);
		form.add(input);
		form.add(submit);
		container.add(new JLabel("votre journal",SwingConstants.CENTER), BorderLayout.NORTH);
		container.add(form, BorderLayout.CENTER);
		container.add(this.renderEntryList(), BorderLayout.SOUTH);
		contentPane.add(container);
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.addEntry(input.getText());
			}
			
			
		});
	}
	
	public JPanel renderEntryList() {
		Box grid = Box.createVerticalBox();
		JPanel container = new JPanel();
		for(Entry entry: this.entries) {
			JPanel row = new JPanel(new FlowLayout());
			JButton removeButton = new JButton("X");
			removeButton.addActionListener(new Remove(this.controller, entry));
			row.add(new JLabel(entry.getCreatedAt().toString()));
			row.add(new JLabel(entry.getText()));
			row.add(removeButton);
			grid.add(row);
		}
		container.add(grid);
		return container;
		
	}
	
	class Remove implements ActionListener {

		private Entry entry;
		private CustomerEntryController controller;
		public Remove(CustomerEntryController controller, Entry entry) {
			this.entry = entry;
			this.controller = controller;
		}
		public void actionPerformed(ActionEvent e) {
			controller.removeEntry(entry);
		}
		
	}
	public ActionListener remove(Entry entry) {
		return null;
		
	}

}
