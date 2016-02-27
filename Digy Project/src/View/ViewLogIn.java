package View;
import java.awt.*;
import javax.swing.*;


//Cette classe est la vue LogIn 
//Elle va afficher les 2 text fields (user_id & password)
//Quand l'utilisateur appuie sur le boutton 'Submit'
//Appelle le controller avec les infos (user_id & password)
public class ViewLogIn extends JFrame{
	public AdaptableViewLogIn viewAdaptable;
	
	public ViewLogIn(){
		//Paramètres de la fenêtre
		super("LogIn View");
		setSize(600, 400);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Fermeture de la fenêtre auto

		
		Container contentPane = getContentPane(); 	//Super Container
		JPanel contentFields = new JPanel();		//Container user + password
		
		JPanel userPanel = new JPanel();			//Panel dans lequel on aura les champs "user"
		JLabel user_id = new JLabel("User ID");		//Label "User ID"
		JTextArea text_user = new JTextArea(1,10);	//Text Field dans lequel le user va entrer son id
		
		userPanel.add(user_id);						//On ajoute le label et le text area au panel
		userPanel.add(text_user);
		
		JPanel passPanel = new JPanel();			//Panel dans lequel on aura les champs password
		JLabel password = new JLabel("Password");	//Label "Password"
		JPasswordField passwordField = new JPasswordField(10);//PAssword field
		
		passPanel.add(password);					//On ajoute le label et le passwordField
		passPanel.add(passwordField);
		
		contentFields.add(userPanel, BorderLayout.NORTH);	//On ajoute les 2 panels au container fields, 
		contentFields.add(passPanel, BorderLayout.CENTER);
		
		contentPane.add(contentFields, BorderLayout.CENTER);// On ajoute le container au SuperContainer, contrainte CENTER
		
		JButton submit = new JButton("Submit");		//Bouton 'submit'
		contentPane.add(submit, BorderLayout.SOUTH);

		setVisible(true);
	}
	
	public static void main(String[] args){
		JFrame viewLogIn = new ViewLogIn();
	}
}
