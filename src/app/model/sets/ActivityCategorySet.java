package app.model.sets;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app.model.ActivityCategory;
import app.model.dao.JdbcConnection;

public class ActivityCategorySet {
	private ArrayList<ActivityCategory> activityCategories;

	public ActivityCategorySet(){
		this.activityCategories = null;
	}
	
	public ActivityCategorySet(ArrayList<ActivityCategory> activityCategories){
		this.activityCategories = activityCategories;
	}
	
	
	public ActivityCategorySet getAllActivityCategoryFalse() throws Exception{
		JdbcConnection connect = JdbcConnection.getInstance();
		connect.openConnection();
		ResultSet res = null;
		this.setActivityCategories(new ArrayList<ActivityCategory>());
		
		try{
			String query ="SELECT * FROM ActivityCategory where is_validate ='false'";
			connect.executeRequest(query);
			while ((res = connect.fetchArray()) != null){
				ActivityCategory myActivityCategory = new ActivityCategory();
				myActivityCategory.setLabelCategoryActivity(res.getString("labelAC"));
				myActivityCategory.setShortDescription(res.getString("shortDescription"));
				myActivityCategory.setDetailedDescription(res.getString("detailDescription"));
				this.addActivityCategory(myActivityCategory);
			}
		}
		catch(SQLException e){
			throw (Exception)e;
		}
		connect.close();
		return this;
	}
	
	public int count(){
		return this.getActivityCategories().size();
	}
	
	public void addActivityCategory(ActivityCategory activityCategory){
		this.getActivityCategories().add(activityCategory);
	}
	
	public void removeActivityCategory(ActivityCategory activityCategory){
		this.getActivityCategories().remove(activityCategory);
	}
	
	public ArrayList<ActivityCategory> getActivityCategories() {
		return activityCategories;
	}

	public void setActivityCategories(ArrayList<ActivityCategory> activityCategories) {
		this.activityCategories = activityCategories;
	}
	
	
	
}
