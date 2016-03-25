package UI.controllers;
/**
 * @author shui
 */

import java.awt.event.ActionEvent;
import java.util.Objects;

import javax.swing.JComboBox;

import UI.core.RootController;
import UI.views.ViewProposeProduct;
import app.facades.ProposeProductFacade;
import app.model.*;

public class ProposeProductController extends RootController {
	public ProposeProductController(){
		this.render(new ViewProposeProduct());
	}
	
	public Object proposeProduct(String label, String description){
		ProposeProductFacade facade = new ProposeProductFacade();
		try{
			Product newProductProposed = facade.proposeproduct(label,description);
			return newProductProposed;
		}
		catch(Exception e){
			return e.getMessage();
		}
	}
}
