package app.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import app.model.Customer;

public class CustomerJDBC extends Customer{
	
	/**
	 * Search a Customer by looking on the Table Customer into the DB.
	 * @param userID
	 * @throws Exception
	 */
	public CustomerJDBC(String userID) throws Exception{
		JdbcConnection connect = JdbcConnection.getInstance();
		connect.openConnection();
		ResultSet res = null;
		
		try{
			String query ="SELECT * FROM Customer where idUser ='" + userID + "'";
			connect.executeRequest(query);
			while ((res = connect.fetchArray()) != null){
				this.setUserID(res.getString("idUser"));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		connect.close();
	}
}
