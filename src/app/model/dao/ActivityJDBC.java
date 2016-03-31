package app.model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import app.model.Activity;
import app.model.ActivityCategory;
import app.model.Customer;
import app.model.Entry;

public class ActivityJDBC extends Activity{
	public static ArrayList<Activity> getAllActivities() throws Exception {
		String query ="SELECT * FROM Activity a, ActivityCategory c WHERE a.labelAC = c.labelAC";
		return ActivityJDBC.fetchActvities(query);
	}

	public static ArrayList<Activity> getCustomerActivities(Customer customer) throws Exception {
		String query = "SELECT * FROM Activity a, ActivityCategory c, USER_ACTIVITY ua"
					  +"WHERE a.labelAC = c.labelAC"
					  +"AND ua.idActivity = a.idActivity"
					  +"AND ua.idUser = u.idUser"
					  +"AND ua.idUser = '"+customer.getUserID()+"'";
		
		return ActivityJDBC.fetchActvities(query);
	}
	
	private static ArrayList<Activity> fetchActvities(String query) throws Exception {
		ArrayList<Activity> activities = new ArrayList<Activity>();
		JdbcConnection connect = JdbcConnection.getInstance();
		connect.openConnection();
		ResultSet res = null;
		connect.executeRequest(query);
		while ((res = connect.fetchArray()) != null){
			Activity myActivity = new Activity();
			ActivityCategory myActivityCategory = new ActivityCategory(
					res.getString("c.labelAC"),
					res.getString("c.shortDescription"),
					res.getString("c.detailDescription"),
					null
			);
			myActivity.setId(res.getInt("a.idActivity"));
			myActivity.setDescription(res.getString("a.description"));
			myActivity.setName(res.getString("a.name"));
			myActivity.setPlace(res.getString("a.place"));
			myActivity.setCategory(myActivityCategory);
			activities.add(myActivity);
		}
		return activities;
	}
}
