package UI.controllers;

import UI.core.RootController;
import UI.views.customer.ProposeCategoryView;
import app.facades.ProposeActivityCategoryFacade;
import app.model.ActivityCategory;

public class ProposeCategoryController extends RootController{
	ProposeActivityCategoryFacade myFacade = new ProposeActivityCategoryFacade();

	public ProposeCategoryController(){
		this.render(new ProposeCategoryView(this));
	}
	
	public void back(){
		this.goTo("home");
	}
	
	public void insertActivityCategory(String labelAC, String shortDescription){
		ProposeCategoryView myView = new ProposeCategoryView(this);
		this.render(myView);
		try{
			ActivityCategory myCategory = this.myFacade.insertActivityCategory(labelAC, shortDescription);
			myView.displayMessage("Your activity category: "+ myCategory.getLabelCategoryActivity() +" request have been performed !");
		}
		catch(Exception e){
			myView.displayError(e.getMessage());
		}
	}
}
