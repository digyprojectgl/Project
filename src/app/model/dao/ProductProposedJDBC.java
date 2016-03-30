package app.model.dao;
import app.model.*;
import app.model.Product;

/**
 * Class in charge of linking the model to the database.
 * No database provide for the moment.
 * @author shui
 *
 */
public class ProductProposedJDBC extends Product {
	public ProductProposedJDBC(String label, String description, ProductCategory category, String status) throws Exception{
		super(label, description, category, status);
		// TODO Changer le constructeur pour renvoyer un élément dans la DB.
	}

	public ProductProposedJDBC() {
		super();
	}

	/**
	 * save a new proposition of product - seller side
	 * @param status 
	 * @return 
	 * @throws Exception 
	 */
	public void addProductProposed(String label, String description, ProductCategory category) throws Exception{
		JdbcConnection connection = JdbcConnection.getInstance();
	    connection.openConnection();
		String proposeProduct = "INSERT INTO ProductProposed VALUES('"+ label +"','"+ description +"','"+ category+"','false')";
		connection.executeRequest(proposeProduct);
		connection.close();
	}
	
	public void acceptProposition(Product p){
		JdbcConnection connection = JdbcConnection.getInstance();
	    connection.openConnection();
	    String label = p.label;
	    String description = p.description;
	    String category = p.category.getLabel();
	    
	    String acceptProductProposed = "UPDATE Product SET status = 'true' WHERE labelProduct = '"+ label +"'AND description = '"+ description +"'AND labelPC = '"+ category +"'AND status = 'false')";
		try {
			connection.executeRequest(acceptProductProposed);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection.close();
	}
	
	
	/**
	 * delete a proposition of product when it's refused - admin side
	 * @throws Exception 
	 */
	public void deleteProductProposed(Product p) throws Exception{
		JdbcConnection connection = JdbcConnection.getInstance();
	    connection.openConnection();
	    String label = p.label;
	    String description = p.description;
	    String category = p.category.getLabel();
	    
		String deleteProductProposed = "DELETE FROM Product WHERE labelProduct = '"+ label +"'AND description = '"+ description +"'AND labelPC = '"+ category +"'AND status = 'false')";
		connection.executeRequest(deleteProductProposed);
		connection.close();
	}
}
