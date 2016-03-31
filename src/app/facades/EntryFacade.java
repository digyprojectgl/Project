package app.facades;

import java.util.ArrayList;

import app.model.Customer;
import app.model.Entry;
import app.services.EntryService;

public class EntryFacade {
	EntryService entryService;
	
	public EntryFacade() {
		entryService = new EntryService();
	}
	/**
	 * Facade to create an new entry in the customer diary
	 * @param text
	 * @param customer
	 * @throws Exception 
	 */
	public void addEntry(String text, Customer customer) throws Exception {
		
		entryService.createEntry(text, customer);
	}
	
	/**
	 * Get a customer last entries
	 * @param customer
	 * @return 
	 * @throws Exception 
	 */
	public ArrayList<Entry> getLastEntries(Customer customer) throws Exception {
		return entryService.getUserEntries(customer);
	}
	
	/**
	 * Remove an entry from the diary
	 * @param entry
	 * @throws Exception 
	 */
	public void removeEntry(Entry entry) throws Exception {
		entryService.removeEntry(entry);
		
	}
}
