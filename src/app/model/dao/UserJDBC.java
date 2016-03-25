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
	 * 
	 * Find a user by his userID. 
	 * Throws an Exception if not found.
	 * @param userID
	 * @return User
	 * @throws Exception
	 */
	public UserJDBC(String userID) throws Exception{
		JdbcConnection connect = JdbcConnection.getInstance();
		connect.openConnection();
		ResultSet res = null;
		
		try{
			String query ="SELECT * FROM User where idUser ='" + userID + "'";
			connect.executeRequest(query);
			while ((res = connect.fetchArray()) != null){
				this.setUserID(res.getString("idUser"));
				this.setPassword(res.getString("password"));

			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		connect.close();
	}
	
	public UserJDBC(String firstName, String lastName, String userID, String email, String phoneNumber, String address, String password) throws Exception{
		JdbcConnection connect = JdbcConnection.getInstance();
		connect.openConnection();
		String insertUser = "INSERT INTO User VALUES('"+userID +"','"+ password +"','"+ firstName +"','"+ address +"','"+ phoneNumber +"','"+ email +"')";
		connect.executeRequest(insertUser);
		String insertCustomer = "INSERT INTO Customer VALUES('" + userID + "')";
		connect.executeRequest(insertCustomer);
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
