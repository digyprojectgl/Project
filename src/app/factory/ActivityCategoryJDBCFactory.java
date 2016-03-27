package app.factory;

import app.model.dao.ActivityCategoryJDBC;

public class ActivityCategoryJDBCFactory {

	public ActivityCategoryJDBC createActivityCategory(){
		return new ActivityCategoryJDBC();
	}
	
	public ActivityCategoryJDBC createActivityCategory(String labelAC) throws Exception{
		return new ActivityCategoryJDBC(labelAC);
	}
	
}
