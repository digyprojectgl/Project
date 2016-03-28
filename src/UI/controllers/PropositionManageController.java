package UI.controllers;
/**
 * manage propositions of product - admin side
 * @author shui
 */

import UI.core.RootController;
import UI.views.PropositionManageView;
import app.facades.PropositionListFacade;
import app.facades.PropositionManageFacade;
import app.model.*;

public class PropositionManageController extends RootController{
	
	public PropositionManageController(RootController rootController){
			this.render(new PropositionManageView(this));
			}
	/**
	 * play list of propose
	 */
	public Object ListProposition(){
		PropositionListFacade facade = new PropositionListFacade();
        return facade.getProductProposedList();
    }
	
	/**
	 * valid a propose
	 */
	public void AcceptProposition(String label, String description, ProductCategory category){
		PropositionManageFacade facade = new PropositionManageFacade();
		try {
			facade.acceptProposition(label,description, category);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * refuse a propose
	 */
	public void RefuseProposition(String label, String description, ProductCategory category){
		PropositionManageFacade facade = new PropositionManageFacade();
		try {
			facade.refuseProposition(label,description, category);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
