package app.model;


public class Offer {
    public String idOffer;
    public int quantity;
    public float price;
    public String privacy;
    public String idUser;
    public String labelProduct;
    
    /**
     * Default Constructor
     */
    public Offer(){
    	idOffer = null;
    	quantity = 0;
    	price = 0;
        privacy = null;
        idUser = null;
        labelProduct= null;
    }

    /**
     * Constructor with parameters
     * @param idOffer the Id of the Offer
     * @param quantity the quantity of Product in the Offer
     * @param price The price of the Offer
     * @param privacy The privacy of the Offer (set on null or the UserId of a customer)
     * @param idUser The id of the Seller who created the Offer
     * @param labelProduct The name of the Product
     */
	public Offer(String idOffer, int quantity, float price, String privacy, String idUser, String labelProduct){
    	this.idOffer = idOffer;
    	this.quantity = quantity;
    	this.price = price;
    	this.privacy = privacy;
    	this.idUser = idUser;
    	this.labelProduct = labelProduct;
    }
    
	/**
	 * Constructor with parameters
	 * @param labelProduct The name of the Product
	 * @param price The price of the Offer
	 * @param quantity The quantity of Product in the Offer
	 */
    public Offer(String labelProduct, float price, int quantity){
    	this.labelProduct = labelProduct;
    	this.price = price;
    	this.quantity = quantity;
    }

	public String getIdOffer() {
		return idOffer;
	}

	public void setIdOffer(String idOffer) {
		this.idOffer = idOffer;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getPrivacy() {
		return privacy;
	}

	public void setPrivacy(String privacy) {
		this.privacy = privacy;
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
