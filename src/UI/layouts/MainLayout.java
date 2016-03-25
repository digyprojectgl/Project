package UI.layouts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;
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
		menu.add(new JButton("Home"));
		menu.add(new JButton("Products"));
		menu.add(new JButton("Mon compte"));
		menu.add(new JButton("Notifications"));
		menu.add(new JButton("Cart"));
		return menu;
	}
}
