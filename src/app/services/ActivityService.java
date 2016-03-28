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
		try{
			ActivityCategorySet mySet = this.getSetFactory().createActivityCategorySet();
			return mySet.getAllActivityCategoryFalse();
		}
		catch(Exception e){
			throw new Exception("Error when getting data.");
		}
	}
	
	/**
	 * Call the same-name method in the ActivityCategoryJDBC class. 
	 * @param myCategory
	 * @throws Exception
	 */
	public ActivityCategory validateCategory(ActivityCategory myCategory) throws Exception{
		ActivityCategoryJDBC categoryJDBC = this.getCategoryFactory().createActivityCategory(myCategory.getLabelCategoryActivity());
		try{
			categoryJDBC.validateCategory();
			return categoryJDBC;
		}
		catch(Exception e){
			throw new Exception("Error when validating activity category.");
		}
	}
	
	/**
	 * Call the same-name method in the ActivityCategory class.
	 * @param myCategory
	 * @throws Exception
	 */
	public void deleteCategory(ActivityCategory myCategory) throws Exception{
		ActivityCategoryJDBC categoryJDBC = this.getCategoryFactory().createActivityCategory(myCategory.getLabelCategoryActivity());
		try{
			categoryJDBC.deleteCategory();
		}
		catch(Exception e){
			throw new Exception("Error when deleting activity category.");
		}
		
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
