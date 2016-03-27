package UI.views;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;


import UI.controllers.ManageActivityController;
import UI.core.ViewInterface;
import app.model.ActivityCategory;
import app.model.sets.ActivityCategorySet;

public class ManageActivityCategoryView implements ViewInterface{
	private ManageActivityController myController;
	private ActivityCategorySet categories;
	
	public ManageActivityCategoryView(ManageActivityController myController, ActivityCategorySet categories){
		this.setMyController(myController);
		this.setCategories(categories);
	}
	
	public ManageActivityCategoryView(ManageActivityController myController){
		this.setMyController(myController);
	}
	
	@Override
	public String getLayout() {
		// TODO Auto-generated method stub
		return "main";
	}

	@Override
	public void render(Container contentPane) {
		// TODO Auto-generated method stub
		int nbElem = 3;
		int c = nbElem;
		int r ;
		if(categories.count()%nbElem == 0){
			r = categories.count()/nbElem ;
		}
		else{
			r = categories.count()/nbElem + 1;
		}
		JPanel gridPanel = new JPanel(new GridLayout(r, c));
		for(ActivityCategory myCategory: categories.getActivityCategories()){
			JPanel line = new JPanel(new FlowLayout());
			JPanel columns = new JPanel(new GridLayout(4,0));
			JLabel labelAC =  new JLabel(myCategory.getLabelCategoryActivity());
			JLabel shortDescr = new JLabel(myCategory.getShortDescription());
			JButton validate = new JButton("Validate");
			JButton delete = new JButton("Delete");
			
			columns.add(labelAC);
			columns.add(shortDescr);
			columns.add(validate);
			columns.add(delete);
			line.add(columns);
			gridPanel.add(line);
			
			
		}
		JPanel all = new JPanel();
		all.add(gridPanel);
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
		JOptionPane.showMessageDialog(null, m, "Perfect !", JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	public ManageActivityController getMyController() {
		return myController;
	}

	public void setMyController(ManageActivityController myController) {
		this.myController = myController;
	}

	
	public ActivityCategorySet getCategories() {
		return categories;
	}

	
	public void setCategories(ActivityCategorySet categories) {
		this.categories = categories;
	}

}
