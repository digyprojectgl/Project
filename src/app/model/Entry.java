package app.model;

import java.util.Date;

/**
 * Created by Arthur on 26/02/2016.
 */
public class Entry {
	private Integer idEntry;
    private String nameEntry;
    private Date createdAt;
    private String option;
    private boolean visibleEntry;
    private Customer targetProfile;

    
    public void editEntry(String name, String option) {
    }
    
    public Integer getId() {
    	return this.idEntry;
    }
    
    public Entry setId(Integer id) {
    	this.idEntry = id;
    	return this;
    }
    
    public Entry setText(String text) {
    	this.nameEntry = text;
    	return this;
    }
    
    public Entry setTargetProfile(Customer customer) {
    	this.targetProfile = customer;
    	return this;
    }
    
    public Customer getTargetProfile() {
    	return this.targetProfile;
    }
    
    public String getText() {
    	return this.nameEntry;
    }
    public Date getCreatedAt() {
    	return this.createdAt;
    }
    public Entry setCreatedAt(Date date) {
    	this.createdAt = date;
    	return this;
    }
}
