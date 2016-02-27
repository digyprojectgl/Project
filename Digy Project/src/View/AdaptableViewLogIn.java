package View;
import javax.swing.JFrame;

//ViewLogIn doit hériter de Jframe et de Observable
//On passe donc par le design pattern Adaptable
public class AdaptableViewLogIn extends JFrame{
	public ObservableViewLogIn viewObservable;
	
	public AdaptableViewLogIn(){
		
	}
}
