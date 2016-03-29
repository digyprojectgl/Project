package app.model.sets;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app.model.Offer;
import app.model.dao.JdbcConnection;

public class OfferSet {
	private ArrayList<Offer> offers;

	public OfferSet(){
		this.offers = null;
	}
	
	public OfferSet(ArrayList<Offer> offers){
		this.offers = offers;
	}
	
	
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
				myOffer.setPrice(res.getFloat("Privacy"));
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
				myOffer.setPrice(res.getFloat("Privacy"));
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
	
	
	public int count(){
		return this.getOffers().size();
	}
	
	public void addOffer(Offer offer){
		this.getOffers().add(offer);
	}
	
	public void removeOffer(Offer offer){
		this.getOffers().remove(offer);
	}
	
	public ArrayList<Offer> getOffers() {
		return offers;
	}

	public void setOffers(ArrayList<Offer> offer) {
		this.offers = offers;
	}
	
	// tf
	
}
