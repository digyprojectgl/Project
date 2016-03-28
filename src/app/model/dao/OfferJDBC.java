package app.model.dao;

import app.model.Offer;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.model.User;
import app.model.Comment;
import app.model.Notification;

public class OfferJDBC extends Offer{

	public OfferJDBC(String userID) throws Exception{
		JdbcConnection connect = JdbcConnection.getInstance();
		connect.openConnection();
		ResultSet res = null;
		
		try{
			String query ="SELECT * FROM Offer where idUser ='" + userID + "'";
			connect.executeRequest(query);
			while ((res = connect.fetchArray()) != null){
				this.setIdOffer(res.getString("idOffer"));
				this.setQuantity(res.getInt("quantity"));
				this.setPrivacy(res.getString("privacy"));
				this.setIdUser(res.getString("idUser"));
				this.setLabelProduct(res.getString("labelProduct"));

			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		connect.close();
	}
	
	public OfferJDBC(String label,float price, int quantity ){
		JdbcConnection connect = JdbcConnection.getInstance();
		connect.openConnection();
		String insertOffer = "INSERT INTO Offer VALUES('"+quantity +"','"+ price +"','"+ null +"','"+ label +"')";
		connect.executeRequest(insertOffer);
	}
}