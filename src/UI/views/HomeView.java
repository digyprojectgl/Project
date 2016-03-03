package UI.views;
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JTextField;

/**
 * Class the HomeView.
 * Called after the user's LogIn.
 * @author francois.beiger
 *
 */
public class HomeView {
	public HomeView(Container contentPane, String msg){
		contentPane.removeAll();
		JTextField message = new JTextField();
		message.setText(msg);
		contentPane.add(message, BorderLayout.CENTER);
		contentPane.revalidate();
		contentPane.repaint();
	}
}
