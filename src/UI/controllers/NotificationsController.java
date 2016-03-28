package UI.controllers;

import UI.core.RootController;
import UI.views.NotificationView;

public class NotificationsController extends RootController {
	public NotificationsController() {
		this.render(new NotificationView());
	}
}
