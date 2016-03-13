package UI.controllers;
import java.awt.Container;

import UI.MainView;

/**
 * Controller who handle controllers, by sending the information to the right one.
 * @author francois.beiger
 *
 */
public class RootController {
	Container contentPane;
	
	public RootController(){
		new MainView(this);
		new SignUpController(this);
		getContentPane().revalidate();
		getContentPane().repaint();
	}
	
	public Container getContentPane(){
		return this.contentPane;
	}
	
	public void setContentPane(Container contentPane){
		this.contentPane = contentPane;
	}
	
	public void goToSignUp(){
		new SignUpController(this);
		getContentPane().revalidate();
		getContentPane().repaint();
	}
}
