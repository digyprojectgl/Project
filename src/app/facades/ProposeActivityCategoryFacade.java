package app.facades;

import app.model.ActivityCategory;
import app.services.ActivityService;

public class ProposeActivityCategoryFacade {
	private ActivityService activityService = new ActivityService();
	
	public ActivityCategory insertActivityCategory(String labelAC, String shortDescription) throws Exception{
		return this.activityService.insertActivityCategory(labelAC, shortDescription);
	}

}
