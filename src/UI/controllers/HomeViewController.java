package UI.controllers;
import UI.core.RootController;
import UI.views.HomeView;
import app.model.Customer;
import app.model.User;

public class HomeViewController extends RootController {
	
	public HomeViewController(){
		this.render(new HomeView());
	}
}
