package app.services;

import java.util.ArrayList;

import app.factory.EntryJDBCFactory;
import app.model.Customer;
import app.model.Entry;
import app.model.dao.EntryJDBC;

public class EntryService {
	
	/**
	 * Get the user entries
	 * @param customer
	 * @return 
	 * @throws Exception 
	 */
	public  ArrayList<Entry> getUserEntries(Customer customer) throws Exception {
		EntryJDBC entry =  EntryJDBCFactory.createEntry();
		return entry.getAllEntries(customer);
	}
	
	/**
	 * Remove an entry
	 * @param entry
	 * @throws Exception 
	 */
	public static void removeEntry(Entry entry) throws Exception {
		EntryJDBC entryJDBC = EntryJDBCFactory.createEntry();
		entryJDBC.removeEntry(entry);
	}

	/**
	 * Create an entry into the customer diary
	 * @param text
	 * @param customer
	 * @throws Exception 
	 */
	public void createEntry(String text, Customer customer) throws Exception {
		EntryJDBC entry = EntryJDBCFactory.createEntry(text, customer);	
		entry.insertEntry();
	}
}
