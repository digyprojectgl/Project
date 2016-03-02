package app.model;

/**
 * Created by Arthur on 26/02/2016.
 */
public abstract class User {
    public String userID;
    public String password;
    public String name;
    private String adress;
    private String tel;
    private String email;

    public User(String userID, String password, String name, String adress, String tel, String email){
    	this.userID = userID;
    	this.password = password;
    	this.name = name;
    	this.adress = adress;
    	this.tel = tel;
    	this.email = email;
    }
    
    public User(){
    	this.userID = null;
    	this.password = null;
    	this.name = null;
    	this.adress = null;
    	this.tel = null;
    	this.email = null;
    }
    
    //GETTERS & SETTERS
    public String getUserID(){
    	return this.userID;
    }
    
    public String getPassword(){
    	return this.password;
    }
    
    public void setUserID(String userID){
    	this.userID = userID;
    }
    
    public void setPassword(String password){
    	this.password = password;
    }
    
    public abstract Comment postComment(User from, String message);

    public abstract void deleteComment(Comment comment);

    public abstract Notification notify(String content);
}
