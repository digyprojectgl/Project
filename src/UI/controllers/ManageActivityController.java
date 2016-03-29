package UI.controllers;

import UI.core.RootController;
import UI.views.admin.ManageActivityCategoryView;
import app.facades.ManageActivityCategoryFacade;
import app.model.ActivityCategory;
import app.model.sets.ActivityCategorySet;

public class ManageActivityController extends RootController{
	private ManageActivityCategoryFacade manageActivityCategoryFacade = new ManageActivityCategoryFacade();
	
	public ManageActivityController(){
		this.render(new ManageActivityCategoryView(this, this.getAllActivitiesCategoryFalse()));
	}
	
	private ActivityCategorySet getAllActivitiesCategoryFalse(){
		try{
			return this.getManageActivityCategoryFacade().getAllActivitesCategoryFalse();	
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	
	public void validateCategory(ActivityCategory myCategory){
		try {
			ActivityCategory validCategory = this.getManageActivityCategoryFacade().validateCategory(myCategory);
			ManageActivityCategoryView myView = new ManageActivityCategoryView(this, this.getAllActivitiesCategoryFalse());
			this.render(myView);
			myView.displayMessage("The Activity category: " + validCategory.getLabelCategoryActivity() + " is validated." );
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ManageActivityCategoryView myView = new ManageActivityCategoryView(this, this.getAllActivitiesCategoryFalse());
			this.render(myView);
			myView.displayError(e.getMessage());
			
		}
	}
	
	public void deleteCategory(ActivityCategory myCategory){
		try{
			this.getManageActivityCategoryFacade().deleteCategory(myCategory);
			ManageActivityCategoryView myView = new ManageActivityCategoryView(this, this.getAllActivitiesCategoryFalse());
			this.render(myView);
			myView.displayMessage("The Activity category: " + myCategory.getLabelCategoryActivity() + " is deleted.");
		}
		catch(Exception e){
			ManageActivityCategoryView myView = new ManageActivityCategoryView(this, this.getAllActivitiesCategoryFalse());
			this.render(myView);
			myView.displayError(e.getMessage());
		}
		
	}
	
	public ManageActivityCategoryFacade getManageActivityCategoryFacade() {
		return manageActivityCategoryFacade;
	}

	public void setManageActivityCategoryFacade(ManageActivityCategoryFacade manageActivityCategoryFacade) {
		this.manageActivityCategoryFacade = manageActivityCategoryFacade;
	}
}
