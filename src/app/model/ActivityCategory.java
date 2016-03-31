package app.model;

/**
 * Created by Arthur on 26/02/2016.
 */
public class ActivityCategory {
    private String labelCategoryActivity;
    private String shortDescription;
    private String detailedDescription;
    private String is_validated ;
    private ActivityCategory parentCategory = null;
    
    public ActivityCategory(){
    	this.labelCategoryActivity = null;
    	this.shortDescription = null;
    	this.detailedDescription = null;
    	this.parentCategory = null;
    }
    
    public ActivityCategory(String labelCat, String shortDescr, String detailedDescr, ActivityCategory parent){
    	this.labelCategoryActivity = labelCat;
    	this.shortDescription = shortDescr;
    	this.detailedDescription = detailedDescr;
    	this.parentCategory = parent;
    }
	
    public String getLabelCategoryActivity() {
		return labelCategoryActivity;
	}
	public void setLabelCategoryActivity(String labelCategoryActivity) {
		this.labelCategoryActivity = labelCategoryActivity;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getDetailedDescription() {
		return detailedDescription;
	}
	public void setDetailedDescription(String detailedDescription) {
		this.detailedDescription = detailedDescription;
	}
	public ActivityCategory getParentCategory() {
		return parentCategory;
	}
	public void setParentCategory(ActivityCategory parentCategory) {
		this.parentCategory = parentCategory;
	}

	public String getIs_validated() {
		return is_validated;
	}

	public void setIs_validated(String is_validated) {
		this.is_validated = is_validated;
	}
    
    
}
