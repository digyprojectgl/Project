package UI.views.customer;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import UI.controllers.ActivitiesController;
import UI.controllers.CustomerEntryController;
import UI.core.ViewInterface;
import UI.views.customer.NewEntryView.Remove;
import app.model.Activity;
import app.model.Entry;

public class ActivitiesView implements ViewInterface {
	ActivitiesController controller;
	private ArrayList<Activity> activities;
	
	public ActivitiesView(ActivitiesController customerEntryController, ArrayList<Activity> activities) {
		this.controller = customerEntryController;
		this.activities = activities;
	}
	@Override
	public String getLayout() {
		// TODO Auto-generated method stub
		return "main";
	}

	@Override
	public void render(Container contentPane) {
		JPanel container = new JPanel(new BorderLayout());
		container.add(new JLabel("Activités",SwingConstants.CENTER), BorderLayout.NORTH);
		container.add(this.renderActivityList(), BorderLayout.CENTER);
		contentPane.add(container);
	}
	
	public JPanel renderActivityList() {
		Box grid = Box.createVerticalBox();
		JPanel container = new JPanel();
		for(Activity activity: this.activities) {
			JPanel row = new JPanel(new FlowLayout());
			JButton subscribeButton = new JButton("S'inscrire");
			subscribeButton.addActionListener(new Subscribe(this.controller, activity));
			row.add(new JLabel(activity.getName()));
			row.add(new JLabel(activity.getDescription()));
			row.add(new JLabel(activity.getCategory().getLabelCategoryActivity()));
			row.add(subscribeButton);
			grid.add(row);
		}
		container.add(grid);
		return container;
		
	}
	
	class Subscribe implements ActionListener {

		private Activity activity;
		private ActivitiesController controller;
		public Subscribe(ActivitiesController controller, Activity activity) {
			this.activity = activity;
			this.controller = controller;
		}
		public void actionPerformed(ActionEvent e) {
			controller.subscribeToActivity(this.activity);
		}
		
	}
	public ActionListener remove(Entry entry) {
		return null;
		
	}
}
