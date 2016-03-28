package UI.views;

/**
 * list of propositions of product on admin side
 * @author shui
 */
import java.awt.Container;

import UI.controllers.PropositionManageController;
import UI.core.ViewInterface;

public class PropositionManageView implements ViewInterface{
	PropositionManageController propositionManageController;
	
	public PropositionManageView(PropositionManageController propositionManageController){
		this.propositionManageController = propositionManageController;	
	}

	@Override
	public String getLayout() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void render(Container contentPane) {
		// TODO Auto-generated method stub
		
	}
}
