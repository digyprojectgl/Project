package UI.controllers;

import UI.core.RootController;
import app.model.User;

public class ProfileController extends RootController {
	public ProfileController(String userId) {
		this.render(new ProfileView());
	}
}
