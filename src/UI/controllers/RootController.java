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
		this.displayContentPane();
	}
	
	public Container getContentPane(){
		return this.contentPane;
	}
	
	public void setContentPane(Container contentPane){
		this.contentPane = contentPane;
	}
	
	public void goToSignUp(){
		this.getContentPane().removeAll();
		new SignUpController(this);
		this.displayContentPane();
	}
	
	public void goToLogIn(){
		this.getContentPane().removeAll();
		new LogInController(this);
		this.displayContentPane();
		
	}
	
	private void displayContentPane(){
		getContentPane().revalidate();
		getContentPane().repaint();
	}
}
