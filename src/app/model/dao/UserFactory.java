package app.model.dao;

public class UserFactory {

	public UserFactory(){
		
	}
	
	public User createUser(){
		return new UserJDBC();
	}
}
