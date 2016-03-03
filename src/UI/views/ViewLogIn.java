package UI.views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import UI.controllers.LogInController;


/**
 * Display 2 text fields (user_id & password).
 * Call the LogIn Controller with user_id & password when the submit button is turned on.
 * @author francois.beiger
 *
 */
public class ViewLogIn implements ActionListener{
	JTextArea text_user;
	JPasswordField passwordField;
	JButton submit;	
	LogInController logInController;
	
	/**
	 * Constructor.
	 * Create all the JFrame components then adds them to the contentPane.
	 * @param contentPane
	 */
	public ViewLogIn(Container contentPane){
		logInController = new LogInController(contentPane);
				
		JPanel contentFields = new JPanel(new GridLayout(2,0));		//Container user + password
		
		JPanel userPanel = new JPanel();			//Panel dans lequel on aura les label
		JPanel passPanel = new JPanel();			//Panel dans lequel on aura les champs password et user_id
		
		JLabel user_id = new JLabel("User ID");		//Label "User ID"
		setTextUser(new JTextArea(1,10));	//Text Field dans lequel le user va entrer son id
		
		userPanel.add(user_id);						//On ajoute le label et le text area au panel
		userPanel.add(getTextUser());
		
		
		JLabel password = new JLabel("Password");	//Label "Password"
		setPasswordField(new JPasswordField(10));//PAssword field
		
		passPanel.add(password);					//On ajoute le label et le passwordField
		passPanel.add(getPasswordField());
		
		contentFields.add(userPanel);	//On ajoute les 2 panels au container fields, 
		contentFields.add(passPanel);
		
		contentPane.add(contentFields, BorderLayout.NORTH);// On ajoute le container au SuperContainer, contrainte CENTER
		
		setButtonSubmit(new JButton("Submit"));		//Bouton 'submit'
		getButtonSubmit().addActionListener(this);
		contentPane.add(submit, BorderLayout.SOUTH);
	}
	
	
	//GETTERS & SETTERS
	
	/**
	 * Get the user_ID
	 * @return JTextArea
	 */
	private JTextArea getTextUser(){
		return this.text_user;
	}
	
	/**
	 * Set the text_user. Have to place a JTextArea in parameter.
	 * @param text_user
	 */
	private void setTextUser(JTextArea text_user){
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

	
	
	
	//ActionPerformed
	/**
	 * Calls the logInController, who is in charge of handling the LogIn.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String username = getTextUser().getText().toString();
		String password = String.valueOf(getPasswordField().getPassword());
		logInController.handleLogIn(username, password);
	}
}
