package app.model.dao;
import app.model.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import app.model.Product;

/**
 * Class in charge of linking the model to the database.
 * No database provide for the moment.
 * @author shui
 *
 */
public class ProductProposedJDBC extends Product {
	
	/**
	 * Static method.
	 * No database yet.
	 * create new product proposed(not valid)
	 */
	public ProductProposedJDBC(String label, String description) throws Exception{
		super(label, description, new ProductCategory(""));
	        JdbcConnection connection = JdbcConnection.getInstance();
	        connection.openConnection();
		/**
		 * @todo create nouveau produit
		 */
		connection.close();
	}
}
