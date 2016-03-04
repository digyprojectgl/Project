package UI.controllers;
import java.awt.Container;

import UI.MainView;

/**
 * Controller who handle controllers, by sending the information to the right one.
 * @author francois.beiger
 *
 */
public class SuperController {
	Container contentPane;
	
	public SuperController(){
		new MainView(this);
		new LogInController(this);
		getContentPane().revalidate();
		getContentPane().repaint();
	}
	
	public Container getContentPane(){
		return this.contentPane;
	}
	
	public void setContentPane(Container contentPane){
		this.contentPane = contentPane;
	}
}
