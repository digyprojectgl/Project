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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import UI.core.Frame;
import UI.core.LayoutInterface;
import UI.core.RootController;
import app.model.Admin;
import app.model.Customer;
import app.model.Seller;

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
		
		//Load the good menu according to the user.
		if(getUser() instanceof Customer){
			header.add(this.buildMenuCustomer(), BorderLayout.SOUTH);
		}
		if(getUser() instanceof Seller){
			header.add(this.buildMenuSeller(), BorderLayout.SOUTH);
		}
		if(getUser() instanceof Admin){
			header.add(this.buildMenuAdmin(), BorderLayout.SOUTH);
		}
		
		header.add(new JLabel("Hi,  " + getUser().getUserID()), BorderLayout.CENTER);
		
		JPanel buttonsEdit = new JPanel();
		JButton edit = new JButton("Edit profile");
		edit.addActionListener(new Edit(this));
		JButton deconnect = new JButton("Deconnexion");
		deconnect.addActionListener(new Deconnect(this));
		buttonsEdit.add(edit);
		buttonsEdit.add(deconnect);
		header.add(buttonsEdit, BorderLayout.EAST);
		footer.add(new JLabel("footer"));
		
		layout.add(header, BorderLayout.NORTH);
		layout.add(footer, BorderLayout.SOUTH);
		layout.add(content, BorderLayout.CENTER);
		
		frame.add(layout);
		
		
		this.contentPane = content;
		
		frame.setSize(900, 600);
		frame.center();
	}
	
	public JPanel buildMenuCustomer() {
		JPanel menu = new JPanel(new FlowLayout());
		MenuItem items[] = {
				new MenuItem("Home", "home"),
				new MenuItem("Products", "productList"),
				new MenuItem("My account", "account"),
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
	
	public JPanel buildMenuAdmin(){
		JPanel menu = new JPanel(new FlowLayout());
		MenuItem items[] ={
				new MenuItem("Notifications", "notifications"),
				new MenuItem("Manage Users", "mUsers"),
				new MenuItem("Manage Activities", "mActivities"),
				new MenuItem("Manage products", "mProducts")
		};
		for(MenuItem item: items){
			JButton button = new JButton(item.label);
			button.addActionListener(new Navigate(this, item.action));
			menu.add(button);
		}
		return menu;
	}
	
	public JPanel buildMenuSeller(){
		JPanel menu = new JPanel(new FlowLayout());
		MenuItem items[] = {
				new MenuItem("Notifications", "notifications"),
				new MenuItem("My account", "account"),
				new MenuItem("My offers", "offers"),
				new MenuItem("Products", "productList"),
				new MenuItem("Quotes", "quotes")
		};
		for(MenuItem item: items){
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
	
	class Edit implements ActionListener{
		protected RootController controller;
		public Edit(RootController controller){
			this.controller = controller;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			this.controller.goTo("edit");
		}
	}
}
