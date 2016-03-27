package app.model;

/**
 * Created on 20/03/2016.
 *
 * @author Arthur
 */
public class Seller extends User {

	public String siret;
	public String webAddress;
	
	public Seller(){
		super();
		this.siret = null;
		this.webAddress = null;
	}
	
	/**
	 * Constructor.
	 * @param userID
	 * @param password
	 * @param lastName
	 * @param firstName
	 * @param adress
	 * @param tel
	 * @param email
	 * @param siret
	 * @param webaddress
	 */
	public Seller(String userID, String password, String lastName, String firstName, String adress, String tel, String email, String siret, String webaddress){
		super( userID,  password,  lastName,  firstName,  adress,  tel, email);
		this.siret = siret;
		this.webAddress = webaddress;
	}
	
	public String getSiret() {
		return siret;
	}
	public void setSiret(String siret) {
		this.siret = siret;
	}
	public String getWebAddress() {
		return webAddress;
	}
	public void setWebAddress(String webAddress) {
		this.webAddress = webAddress;
	}

	@Override
	public Comment postComment(User from, String message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteComment(Comment comment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Notification notify(String content) {
		// TODO Auto-generated method stub
		return null;
	} 
	
	
	
}
