package app.services;

import java.util.ArrayList;
import java.util.HashMap;

import app.factory.OfferFactory;
import app.model.Product;
import app.model.dao.ProductListJDBC;

public class OfferService {

	OfferFactory of = new OfferFactory();
	
	
	public void createOffer(String id, Product prod, float prix, int qte) throws Exception {

		of.createOffer(id,prod, prix, qte);
	}
	
	public ArrayList<Product> getProducts() throws Exception{
		return new ProductListJDBC(new HashMap<String, String>()).productList;
	}
	
}
