package app.model;

/**
 * Created by Arthur on 26/02/2016.
 */
public abstract class User {
    public String userID;
    public String password;
    public String firstName;
    public String lastName;
    private String address;
    private String tel;
    private String email;

    public User(String userID, String password, String lastName, String firstName, String adress, String tel, String email){
    	this.userID = userID;
    	this.password = password;
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.address = adress;
    	this.tel = tel;
    	this.email = email;
    }
    
    public User(){
    	this.userID = null;
    	this.password = null;
    	this.firstName = null;
    	this.lastName = null;
    	this.address = null;
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
    
    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAdress() {
		return address;
	}

	public void setAdress(String adress) {
		this.address = adress;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public abstract Comment postComment(User from, String message);

    public abstract void deleteComment(Comment comment);

    public abstract Notification notify(String content);
}
