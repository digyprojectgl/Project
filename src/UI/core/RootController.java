package UI.core;
import java.awt.Container;
import UI.controllers.*;
import UI.layouts.LoginLayout;
import UI.layouts.MainLayout;
import app.model.User;

/**
 * Controller who handle controllers, by sending the information to the right one.
 * @author francois.beiger
 *
 */
public class RootController {
	private static LayoutInterface currentLayout;
	private static String currentLayoutName;
	private static User currentUser;
	private static Frame frame;
	
	public Frame getFrame() {
		if(frame == null) {
			frame = new Frame();
		}
		return frame;
	}
	
	public void setLayout(String name) {
		if(frame != null) {
			this.eraseContainer(frame.getContentPane());
			this.eraseContainer(currentLayout.getContainer());
		}
		
		switch(name) {
			case "login":
				currentLayout = new LoginLayout();
				break;
			case "main":
				currentLayout = new MainLayout();
				break;
			default:
				//TODO: throw UnknownLayoutException
				break;
		}
		
		currentLayout.render(getFrame());
		currentLayoutName = name;
		this.displayContentPane(currentLayout.getContainer());
		this.displayContentPane(frame.getContentPane());
		
	}
	
	public void router(String view, String[] params) {
		switch(view) {
			case "signup":
				new SignUpController();
				break;
			case "home":
				new HomeViewController();
				break;
			case "login":
				setUser(null);
				new LogInController();
				break;
			case "cart":
				new CartController();
				break;
			case "productList":
				new ProductListController();
				break;	
			case "notifications":
				new NotificationsController();
				break;
			case "edit":
				new EditProfileController();
				break;
			case "mActivities":
				new ManageActivityController();
				break;
			case "newCategory":
				new ProposeCategoryController();
				break;
			case "offers" :
				new ManageOfferController();
				break;
			case "product":
				new ProductController(params);
				break;
			case "newProduct":
				new ProposeProductController();
				break;
			case "mProducts":
				new PropositionManageController();
				break;
		}
	}
	
	public void goTo(String view) {
		this.goTo(view, null);
	}
	
	public void goTo(String view, String[] params) {
		router(view, params);		
	}
	
	public void render(ViewInterface view) {
		if(currentLayout != null) {
			this.eraseContainer(currentLayout.getContainer());
		}
		if(view.getLayout() != currentLayoutName) {
			this.setLayout(view.getLayout());
		}
		view.render(currentLayout.getContainer());
		this.displayContentPane(currentLayout.getContainer());
	}
	
	public static void setUser(User user) {
		currentUser = user;
	}
	
	public static User getUser() {
		return currentUser;
	}
	
	public void displayContentPane(Container container){
		container.revalidate();
		container.repaint();
	}
	
	public void eraseContainer(Container container){
		container.removeAll();
	}
}
