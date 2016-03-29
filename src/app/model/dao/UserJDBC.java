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
				this.setAdress(res.getString("address"));
				this.setTel(res.getString("tel"));
				this.setFirstName(res.getString("firstName"));
				this.setLastName(res.getString("lastName"));
				this.setEmail(res.getString("email"));
				this.setType(res.getString("type"));
			}
		}
		catch(SQLException e){
			throw (Exception)e;
		}
		connect.close();
	}
	
	public UserJDBC(){
		super();
	}
	
	/**
	 * Insert the user into the DB.
	 * @throws Exception
	 */
	public void insertCustomer() throws Exception{
		JdbcConnection connect = JdbcConnection.getInstance();
		connect.openConnection();
		//DB Structure : userID, password, firstName, lastName, address, tel, email, type, siret, webaddress 
		String insertUser = "INSERT INTO User VALUES(idUser ='"+this.getUserID() +"',password = '"+ this.getPassword() +"', firstName ='"+ this.getFirstName() + "', lastName ='" 
				+ this.getLastName() +"', address ='"+ this.getAdress() +"', tel = '"+ this.getTel() +"', email = '"
				+ this.getEmail() + "','customer' , '" + null + "' , '" + null + "')";
		connect.executeRequest(insertUser);
		connect.close();
	}
	
	
	/**
	 * Update the user into the DB.
	 * @throws Exception 
	 */
	public void updateUser() throws Exception{
		JdbcConnection connect = JdbcConnection.getInstance();
		connect.openConnection();
		//DB Structure : userID, password, firstName, lastName, address, tel, email, type, siret, webaddress 
		String updateUser = "UPDATE User "
				+ "SET password = '"+ this.getPassword() +"', firstName ='"+ this.getFirstName() + "', lastName ='" 
				+ this.getLastName() +"', address ='"+ this.getAdress() +"', tel = '"+ this.getTel() +"', email = '"
				+ this.getEmail() + "' WHERE idUser = '" + this.getUserID() + "';";
		connect.executeRequest(updateUser);
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
