package app.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import app.model.Customer;

public class CustomerJDBC extends Customer{
	
	/**
	 * Search a Customer by looking on the Table User into the DB.
	 * @param userID
	 * @throws Exception
	 */
	public CustomerJDBC(String userID){
		JdbcConnection connect = JdbcConnection.getInstance();
		connect.openConnection();
		ResultSet res = null;
		
		try{
			String query ="SELECT * FROM User where idUser ='" + userID + "' AND type = 'customer';";
			connect.executeRequest(query);
			while ((res = connect.fetchArray()) != null){
				this.setUserID(res.getString("idUser"));
				this.setPassword(res.getString("password"));
				this.setAdress(res.getString("address"));
				this.setEmail(res.getString("email"));
				this.setFirstName(res.getString("firstName"));
				this.setLastName(res.getString("lastName"));
				this.setTel(res.getString("tel"));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		connect.close();
	}
}
