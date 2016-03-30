package app.model.dao;
/**
 * @author shui
 */

import app.model.Product;
import app.model.ProductCategory;
import java.sql.ResultSet;

/**
 * Created on 27/03/2016.
 *
 * @author Arthur
 */
public class ProductJDBC extends Product {

	/**
	 * Get the Product from the database
	 * @param label the label of the product
	 * @param category the category of the product
	 * @throws Exception
     */
    public ProductJDBC(String label, String category) throws Exception {
        JdbcConnection connection = JdbcConnection.getInstance();
        connection.openConnection();
        ResultSet res;
        connection.executeRequest("SELECT * FROM Product WHERE labelProduct='" + label + "' AND labelPC='" + category + "' AND status = 'true'");
        res = connection.fetchArray();
        res.beforeFirst();
        res.next();
        this.setLabel(label);
        this.setDescription(res.getString("description"));
        this.setCategory(new ProductCategory(category));
        connection.close();
    }
    
    public ProductJDBC(String label, String description, ProductCategory category){
		super(label, description, category, "true");
	}
}
