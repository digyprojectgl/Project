package app.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	/**
	 * Static method.
	 * No database yet.
	 * Find a user by his userID. 
	 * Throws an Exception if not found.
	 * @param userID
	 * @return User
	 * @throws Exception
	 */
	public UserJDBC(String userID) throws Exception{
		JdbcConnection connect = new JdbcConnection();
		connect.openConnection();
		ResultSet res = null;
		
		try{
			String query ="SELECT * FROM User where login ='" + userID + "'";
			connect.executeRequest(query);
			while ((res = connect.fetchArray()) != null){
				this.setUserID(res.getString("login"));
				this.setPassword(res.getString("mdp"));

			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		connect.close();
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
