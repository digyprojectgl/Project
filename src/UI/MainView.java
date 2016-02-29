package UI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import UI.controllers.LogInController;


//Créé la fenêtre de l'application 
//Créé le controllerLogIn qui affiche les props. du log in
public class MainView extends JFrame{
	Container contentPane;	//Super Container	
	
	
	//Constructeur
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
