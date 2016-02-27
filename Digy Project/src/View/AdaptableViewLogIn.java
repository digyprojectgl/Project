package View;
import java.util.Observable;

//ViewLogIn doit hériter de Jframe et de Observable
//On passe donc par le design pattern Adaptable
public class AdaptableViewLogIn extends Observable{
	public ViewLogIn viewLog;
	
	public AdaptableViewLogIn(){
		
	}
}
