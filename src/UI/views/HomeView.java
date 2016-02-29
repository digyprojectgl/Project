package UI.views;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JTextField;

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
