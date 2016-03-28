package app.model;

/**
 * Created by Arthur on 26/02/2016.
 */
public class Admin extends User {
	
	/**
	 * Constructor.
	 * @param userID
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @param email
	 * @param telephone
	 * @param address
	 */
	public Admin(String userID, String firstName, String lastName, String password, String email, String telephone, String address){
		super(userID, password, lastName, firstName, address, telephone, email);
	}
	
    @Override
    public Comment postComment(User from, String message) {
        return null;
    }

    @Override
    public void deleteComment(Comment comment) {

    }

    @Override
    public Notification notify(String content) {
        return null;
    }
}
