package app.model.dao;
/**
 * @author shui
 */

import java.sql.ResultSet;

import app.model.Product;
import app.model.ProductCategory;
import app.model.ProductList;

public class ProductProposedListJDBC extends ProductList{
	
    public ProductProposedListJDBC(){
    	super();
    }
    
    /**
     * Returns a list of all the ProductProposed in the attribute propostionList.
     * @throws Exception 
     */
    public ProductList getPropositionList() throws Exception{
    	JdbcConnection connection = JdbcConnection.getInstance();
        connection.openConnection();
        ResultSet res = null;
        String query = "SELECT * FROM Product WHERE status = 'false'";
        ProductList list = new ProductList();
        try{
        	connection.executeRequest(query);
        	res = connection.executeQuery(query);
        	res.beforeFirst();
        	while (res.next()) {
        		list.productList.add(new Product(res.getString("labelProduct"), res.getString("description"), new ProductCategory(res.getString("labelPC")),res.getString ("status")));
        	}
        }
        catch(Exception e){
            throw e;
        }
        connection.close();
        return list;
        
    }
}
