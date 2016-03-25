package app.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import app.model.Comment;
import app.model.Notification;
import app.model.Seller;
import app.model.User;

public class SellerJDBC extends Seller{
	
	public SellerJDBC(String userID){
		JdbcConnection connect = JdbcConnection.getInstance();
		connect.openConnection();
		ResultSet res = null;
		
		try{
			String query ="SELECT * FROM User where idUser ='" + userID + "' AND type = 'seller';";
			connect.executeRequest(query);
			while ((res = connect.fetchArray()) != null){
				this.setUserID(res.getString("idUser"));
				this.setPassword(res.getString("password"));
				this.setAdress(res.getString("address"));
				this.setTel(res.getString("tel"));
				this.setFirstName("firstName");
				this.setLastName(res.getString("lastName"));
				this.setEmail(res.getString("email"));
				this.setProfil(res.getString("profil"));
				this.setSiret(res.getString("siret"));
				this.setWebAddress(res.getString("webaddress"));
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
