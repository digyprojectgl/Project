package UI.controllers;
/**
 * @author shui
 */

import UI.core.RootController;
import UI.views.ViewProposeProduct;
import app.facades.ProposeProductFacade;
import app.model.*;

public class ProposeProductController extends RootController {
	public ProposeProductController(){
		this.render(new ViewProposeProduct(this));
	}
	
	public Object proposeProduct(String label, String description, ProductCategory category){
		ProposeProductFacade facade = new ProposeProductFacade();
		try{
			Product newProductProposed = facade.proposeproduct(label,description, category);
			return newProductProposed;
		}
		catch(Exception e){
			return e.getMessage();
		}
	}
	
	public void deleteProposition(String label, String description, ProductCategory category){
		ProposeProductFacade facade = new ProposeProductFacade();
		try {
			facade.deleteproductproposed(label,description, category);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
