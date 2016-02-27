package View;
import java.util.Observable;

//ViewLogIn doit hériter de Jframe et de Observable
//On passe donc par le design pattern Adaptable
public class ObservableViewLogIn extends Observable{
	public AdaptableViewLogIn viewAdaptable;
	
	public ObservableViewLogIn(){
		
	}
}
