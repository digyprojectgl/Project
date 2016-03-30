package app.model.dao;

import app.model.Offer;
import java.sql.ResultSet;
import java.sql.SQLException;


public class OfferJDBC extends Offer{

	/**
	 * Create a connection to the database to get all the offers created by a Seller
	 * @param userID The id of the Seller who created the offers
	 * @throws Exception when problem with database
	 */
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
				this.setPrice(res.getFloat("price"));
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
	
	/**
	 * Create a connection to the database to add a new Offer
	 * @param idUser the id of the seller who created the Offer
	 * @param label the name of the product concerned by the Offer
	 * @param price the price of the offer
	 * @param quantity the quantity of products in the offer
	 * @throws Exception when problem with the database
	 */
	public OfferJDBC(String idUser,String label, float price, int quantity ) throws Exception{
		JdbcConnection connect = JdbcConnection.getInstance();
		connect.openConnection();
		String insertOffer = "INSERT INTO Offer (idUser, labelProduct, quantity, price) VALUES('"+ idUser +"','"+label +"','"+ quantity +"','"+ price +"')";
		connect.executeRequest(insertOffer);
	}
	
	/**
	 * Create a connection to the database to delete an Offer
	 * @param myOffer the Id of the offer we need to delete
	 * @throws Exception when problem with the database
	 */
	public OfferJDBC(Offer myOffer) throws Exception {
		JdbcConnection connect = JdbcConnection.getInstance();
		connect.openConnection();
		String deleteOffer = "DELETE FROM Offer WHERE idOffer = "+ myOffer.getIdOffer();
		connect.executeRequest(deleteOffer);
	}
	
	/**
	 * Create a connection to the database to update an Offer
	 * @param myOffer the Offer we need to update
	 * @param newPrice the new price of the offer
	 * @param newQuantity the new quantity of the offer
	 * @throws Exception when problem with database
	 */
	public OfferJDBC(Offer myOffer, float newPrice, int newQuantity) throws Exception {
		JdbcConnection connect = JdbcConnection.getInstance();
		connect.openConnection();
		String updateOffer = "UPDATE Offer SET quantity = '"+newQuantity+"', price = '"+newPrice+"' WHERE idOffer = "+ myOffer.getIdOffer();
		connect.executeRequest(updateOffer);	}
}