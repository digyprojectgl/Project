package app.model;

import java.util.Date;

public class Quote{
	
	String idQuote;
	int quantity;
	String comment;
	Date date_request;
	String idUser;
	String labelProduct;
	
	
	/**
	 * Default constructor
	 */
	public Quote() {
		
	}

	/**
	 * Constructor with parameters
	 * @param idQuote The id of the quote
	 * @param quantity The quantity of product
	 * @param comment Comments of the user
	 * @param date_request The date of the request
	 * @param idUser The id of the user
	 * @param labelProduct The label of the product
	 */
	public Quote(String idQuote, int quantity, String comment, Date date_request, String idUser, String labelProduct) {
		this.idQuote = idQuote;
		this.quantity = quantity;
		this.comment = comment;
		this.date_request = date_request;
		this.idUser = idUser;
		this.labelProduct = labelProduct;
	}

	public String getIdQuote() {
		return idQuote;
	}

	public void setIdQuote(String idQuote) {
		this.idQuote = idQuote;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDate_request() {
		return date_request;
	}

	public void setDate_request(Date date_request) {
		this.date_request = date_request;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getLabelProduct() {
		return labelProduct;
	}

	public void setLabelProduct(String labelProduct) {
		this.labelProduct = labelProduct;
	}
	
}