package app.model.dao;

import app.model.Offer;
import java.sql.ResultSet;
import java.sql.SQLException;


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
				this.setPrice(res.getFloat("price"));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		connect.close();
	}
	
	public OfferJDBC(String idUser,String label, float price, int quantity ) throws Exception{
		JdbcConnection connect = JdbcConnection.getInstance();
		connect.openConnection();
		String insertOffer = "INSERT INTO Offer (idUser, labelProduct, quantity, price) VALUES('"+ idUser +"','"+label +"','"+ quantity +"','"+ price +"')";
		connect.executeRequest(insertOffer);
	}

	public OfferJDBC(Offer myOffer) throws Exception {
		JdbcConnection connect = JdbcConnection.getInstance();
		connect.openConnection();
		String deleteOffer = "DELETE FROM Offer WHERE idOffer = "+ myOffer.getIdOffer();
		connect.executeRequest(deleteOffer);
	}

	public OfferJDBC(Offer myOffer, float newPrice, int newQuantity) throws Exception {
		JdbcConnection connect = JdbcConnection.getInstance();
		connect.openConnection();
		String updateOffer = "UPDATE Offer SET quantity = '"+newQuantity+"', price = '"+newPrice+"' WHERE idOffer = "+ myOffer.getIdOffer();
		connect.executeRequest(updateOffer);	}
}