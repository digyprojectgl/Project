package app.facades;

import app.model.sets.ActivityCategorySet;
import app.services.ActivityService;

public class ManageActivityCategoryFacade {
	private ActivityService activityService = new ActivityService();
	
	public ActivityCategorySet getAllActivitesCategoryFalse() throws Exception{
		return this.activityService.getAllActivityCategoryFalse();
	}
	
}
