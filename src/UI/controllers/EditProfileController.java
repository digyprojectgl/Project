package UI.controllers;

import UI.core.RootController;
import UI.views.EditProfileView;

public class EditProfileController extends RootController{
	
	
	public EditProfileController(){
		this.render(new EditProfileView(this));
	}
	
}
