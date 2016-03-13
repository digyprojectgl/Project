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
	JTextField text_user;
	JPasswordField passwordField;
	JButton submit;	
	LogInController logInController;
	
	/**
	 * Constructor.
	 * Create all the JFrame components then adds them to the contentPane.
	 * @param contentPane
	 * @param logInContainer
	 */
	public ViewLogIn(Container contentPane, LogInController logInController){
		this.logInController = logInController;
			
		JPanel totalContent = new JPanel();
		
		JPanel globalContent = new JPanel(new GridLayout(0,2));		//Container user + password
		
		JPanel labelPanel = new JPanel(new GridLayout(2,0));			//Panel dans lequel on aura les label
		JPanel fieldPanel = new JPanel(new GridLayout(2,0));			//Panel dans lequel on aura les champs password et user_id
		
		JPanel submitPanel = new JPanel();
		
		JLabel user_id = new JLabel("User ID");		//Label "User ID"
		setTextUser(new JTextField(10));	//Text Field dans lequel le user va entrer son id
		JLabel password = new JLabel("Password");	//Label "Password"
		setPasswordField(new JPasswordField(10));//PAssword field
		
		labelPanel.add(user_id);						//On ajoute le label et le text area au panel
		labelPanel.add(password);
		fieldPanel.add(getTextUser());					//On ajoute le label et le passwordField
		fieldPanel.add(getPasswordField());
		
		globalContent.add(labelPanel);	//On ajoute les 2 panels au container fields, 
		globalContent.add(fieldPanel);
		
		totalContent.add(globalContent, BorderLayout.CENTER);
		
		contentPane.add(totalContent, BorderLayout.CENTER);// On ajoute le container au SuperContainer, contrainte CENTER
		
		setButtonSubmit(new JButton("Submit"));		//Bouton 'submit'
		getButtonSubmit().addActionListener(this);
		
		submitPanel.add(getButtonSubmit());
		
		contentPane.add(submitPanel, BorderLayout.SOUTH);
	}
	
	
	//GETTERS & SETTERS
	
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

	
	
	
	//ActionPerformed
	/**
	 * Calls the logInController, who is in charge of handling the LogIn.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String username = getTextUser().getText().toString();
		String password = String.valueOf(getPasswordField().getPassword());
		Object answer = logInController.handleLogIn(username, password);
		if(answer instanceof Exception){ //It's an error
			JOptionPane.showMessageDialog(null, answer, "You're not connected", JOptionPane.ERROR_MESSAGE);
		}
		else{ //It's good
			JOptionPane.showMessageDialog(null, answer, "Welcome to Digy !", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
