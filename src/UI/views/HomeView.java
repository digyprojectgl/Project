package UI.views;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JTextField;
import UI.controllers.HomeViewController;
import app.model.User;

/**
 * Class the HomeView.
 * Called after the user's LogIn.
 * @author francois.beiger
 *
 */
public class HomeView {
	private HomeViewController homeViewController;
	
	/**
	 * HomeView Constructor for the Customer.
	 * @param contentPane
	 * @param homeViewController
	 */
	public HomeView(Container contentPane, HomeViewController homeViewController, User myCustomer){
		this.homeViewController = homeViewController;
		JTextField message = new JTextField();
		message.setText("Hi " + myCustomer.getUserID() + " !");
		contentPane.add(message, BorderLayout.CENTER);
	}
}
