package app.factory;
import app.model.ProductCategory;
import app.model.dao.ProductProposedJDBC;

/**
 * Factory in charge of the Product proposed by seller but not valide.
 * @author shui
 *
 */
public class ProductProposedFactory {

	public ProductProposedFactory(){
		
	}
	
	public void createProductProposed(String label, String description, ProductCategory category) throws Exception{
		ProductProposedJDBC productproposedJDBC = new ProductProposedJDBC(label, description, category, "false");
		productproposedJDBC.addProductProposed(label, description, category);
	}
}
