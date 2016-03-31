package app.facades;

import java.util.ArrayList;

import app.model.Activity;
import app.model.Customer;
import app.services.ActivityService;

public class ActivityFacade {
	public ArrayList<Activity> getAllActivities() throws Exception {
		return ActivityService.getAllActivities();
	}
	
	public ArrayList<Activity> getCustomerActiviy(Customer customer) throws Exception {
		return ActivityService.getCustomerActivity(customer);
	}
	
	public void subscribeToActivity(Activity activity, Customer customer) {
		ActivityService.subscribeToActivity(activity, customer);
	}
}
