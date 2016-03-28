package app.services;

import app.factory.ActivityCategoryJDBCFactory;
import app.factory.ActivityCategorySetFactory;
import app.model.sets.ActivityCategorySet;

public class ActivityService {
	private ActivityCategoryJDBCFactory categoryFactory = new ActivityCategoryJDBCFactory();
	private ActivityCategorySetFactory setFactory = new ActivityCategorySetFactory();
	
	public ActivityCategorySet getAllActivityCategoryFalse() throws Exception{
		ActivityCategorySet mySet = this.getSetFactory().createActivityCategorySet();
		return mySet.getAllActivityCategoryFalse();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public ActivityCategoryJDBCFactory getCategoryFactory() {
		return categoryFactory;
	}
	public void setCategoryFactory(ActivityCategoryJDBCFactory categoryFactory) {
		this.categoryFactory = categoryFactory;
	}
	public ActivityCategorySetFactory getSetFactory() {
		return setFactory;
	}
	public void setSetFactory(ActivityCategorySetFactory setFactory) {
		this.setFactory = setFactory;
	}
	
	
}
