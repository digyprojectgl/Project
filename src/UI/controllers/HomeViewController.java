package UI.controllers;
import UI.views.HomeView;
import app.model.Customer;
import app.model.User;

public class HomeViewController {
	RootController rootController;
	
	HomeViewController(RootController rootController, User myUser){
		this.rootController = rootController;
		new HomeView(this.rootController.getContentPane(), this, myUser);

		
	}
}
