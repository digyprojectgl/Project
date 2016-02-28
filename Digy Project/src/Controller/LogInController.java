package Controller;
import java.util.Observable;
import java.util.Observer;
import View.*;


//Controlleur de la ViewLogIn
//Traite les informations envoyées par la ViewLogIn (user_id & password)
//Affiche un message d'erreur si logIn + password incorrects
public class LogInController implements Observer{
	private String user_id;
	private char[] password;
	
	public LogInController(){
		this.user_id = null;
		this.password = null;
		AdaptableViewLogIn viewAdaptable = new AdaptableViewLogIn(); // On crée notre AdaptableView
		viewAdaptable.addObserver(this);							 // On ajoute l'observer à l'adaptable view 
	}
	
	private String getUserId(){
		return user_id;
	}
	
	private char[] getPassword(){
		return password;
	}
	
	private void setUserId(String user_id){
		this.user_id = user_id.toLowerCase().trim();
	}
	
	private void setPassword(char[] password){
		this.password = password;
	}
	
	
	//Fonction qui traite et vérifie que le compte existe
	private void handleLogIn(){
		String myPassword = "mdp";			//Juste pour tester avec un seul utilisateur
		String myUser = "fbeiger";
		
		String newPassword = String.valueOf(password);		// On transforme notre mot de passe en String
		if(myUser.equals(getUserId()) && myPassword.equals(newPassword)){
			System.out.println("Hi " + this.user_id + " !");
		}
		else{
			System.out.println("Error wrong User ID and/or Password !");
		}
	}

	
	@Override
	public void update(Observable obs, Object arg) {
		setUserId(((AdaptableViewLogIn)obs).getUserId());		//On caste l'observable par son type 
		setPassword(((AdaptableViewLogIn)obs).getPassword());	//Puis on récupère l'Id et le password
		handleLogIn();											//On appelle la fonction qui va vérifier le compte
	}
	
	public static void main(String[] args){
		new LogInController();
		
	}
}
