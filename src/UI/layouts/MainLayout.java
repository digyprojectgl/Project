package UI.layouts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import UI.core.Frame;
import UI.core.LayoutInterface;
import UI.core.RootController;

public class MainLayout extends RootController implements LayoutInterface {

	Container contentPane;
	
	@Override
	public Container getContainer() {
		return contentPane;
	}

	@Override
	public void render(Frame frame) {
		JPanel layout = new JPanel(new BorderLayout());
		JPanel header = new JPanel(new BorderLayout());
		JPanel content = new JPanel();
		JPanel footer = new JPanel();
		
		header.setBackground(Color.WHITE);
		footer.setBackground(Color.PINK);
		content.setBackground(Color.WHITE);
		
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("assets/logo.PNG"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Image scaledImage = myPicture.getScaledInstance(140, 90, Image.SCALE_SMOOTH);
		JLabel picLabel = new JLabel(new ImageIcon(scaledImage));
		header.add(picLabel, BorderLayout.NORTH);
		header.add(this.buildMenu(), BorderLayout.SOUTH);
		header.add(new JLabel("Hi,  " + getUser().getUserID()), BorderLayout.CENTER);
		
		JButton deconnect = new JButton("Deconnexion");
		deconnect.addActionListener(new Deconnect(this));
		header.add(deconnect, BorderLayout.EAST);
		footer.add(new JLabel("footer"));
		
		layout.add(header, BorderLayout.NORTH);
		layout.add(footer, BorderLayout.SOUTH);
		layout.add(content, BorderLayout.CENTER);
		
		frame.add(layout);
		
		
		this.contentPane = content;
		
		frame.setSize(900, 600);
		frame.center();
	}
	
	public JPanel buildMenu() {
		JPanel menu = new JPanel(new FlowLayout());
		MenuItem items[] = {
				new MenuItem("Home", "home"),
				new MenuItem("Products", "productList"),
				new MenuItem("My account", "login"),
				new MenuItem("Notifications", "notifications"),
				new MenuItem("Cart", "cart")
		};	
		for(MenuItem item: items) {
			JButton button = new JButton(item.label);
			button.addActionListener(new Navigate(this, item.action));
			menu.add(button);
		}
		return menu;
	}
	
	class MenuItem {
		public String label;
		public String action;
		
		public MenuItem(String label, String action) {
			this.label = label;
			this.action = action;
		}
	}
	
	class Navigate implements ActionListener{
		protected String action;
		protected RootController controller;
		
		public Navigate(RootController controller, String action) {
			this.controller = controller;
			this.action = action;
		}
		public void actionPerformed(ActionEvent e) {
			System.out.println("test");
			this.controller.goTo(action);
		}
	}
	
	class Deconnect implements ActionListener{
		protected RootController controller;
		public Deconnect(RootController controller) {
			this.controller = controller;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			this.controller.goTo("login");
		}
		
	}
}
