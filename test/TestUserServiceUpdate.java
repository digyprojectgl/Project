import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import app.model.User;
import app.model.dao.UserJDBC;

/**
 * there are too many parameters in update
 * I have just tested the tel.Number 
 * @author shui
 */

import app.services.UserService;

public class TestUserServiceUpdate {
	UserService user;
	
	@Before
	public void setUp() throws Exception {
		user  = new UserService();
	}
	
	@Test
	public void testUpdatePhone() throws Exception{
		User usertest = new UserJDBC("user");
		User usermodified = user.updateUser(usertest, "firstName", "lastName", "user", "email", "phoneNumber", "address", "password", "password", null, null);
		assertTrue("usertest is updated",usermodified.getTel().equals("phoneNumber"));
	}

}
