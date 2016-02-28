package View;
import java.util.Observable;

//ViewLogIn doit hériter de Jframe et de Observable
//On passe donc par le design pattern Adaptable
public class AdaptableViewLogIn extends Observable{
	public ViewLogIn viewLogIn;
	public String user_id;
	public char[] password;
	
	public AdaptableViewLogIn(){
		this.user_id = null;
		this.password = null;
		this.viewLogIn = new ViewLogIn(this);
	}
	
	public String getUserId(){
		return user_id;
	}
	
	public char[] getPassword(){
		return password;
	}
	
	private void setUserId(String user_id){
		this.user_id = user_id;
	}
	
	private void setPassword(char[] password){
		this.password = password;
	}
	
	public void change(String user_id, char[] password){
		setUserId(user_id);				//On modifie notre Adaptable
		setPassword(password);
		setChanged();					//On note bien que l'état de l'observable a changé
		notifyObservers();				//On notifie alors l'observer
	}
	
	public void displayMessage(String msg){
		this.viewLogIn.displayMessage(msg);
	}
	
}
