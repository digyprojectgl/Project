package UI;
import java.awt.*;
import javax.swing.*;
import UI.controllers.LogInController;
import UI.controllers.SuperController;


/**
 * Create the view of the app. Only the contentPane change
 * @author francois.beiger
 *
 */
public class MainView extends JFrame{
	private SuperController superController;
	/**
	 * Constructor, create the LogInController, create the content pane, then give it to the controller
	 */
	public MainView(SuperController superController){
		//Paramètres de la fenêtre
		super("Digy");
		setSize(800, 600);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Fermeture de la fenêtre auto
		this.superController = superController;
		this.superController.setContentPane(getContentPane());
		setVisible(true);
	}
	
}
