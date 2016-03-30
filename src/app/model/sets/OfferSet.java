package app.model.sets;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app.model.Offer;
import app.model.dao.JdbcConnection;

public class OfferSet {
	private ArrayList<Offer> offers;
	
	/**
	 * Default constructor
	 */
	public OfferSet(){
		this.offers = null;
	}
	
	/**
	 * Constructor of the OfferSet
	 * @param offers an ArrayList of Offer
	 */
	public OfferSet(ArrayList<Offer> offers){
		this.offers = offers;
	}
	
	/**
	 * @return all the offers in an OfferSet
	 * @throws Exception if return nothing or problem to connect
	 * this function get all the offers in the database
	 * No parameter required
	 */
	public OfferSet getAllOffers() throws Exception{
		JdbcConnection connect = JdbcConnection.getInstance();
		connect.openConnection();
		ResultSet res = null;
		this.setOffers(new ArrayList<Offer>());
		
		try{
			String query ="SELECT * FROM Offer";
			connect.executeRequest(query);
			while ((res = connect.fetchArray()) != null){
				Offer myOffer = new Offer();
				myOffer.setIdOffer(res.getString("idOffer"));
				myOffer.setQuantity(res.getInt("quantity"));
				myOffer.setPrice(res.getFloat("price"));
				myOffer.setPrivacy(res.getString("privacy"));
				myOffer.setIdUser(res.getString("idUser"));
				myOffer.setLabelProduct(res.getString("labelProduct"));
				this.addOffer(myOffer);
			}
		}
		catch(SQLException e){
			throw (Exception)e;
		}
		connect.close();
		return this;
	}
	
	/**
	 * 
	 * @param idUser the id of the seller who created the offer
	 * @return the offers created by this seller in an OfferSet
	 * @throws Exception when problem to connect or return nothing
	 */
	public OfferSet getOffersWithUserID(String idUser) throws Exception{
		JdbcConnection connect = JdbcConnection.getInstance();
		connect.openConnection();
		ResultSet res = null;
		this.setOffers(new ArrayList<Offer>());
		
		try{
			String query ="SELECT * FROM Offer where IdUser = '"+ idUser + "'";
			connect.executeRequest(query);
			while ((res = connect.fetchArray()) != null){
				Offer myOffer = new Offer();
				myOffer.setIdOffer(res.getString("idOffer"));
				myOffer.setQuantity(res.getInt("quantity"));
				myOffer.setPrice(res.getFloat("price"));
				myOffer.setPrivacy(res.getString("privacy"));
				myOffer.setIdUser(res.getString("idUser"));
				myOffer.setLabelProduct(res.getString("labelProduct"));
				this.addOffer(myOffer);
			}
		}
		catch(SQLException e){
			throw (Exception)e;
		}
		connect.close();
		return this;
	}
	
	/**
	 * Get the size of the OfferSet
	 * @return the size of the OfferSet as an integer
	 */
	public int count(){
		return this.getOffers().size();
	}
	
	/**
	 * Add an Offer to the OfferSet
	 * @param offer
	 */
	public void addOffer(Offer offer){
		this.getOffers().add(offer);
	}
	
	/**
	 * remove an Offer from the OfferSet
	 * @param offer
	 */
	public void removeOffer(Offer offer){
		this.getOffers().remove(offer);
	}
	
	/**
	 * get the offers
	 * @return an ArrayList of Offer
	 */
	public ArrayList<Offer> getOffers() {
		return offers;
	}

	/**
	 * Set the ArrayList of Offer
	 * @param offers an ArrayList of Offer
	 */
	public void setOffers(ArrayList<Offer> offers) {
		this.offers = offers;
	}
	
}
