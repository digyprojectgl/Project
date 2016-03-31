package UI.controllers;

import java.util.ArrayList;

import UI.core.RootController;
import UI.views.customer.NewEntryView;
import app.facades.EntryFacade;
import app.model.Customer;
import app.model.Entry;

public class CustomerEntryController extends RootController {
	EntryFacade entryFacade;
	
	public CustomerEntryController() {
		entryFacade = new EntryFacade();
		try {
			ArrayList<Entry> entries = this.fetchEntries();
			NewEntryView view = new NewEntryView(this, entries);
			this.render(view);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public ArrayList<Entry> fetchEntries() throws Exception {
		return entryFacade.getLastEntries((Customer) RootController.getUser());
	}
	
	public void addEntry(String text) {
		try {
			entryFacade.addEntry(text, (Customer) RootController.getUser());
			this.render(new NewEntryView(this, this.fetchEntries()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeEntry(Entry entry) {
		try {
			entryFacade.removeEntry(entry);
			this.render(new NewEntryView(this, this.fetchEntries()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
