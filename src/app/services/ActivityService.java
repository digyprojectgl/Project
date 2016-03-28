package app.services;

import app.factory.ActivityCategoryJDBCFactory;
import app.factory.ActivityCategorySetFactory;
import app.model.ActivityCategory;
import app.model.dao.ActivityCategoryJDBC;
import app.model.sets.ActivityCategorySet;

public class ActivityService {
	private ActivityCategoryJDBCFactory categoryFactory = new ActivityCategoryJDBCFactory();
	private ActivityCategorySetFactory setFactory = new ActivityCategorySetFactory();
	
	/**
	 * Call the same-name method in the ActivityCategorySet class. 
	 * @return ActivityCategorySet
	 * @throws Exception
	 */
	public ActivityCategorySet getAllActivityCategoryFalse() throws Exception{
		ActivityCategorySet mySet = this.getSetFactory().createActivityCategorySet();
		return mySet.getAllActivityCategoryFalse();
	}
	
	/**
	 * Call the same-name method in the ActivityCategoryJDBC class. 
	 * @param myCategory
	 * @throws Exception
	 */
	public ActivityCategory validateCategory(ActivityCategory myCategory) throws Exception{
		ActivityCategoryJDBC categoryJDBC = this.getCategoryFactory().createActivityCategory(myCategory.getLabelCategoryActivity());
		categoryJDBC.validateCategory();
		return categoryJDBC;
	}
	
	/**
	 * Call the same-name method in the ActivityCategory class.
	 * @param myCategory
	 * @throws Exception
	 */
	public void deleteCategory(ActivityCategory myCategory) throws Exception{
		ActivityCategoryJDBC categoryJDBC = this.getCategoryFactory().createActivityCategory(myCategory.getLabelCategoryActivity());
		categoryJDBC.deleteCategory();
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
