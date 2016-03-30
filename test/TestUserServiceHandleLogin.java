import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import app.model.Admin;
import app.model.Seller;
import app.model.User;
import app.services.UserService;
import junit.framework.Assert;

public class TestUserServiceHandleLogin {

	UserService service;
	
	@Before
	public void setUp() throws Exception {
		this.service = new UserService();
	}

	@Test
	public void wrongUserId() {
		try {
			Object user = service.handleLogIn("IdontExist", "fakePassword");
			fail("Expect handleLogin to fail ...");
		} catch(Exception e) {		
			assertTrue("Error of type Exception", e instanceof Exception);
		}
	}
	
	@Test
	public void loginAsAdmin() throws Exception {
		User user = service.handleLogIn("admin", "admin");
		assertTrue("The user is of type admin", user instanceof Admin);
	}
	
	@Test
	public void loginAsSeller() throws Exception {
		User user = service.handleLogIn("fbeiger", "mdp");
		assertTrue("The user is of type admin", user instanceof Seller);
	}

}
