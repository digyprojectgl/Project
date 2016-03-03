package app.model.dao;

import app.model.Comment;
import app.model.Notification;
import app.model.User;

/**
 * Class in charge of linking the model to the database.
 * No database provide for the moment.
 * @author francois.beiger
 *
 */
public class UserJDBC extends User {
	
	UserJDBC(){
		super();
	}
	
	/**
	 * Static method.
	 * No database yet.
	 * Find a user by his userID. 
	 * Throws an Exception if not found.
	 * @param userID
	 * @return User
	 * @throws Exception
	 */
	public static User findUser(String userID) throws Exception{
		User myUser = new UserJDBC();
		myUser.setUserID("user");
		myUser.setPassword("mdp");
		if(myUser.getUserID().equals(userID)){
			return myUser;
		}
		else{
			throw new Exception("User not found !");
		}
	}
	
	@Override
	public Comment postComment(User from, String message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteComment(Comment comment) {
		// TODO Auto-generated method stub

	}

	@Override
	public Notification notify(String content) {
		// TODO Auto-generated method stub
		return null;
	}

}
