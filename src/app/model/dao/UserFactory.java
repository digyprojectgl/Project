package app.model.dao;

import app.model.User;

public class UserFactory {

	public UserFactory(){
		
	}
	
	public User createUser(){
		return new UserJDBC();
	}
}
