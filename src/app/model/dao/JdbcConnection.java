package app.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Implements the design pattern Singleton.
 * @author francois.beiger
 *
 */
public class JdbcConnection {	
	
	private final String DBURL = "jdbc:mysql://db4free.net:3306/digyproject?autoReconnect=true&useSSL=false";
	private final String DBUSER = "digy";
	private final String DBPASS = "polytech";
	private Statement streamConnection;
    private ResultSet streamResponse;
    
    private static JdbcConnection instance ;

    private JdbcConnection(){
    	super();
    }
    
    public boolean openConnection(){
    	try {
    		// Charge le driver JDBC pour mysql
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            
            // Creation de la connection � la base
            Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            this.streamConnection = con.createStatement();
        } 
    	catch(Exception e) {  
    		System.out.println("Cannot access database at : " +DBURL); 
    		return false;  
    	} 
    	
    	return true;
    }
    
    /**
     * Methode close qui ferme la connexion SQL
     */
	public void close() {
		try{
			if(this.streamResponse != null) 
				this.streamResponse.close();
			this.streamConnection.close();
		}
		catch (SQLException e) { e.printStackTrace(); }		
	}
	
    /**
     * Methode executeRequest
     * @param sqlRequest la requete
     * @return true si l'execution c'est bien passe, false sinon
     */
	public boolean executeRequest(String sqlRequest) throws Exception {
        try {
        	//s'il s'agit d'une requete SELECT il faut utiliser executeQuery()
            if (sqlRequest.contains("SELECT")) {
                this.streamResponse = this.streamConnection.executeQuery(sqlRequest);
            } 
            //sinon pour tout autre requete (DELETE, UPDATE, INSERT) on utilise executeUpdate()
            else {
                this.streamConnection.executeUpdate(sqlRequest);
            }
        } catch (SQLException ex) {
            throw ex;           
        }
        return true;
    }
	
    /**
     * Methode fetchArray
     * @return le tuple sous forme d'un ResultSet
     */
	public ResultSet fetchArray() {  
        try {
            if (this.streamResponse.next()) {
            	return this.streamResponse;              
            } 
            else {
                return null;
            }
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
	
    /**
     * Methode nbResponse
     * @return le nombre de tuple de la requete
     */
	public int nbResponse() {      
        ResultSet resultSet = this.streamResponse;
        int size = 0;
        try {
            resultSet.last();
            size = resultSet.getRow();        
        } catch (SQLException e) {
            return 0;
        }
        return size;
    }
	
	
	/**
	 * Pattern Singleton
	 * @return
	 */
	public static JdbcConnection getInstance(){
		if( instance != null){
			return instance;
		}
		else{
			instance = new JdbcConnection();
			return instance;
		}
	}
}

