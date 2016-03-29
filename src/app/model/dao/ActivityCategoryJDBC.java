package app.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import app.model.ActivityCategory;

public class ActivityCategoryJDBC extends ActivityCategory{

	public ActivityCategoryJDBC(){
		super();
	}
	
	/**
	 * Constructor. Loads the ActivityCategory according to the labelAC.
	 * @param labelAC
	 * @throws Exception
	 */
	public ActivityCategoryJDBC(String labelAC) throws Exception{
		JdbcConnection connect = JdbcConnection.getInstance();
		connect.openConnection();
		ResultSet res = null;
		
		try{
			String query ="SELECT * FROM ActivityCategory where labelAC = '" + labelAC +"'";
			connect.executeRequest(query);
			while ((res = connect.fetchArray()) != null){
				this.setLabelCategoryActivity(res.getString("labelAC"));
				this.setShortDescription(res.getString("shortDescription"));
				this.setDetailedDescription(res.getString("detailDescription"));
			}
		}
		catch(SQLException e){
			throw (Exception)e;
		}
		connect.close();
	}
	
	/**
	 * Set the 'is_validate' attribute to 'true'.
	 * @throws Exception
	 */
	public void validateCategory() throws Exception{
		JdbcConnection connect = JdbcConnection.getInstance();
		connect.openConnection();
		String query ="UPDATE ActivityCategory SET is_validate ='true' WHERE labelAC = '" 
		+ this.getLabelCategoryActivity() +"'";
		connect.executeRequest(query);
		connect.close();
	}
	
	/**
	 * Delete the ActivityCategory from the DB.
	 * @throws Exception
	 */
	public void deleteCategory() throws Exception{
		JdbcConnection connect = JdbcConnection.getInstance();
		connect.openConnection();
		String query ="DELETE FROM ActivityCategory WHERE labelAC = '" 
		+ this.getLabelCategoryActivity() +"'";
		connect.executeRequest(query);
		connect.close();
	}
	
	/**
	 * Insert a new ActivityCategory into the DB. By default, is_validate is setted to 'false'.
	 * @throws Exception
	 */
	public void insertCategory() throws Exception{
		JdbcConnection connect = JdbcConnection.getInstance();
		connect.openConnection();
		//DB Structure : labelAC, shortDescription, detailedDescription, is_validate
		String query ="INSERT INTO ActivityCategory VALUES('" + this.getLabelCategoryActivity()
			+ "' , '" + this.getShortDescription() + "' , '" 
			+ this.getDetailedDescription() + "' , 'false')";
		connect.executeRequest(query);
		connect.close();
	}
	
}
