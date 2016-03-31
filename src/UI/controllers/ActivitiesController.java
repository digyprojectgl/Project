package UI.controllers;

import java.util.ArrayList;

import UI.core.RootController;
import UI.views.customer.ActivitiesView;
import UI.views.customer.NewEntryView;
import app.facades.ActivityFacade;
import app.facades.EntryFacade;
import app.model.Activity;
import app.model.Customer;
import app.model.Entry;

public class ActivitiesController extends RootController {
	private ActivityFacade activityFacade;
	
	public ActivitiesController() {
		activityFacade = new ActivityFacade();
		try {
			ArrayList<Activity> activities = this.fetchActivities();
			ActivitiesView view = new ActivitiesView(this, activities);
			this.render(view);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public ArrayList<Activity> fetchActivities() throws Exception {
		return activityFacade.getAllActivities();
	}



	public void subscribeToActivity(Activity activity) {
		// TODO Auto-generated method stub
		
	}
}
