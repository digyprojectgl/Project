package UI.controllers;
/**
 * @author shui
 */

import UI.core.RootController;
import UI.views.seller.ProposeProductView;
import app.facades.ProposeProductFacade;
import app.model.*;

public class ProposeProductController extends RootController {
	ProposeProductFacade facade = new ProposeProductFacade();
	
	public ProposeProductController(){
		try{
			ProductCategoryList categorySet = this.facade.obtainCategoryList();
			this.render(new ProposeProductView(this, categorySet));
		}
		catch(Exception e){
			ProposeProductView myView = new ProposeProductView(this, null);
			this.render(myView);
			myView.displayError(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public Object proposeNewProduct(String label, String description, ProductCategory category){
		
		try{
			Product newProductProposed = facade.proposeproduct(label,description, category);
			return newProductProposed;
		}
		catch(Exception e){
			return e.getMessage();
			// TODO display function
		}
	}
	
	public void deleteProposition(Product p){
	
		try {
			facade.deleteproductproposed(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// TODO display function
		}
	}
}
