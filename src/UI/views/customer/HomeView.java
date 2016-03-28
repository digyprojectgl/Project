package UI.views.customer;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
	private User myUser;
	
	/**
	 * HomeView Constructor for the Customer.
	 * @param contentPane
	 * @param homeViewController
	 */
	public HomeView(HomeViewController homeViewController, User myUser){
		this.homeViewController = homeViewController;
		this.myUser = myUser;
	}

	@Override
	public String getLayout() {
		return "main";
	}

	@Override
	public void render(Container contentPane) {
		JPanel all = new JPanel(new BorderLayout());
		JPanel lines = new JPanel(new GridLayout(3,0));
		
		JLabel title = new JLabel("Welcome back to DIGY !");
		title.setFont(new Font("Arial",Font.BOLD,18));
		all.add(title, BorderLayout.NORTH);
		
		JButton entry = new JButton("New diary entry");
		JButton activity = new JButton("New activty");
		JButton activityCategory = new JButton("New activity category");
		
		activityCategory.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				newCategory();
			}
		});
		
		
		lines.add(entry);
		lines.add(activity);
		lines.add(activityCategory);
		
		all.add(lines);
		
		contentPane.add(all);
	}
	
	/**
	 * Call the controller and create a new view for creating a new category 
	 */
	private void newCategory(){
		
	}
}
