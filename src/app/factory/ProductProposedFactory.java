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
	
	public ProductProposedJDBC createProductProposedJDBC() throws Exception{
		return new ProductProposedJDBC();
	}
	
	public ProductProposedJDBC createProductProposedJDBC(String label, String description, ProductCategory category) throws Exception{
		return new ProductProposedJDBC(label, description, category, "false");
	}
}
