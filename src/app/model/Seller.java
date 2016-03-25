package app.model;

/**
 * Created on 20/03/2016.
 *
 * @author Arthur
 */
public abstract class Seller extends User {

	public String siret;
	public String webAddress;
	public String profil;
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
	public String getProfil() {
		return profil;
	}
	public void setProfil(String profil) {
		this.profil = profil;
	} 
	
	
	
}
