package app.model.dao;
/**
 * @author shui
 */

import java.sql.ResultSet;
import app.model.ProductList;

public class ProductProposedListJDBC extends ProductList{
	
    public ProductProposedListJDBC(){
    	super();
    }
    
    /**
     * Returns a list of all the ProductProposed in the attribute propostionList.
     */
    public Object getPropositionList(){
    	JdbcConnection connection = JdbcConnection.getInstance();
        connection.openConnection();
        ResultSet res;
        String query = "SELECT * FROM ProductProposed";
        connection.executeRequest(query);
        res = connection.fetchArray();
        connection.close();
        return res;  /**@todo not sure*/
    }
}
