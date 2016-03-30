package UI.controllers;
/**
 * manage propositions of product - admin side
 * @author shui
 */

import UI.core.RootController;
import UI.views.admin.PropositionManageView;
import app.facades.PropositionListFacade;
import app.facades.PropositionManageFacade;
import app.model.*;

public class PropositionManageController extends RootController{
	
	public PropositionManageController(){
			this.render(new PropositionManageView(this));
			}
	/**
	 * play list of propose
	 * @throws Exception 
	 */
	public ProductList ListProposition() throws Exception{
		PropositionListFacade facade = new PropositionListFacade();
        return facade.getProductProposedList();
    }
	
	/**
	 * valid a propose
	 */
	public void AcceptProposition(Product p){
		PropositionManageFacade facade = new PropositionManageFacade();
		try {
			facade.acceptProposition(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * refuse a propose
	 */
	public void refuseProposition(Product p){
		PropositionManageFacade facade = new PropositionManageFacade();
		try {
			facade.refuseProposition(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
