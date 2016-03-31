import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import app.model.ActivityCategory;
import app.model.dao.ActivityCategoryJDBC;
import app.services.ActivityService;

public class TestManageActivityServiceValidateCategory {
	ActivityService service;

	
	@Before
	public void setUp() throws Exception {
		service = new ActivityService();
	}

	@Test
	public void activityCorrectlyValidated() throws Exception{
		service.insertActivityCategory("testFalse", "shortDescription");
		//Get a category which isn't validated
		ActivityCategory myCategory = new ActivityCategoryJDBC("testFalse");
		//Validate the category
		service.validateCategory(myCategory);
		ActivityCategory validateCategory = new ActivityCategoryJDBC("testFalse");
		assertTrue(validateCategory.getIs_validated().equals("true"));
		service.deleteCategory(myCategory);
	}
	
}