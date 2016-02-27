package View;
import javax.swing.JFrame;

//ViewLogIn doit hériter de Jframe et de Observable
//On passe donc par le design pattern Adaptable
public class AdaptableViewLogIn extends JFrame{
	public ObservableViewLogIn viewObservable;
	
	//Constructeur de la classe
	//Doit créer la vue avec 2 texts fields, 2 labels et 1 button
	public AdaptableViewLogIn(){
		
	}
}
