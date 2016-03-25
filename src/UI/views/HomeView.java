package UI.views;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JTextField;
import UI.controllers.HomeViewController;
import UI.core.ViewInterface;
import app.model.User;

/**
 * Class the HomeView.
 * Called after the user's LogIn.
 * @author francois.beiger
 *
 */
public class HomeView implements ViewInterface {
	
	private HomeViewController homeViewController;
	
	/**
	 * HomeView Constructor for the Customer.
	 * @param contentPane
	 * @param homeViewController
	 */
	public HomeView(){	
		/*
		this.homeViewController = homeViewController;
		JTextField message = new JTextField();
		message.setText("Hi " + myCustomer.getUserID() + " !");
		contentPane.add(message, BorderLayout.CENTER);
		*/
	}

	@Override
	public String getLayout() {
		return "main";
	}

	@Override
	public void render(Container contentPane) {
		
	}
}
