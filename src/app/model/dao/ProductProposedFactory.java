package app.model.dao;

/**
 * Factory in charge of the Product proposed by seller but not valide.
 * @author shui
 *
 */
public class ProductProposedFactory {

	public ProductProposedFactory(){
		
	}
	
	public ProductProposedJDBC createProductProposed(String label, String description) throws Exception{
		return new ProductProposedJDBC(label, description);
	}
	//besoin d'autre parametre ou pas?
	
}
