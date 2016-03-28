package UI.controllers;

import UI.core.RootController;
import UI.views.customer.ProposeCategoryView;

public class ProposeCategoryController extends RootController{

	public ProposeCategoryController(){
		this.render(new ProposeCategoryView(this));
	}
	
	public void back(){
		this.goTo("home");
	}
	
}
