import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import app.model.Product;
import app.model.ProductCategory;
import app.model.dao.ProductJDBC;
import app.model.dao.ProductProposedJDBC;
import app.services.ProductProposedService;
import app.services.ProductService;

public class TestProposeProduct {
	ProductProposedService productService;
	ProductService service;
	
	@Before
	public void setUp(){
		productService = new ProductProposedService();
		service = new ProductService();
	}
	
	//@Test
	public void testNewProduct() throws Exception{
		ProductCategory myCategory = new ProductCategory("decoration");
		Product myProduct = productService.proposeProduct("mon produit", "description", myCategory);
		assertTrue("Error status must be false", myProduct.getStatus().equals("false"));
	}
	
	@Test
	public void testValidateProduct() throws Exception{
		ProductCategory myCategory = new ProductCategory("decoration");
		Product myProduct = new ProductProposedJDBC("mon produit", "description", myCategory, "false");
		
		service.newProduct(myProduct);
		
		Product newProduct = new ProductJDBC("mon produit", "decoration");
		
		assertTrue("Status must be true", newProduct.getStatus().equals("true"));
		productService.deleteProposition(myProduct);
	}
}
