package UI.controllers;

import java.util.ArrayList;
import UI.core.RootController;
import UI.views.ManageActivityCategoryView;
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

	public ManageActivityCategoryFacade getManageActivityCategoryFacade() {
		return manageActivityCategoryFacade;
	}

	public void setManageActivityCategoryFacade(ManageActivityCategoryFacade manageActivityCategoryFacade) {
		this.manageActivityCategoryFacade = manageActivityCategoryFacade;
	}
}
