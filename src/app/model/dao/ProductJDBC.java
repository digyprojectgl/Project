package app.model.dao;
/**
 * @author shui
 */

import app.model.Product;
import app.model.ProductCategory;

public class ProductJDBC extends Product{		
		
		public ProductJDBC(String label, String description, ProductCategory category){
			super(label, description, category);
		}
		
		/**
		 * Insert the Product into the DB.
		 * @throws Exception
		 */
		public void addProduct() throws Exception{
			JdbcConnection connect = JdbcConnection.getInstance();
			connect.openConnection();
			//DB Structure : label,description,category
			String insertProduct = "INSERT INTO Product VALUES('"+this.getLabel() +"','"+ this.getDescription() +"','"+ this.getCategory() +"')";
			connect.executeRequest(insertProduct);
		}
	}
