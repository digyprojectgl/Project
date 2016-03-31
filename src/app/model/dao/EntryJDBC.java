package app.model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import app.model.ActivityCategory;
import app.model.Customer;
import app.model.Entry;

public class EntryJDBC extends Entry {
	public EntryJDBC() {
		
	}
	
	public EntryJDBC(String text, Customer customer) {
		this.setText(text).setTargetProfile(customer);
	}

	public void insertEntry() throws Exception {
		JdbcConnection connect = JdbcConnection.getInstance();
		connect.openConnection();
		//DB Structure : labelAC, shortDescription, detailedDescription, is_validate
		String query ="INSERT INTO Entry(name, idUser, postTime) VALUES('"
				+ this.getText() + "','"
				+ this.getTargetProfile().getUserID() + "',"
				+ "NOW())";
		connect.executeRequest(query);
		connect.close();
	}
	
	public ArrayList<Entry> getAllEntries(Customer customer) throws Exception {
		ArrayList<Entry> entries = new ArrayList<Entry>();
		String query ="SELECT * FROM Entry WHERE idUser = '" + customer.getUserID() + "'";
		JdbcConnection connect = JdbcConnection.getInstance();
		connect.openConnection();
		ResultSet res = null;
		connect.executeRequest(query);
		while ((res = connect.fetchArray()) != null){
			Entry myEntry = new Entry();
			myEntry.setText(res.getString("name"));
			myEntry.setCreatedAt(res.getDate("postTime"));
			myEntry.setId(res.getInt("idEntry"));
			entries.add(myEntry);
		}
		return entries;
	}

	public void removeEntry(Entry entry) throws Exception {
		ArrayList<Entry> entries = new ArrayList<Entry>();
		String query ="DELETE FROM Entry WHERE idEntry = '" + entry.getId().toString() + "'";
		JdbcConnection connect = JdbcConnection.getInstance();
		connect.openConnection();
		ResultSet res = null;
		connect.executeRequest(query);
		connect.close();
	}
	
}
