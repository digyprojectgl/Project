import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import app.services.UserService;

/**
 * so many things so just test a part
 * @author shui
 */

public class TestUserServiceSignUpCustomer {
	UserService user;
	
	@Before
	public void setUp() throws Exception {
		user  = new UserService();
	}
	
	/**
	 * test if the UserIS is already taken
	 */
	@Test
	public void testIDExist(){
		try {
			user.signUpCustomer("firstName", "lastName", "cholo", "email", "telephone", "address", "password", "password");
			fail("Expect SignUp to fail ...");
		} catch(Exception e) {		
			assertTrue("Error of type Exception", e instanceof Exception);
		}
	}
	
	/**
	 * test if a parameter which is required is null
	 */
	@Test
	public void testIDNull(){
		try {
			user.signUpCustomer("firstName", "lastName", null, "email", "telephone", "address", "password", "password");
			fail("Expect SignUp to fail ...");
		} catch(Exception e) {		
			assertTrue("Error of type Exception", e instanceof Exception);
		}
	}
	
	@Test
	public void testEmailNull(){
		try {
			user.signUpCustomer("firstName", "lastName", "newCustomer", null, "telephone", "address", "password", "password");
			fail("Expect SignUp to fail ...");
		} catch(Exception e) {		
			assertTrue("Error of type Exception", e instanceof Exception);
		}
	}
}
