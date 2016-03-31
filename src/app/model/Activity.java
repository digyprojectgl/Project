package app.model;

import java.util.Date;

/**
 * Created by Arthur on 26/02/2016.
 */
public class Activity {
	private Integer id;
    private String nameActivity;
    private Date date;
    private String place;
    private String descriptionActivity;
    private ActivityCategory categoryActivity;

    public void addGoal(String name, String description, Date deadline, Customer customer) {
    }
    
    public Activity setId(Integer id) {
    	this.id = id;
    	return this;
    }
    
    public Integer getId() {
    	return this.id;
    }
    
    public Activity setDescription(String description) {
    	this.descriptionActivity = description;
    	return this;
    }
    
    public Activity setName(String name) {
    	this.nameActivity = name;
    	return this;
    }
    
    public Activity setPlace(String place) {
    	this.place = place;
    	return this;
    }
    
    public Activity setCategory(ActivityCategory cat) {
    	this.categoryActivity = cat;
    	return this;
    }
    
    public String getName() {
    	return this.nameActivity;
    }
    
    public String getPlace() {
    	return this.place;
    }
    
    public String getDescription() {
    	return this.descriptionActivity;
    }
    
    public ActivityCategory getCategory() {
    	return this.categoryActivity;
    }
    
}
