package app.facades;

import app.model.ActivityCategory;
import app.model.sets.ActivityCategorySet;
import app.services.ActivityService;

public class ManageActivityCategoryFacade {
	private ActivityService activityService = new ActivityService();
	
	public ActivityCategorySet getAllActivitesCategoryFalse() throws Exception{
		return this.activityService.getAllActivityCategoryFalse();
	}
	
	public ActivityCategory validateCategory(ActivityCategory myCategory) throws Exception{
		return this.activityService.validateCategory(myCategory);
	}
	
	public void deleteCategory(ActivityCategory myCategory) throws Exception{
		this.activityService.deleteCategory(myCategory);
	}
	
}
