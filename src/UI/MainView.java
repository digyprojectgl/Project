package UI;
import java.awt.*;
import javax.swing.*;
import UI.controllers.LogInController;


/**
 * Create the view of the app. Only the contentPane change
 * @author francois.beiger
 *
 */
public class MainView extends JFrame{
	Container contentPane;	//Super Container	
	
	
	/**
	 * Constructer, create the LogInController, create the content pane, then give it to the controller
	 */
	public MainView(){
		//Paramètres de la fenêtre
		super("Digy");
		setSize(800, 600);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Fermeture de la fenêtre auto

		contentPane = getContentPane(); 
		LogInController controlLogIn = new LogInController(contentPane);
		controlLogIn.displayViewLogIn();
		setVisible(true);
	}
}
