package UI.controllers;
/**
 * @author shui
 */

import java.awt.event.ActionEvent;
import java.util.Objects;

import javax.swing.JComboBox;

import UI.views.ViewProposeProduct;
import app.facades.ProposeProductFacade;
import app.model.*;

public class ProposeProductController {
	private RootController rootController;
	
	public ProposeProductController(RootController rootController){
		this.rootController = rootController;
		new ViewProposeProduct(rootController.getContentPane(), this);
		/**
		 * @todo
		 */
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
