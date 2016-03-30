package app.model;

import java.util.Collection;

/**
 * Created on 20/03/2016.
 *
 * @author Arthur
 */

/**
 * update 29/03
 * add attribut status: 'true' valid by admin
 * @author shui
 */
public class Product {
    public String label;
    public String description;
    public ProductCategory category;
    public String status;

    public Product(String label, String description, ProductCategory category, String status) {
        this.label = label;
        this.description = description;
        this.category = category;
        this.status = status;
    }

    public Product() {
    }

    public  void offerProduct(Seller seller, double prix){
        /**
         * TODO complete this method
         */
    }

    public  void requestQuote(User by, int quantity, String comment){
        /**
         * TODO complete this method
         */
    }

    public  Collection<Offer> getOffers(){
        /**
         * TODO complete this method
         */
        return null;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String string) {
		this.status = string;
	}

    @Override
    public String toString() {
        return  "(" + getCategory() + ") " + getLabel();
    }
}
