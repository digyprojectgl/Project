
package UI.views;
import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.*;

import UI.controllers.LogInController;
import UI.core.ViewInterface;
/**
 * Display 2 text fields (user_id and password).
 * Call the LogIn Controller with user_id and password when the submit button is turned on.
 * @author francois.beiger
 *
 */
public class ViewLogIn implements ViewInterface {
	JTextField text_user;
	JPasswordField passwordField;
	JButton submit;	
	JButton signUp;
	LogInController logInController;
	
	/**
	 * Constructor.
	 * Create all the JFrame components then adds them to the contentPane.
	 * @param logInController
	 */
	public ViewLogIn(LogInController logInController){
		this.logInController = logInController;
	}
	
	public void render(Container contentPane) {
		JPanel all = new JPanel();
		
		JPanel totalContent = new JPanel(new GridLayout(2,0));
		
		JPanel globalContent = new JPanel(new GridLayout(0,2));		//Container user + password
		
		JPanel labelPanel = new JPanel(new GridLayout(2,0));			//Panel dans lequel on aura les label
		JPanel fieldPanel = new JPanel(new GridLayout(2,0));			//Panel dans lequel on aura les champs password et user_id
		
		JPanel buttonPanel = new JPanel();
		
		JLabel user_id = new JLabel("User ID");		//Label "User ID"
		setTextUser(new JTextField(10));	//Text Field dans lequel le user va entrer son id
		JLabel password = new JLabel("Password");	//Label "Password"
		setPasswordField(new JPasswordField(10));//PAssword field
		
		this.getPasswordField().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				logIn();
			}
			
		});
		
		labelPanel.add(user_id);						//On ajoute le label et le text area au panel
		labelPanel.add(password);
		fieldPanel.add(getTextUser());					//On ajoute le label et le passwordField
		fieldPanel.add(getPasswordField());
		
		globalContent.add(labelPanel);	//On ajoute les 2 panels au container fields, 
		globalContent.add(fieldPanel);
		
		this.setSignUp(new JButton("Sign Up"));
		this.getSignUp().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				goToSignUp();
			}
		});
		buttonPanel.add(getSignUp());
		
		
		setButtonSubmit(new JButton("Submit"));		//Bouton 'submit'
		getButtonSubmit().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				logIn();
			}
		});
		buttonPanel.add(getButtonSubmit());
		
		totalContent.add(globalContent);
		totalContent.add(buttonPanel);
		
		all.add(totalContent);
		
		contentPane.add(all, BorderLayout.CENTER);// On ajoute le container au SuperContainer, contrainte CENTER
		
		
	}
	
	public String getLayout() {
		return "login";
	}
	
	//GETTERS & SETTERS
	
	public JButton getSignUp() {
		return signUp;
	}


	public void setSignUp(JButton signUp) {
		this.signUp = signUp;
	}


	/**
	 * Get the user_ID
	 * @return JTextArea
	 */
	private JTextField getTextUser(){
		return this.text_user;
	}
	
	/**
	 * Set the text_user. Have to place a JTextArea in parameter.
	 * @param text_user
	 */
	private void setTextUser(JTextField text_user){
		this.text_user = text_user;
	}
	
	/**
	 * Get the passwordField.
	 * @return JPasswordField.
	 */
	private JPasswordField getPasswordField(){
		return this.passwordField;
	}
	
	/**
	 * Set the passwordField. Must place a JPasswordField in parameter.
	 * @param passwordField.
	 */
	private void setPasswordField(JPasswordField passwordField){
		this.passwordField = passwordField;
	}
	
	/**
	 * Get the submit button.
	 * @return JButton
	 */
	private JButton getButtonSubmit(){
		return this.submit;
	}
	
	/**
	 * Set the submit button. Must place a JButton in parameter.
	 * @param submit
	 */
	private void setButtonSubmit(JButton submit){
		this.submit = submit;
	}

	
	private void goToSignUp(){
		this.logInController.goToSignUp();
	}
	
	//ActionPerformed
	/**
	 * Calls the logInController, who is in charge of handling the LogIn.
	 */
	public void logIn() {
		
		String username = getTextUser().getText().toString();
		String password = String.valueOf(getPasswordField().getPassword());
		logInController.handleLogIn(username, password);
	}
	
	public void displayErrors(String e){
		JOptionPane.showMessageDialog(null, e, "Your log in hasn't been performed.", JOptionPane.ERROR_MESSAGE);
	}
}
