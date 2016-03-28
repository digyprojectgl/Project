package UI.controllers;

import UI.core.RootController;
import UI.views.EditProfileView;
import app.facades.EditProfileFacade;
import app.model.User;

public class EditProfileController extends RootController{
	private EditProfileFacade editProfileFacade = new EditProfileFacade();
	
	public EditProfileController(){
		this.render(new EditProfileView(this));
	}
	
	public void updateUser(User myUser, String firstName, String lastName, String userID, String email, String phoneNumber, String address, String password, String confirm, String siret, String webaddress){
		try{
			User newUser = this.editProfileFacade.updateUser(myUser, firstName, lastName, userID, email, phoneNumber, address, password, confirm, siret, webaddress);
			setUser(newUser);
			EditProfileView myView = new EditProfileView(this);
			this.render(myView);
			myView.displayMessage("Your changes have been made !");
		}
		catch(Exception e){
			EditProfileView myView = new EditProfileView(this);
			this.render(myView);
			myView.displayError(e.getMessage());
		}
		
	}
	
}
