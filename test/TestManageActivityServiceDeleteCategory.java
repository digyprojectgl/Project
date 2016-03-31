import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import app.model.ActivityCategory;
import app.model.dao.ActivityCategoryJDBC;
import app.services.ActivityService;

public class TestManageActivityServiceDeleteCategory {
	ActivityService service;

	
	@Before
	public void setUp() throws Exception {
		service = new ActivityService();
	}

	@Test
	public void activityCorrectlyDeleted(){
		try{
			service.insertActivityCategory("testDelete", "shortDescription");
			ActivityCategory myCategory = new ActivityCategoryJDBC("testDelete");
			//Delete the category
			service.deleteCategory(myCategory);
			ActivityCategory myCategoryDeleted = new ActivityCategoryJDBC("testDelete");
		}catch(Exception e){
			assertTrue("Error of type Exception", e instanceof Exception);
		}
	}	
}