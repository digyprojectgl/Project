package UI;
import java.awt.*;
import java.awt.Toolkit;

import javax.swing.*;
import UI.controllers.RootController;


/**
 * Create the view of the app. Only the contentPane change
 * @author francois.beiger
 *
 */
public class MainView extends JFrame{
	private RootController rootController;
	/**
	 * Constructor, create the LogInController, create the content pane, then give it to the controller
	 */
	public MainView(RootController rootController){
		//Paramètres de la fenêtre
		super("Digy");
		setSize(800, 600);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Fermeture de la fenêtre auto
		this.rootController = rootController;
		this.rootController.setContentPane(getContentPane());
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2); //Center the frame
		setVisible(true);
	}
	
}
