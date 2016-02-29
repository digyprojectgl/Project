package UI.views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import UI.controllers.LogInController;


//Cette classe est la vue LogIn 
//Elle va afficher les 2 text fields (user_id & password)
//Quand l'utilisateur appuie sur le boutton 'Submit'
//Appelle le controller avec les infos (user_id & password)
public class ViewLogIn implements ActionListener{
	JTextArea text_user;
	JPasswordField passwordField;
	JButton submit;	
	LogInController logInController;
	
	//Constructeur
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
	
	
	//GETTEURS & SETTEURS
	
	//Text User
	private JTextArea getTextUser(){
		return this.text_user;
	}
	private void setTextUser(JTextArea text_user){
		this.text_user = text_user;
	}
	
	//Password Field
	private JPasswordField getPasswordField(){
		return this.passwordField;
	}
	private void setPasswordField(JPasswordField passwordField){
		this.passwordField = passwordField;
	}
	
	//Submit Button
	private JButton getButtonSubmit(){
		return this.submit;
	}
	private void setButtonSubmit(JButton submit){
		this.submit = submit;
	}

	
	
	
	//ActionPerformed lorsque le bouton submit est appuyé
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String username = getTextUser().getText().toString();
		String password = String.valueOf(getPasswordField().getPassword());
		logInController.handleLogIn(username, password);
	}
}
