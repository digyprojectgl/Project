package app.model;


public class Offer {
    public String idOffer;
    public int quantity;
    public float price;
    public String privacy;
    public String idUser;
    public String labelProduct;
    
    public Offer(){
    	idOffer = null;
    	quantity = 0;
    	price = 0;
        privacy = null;
        idUser = null;
        labelProduct= null;
    }


	public Offer(String idOffer, int quantity, float price, String privacy, String idUser, String labelProduct){
    	this.idOffer = idOffer;
    	this.quantity = quantity;
    	this.price = price;
    	this.privacy = privacy;
    	this.idUser = idUser;
    	this.labelProduct = labelProduct;
    }
    
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
