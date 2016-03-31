package app.factory;

import app.model.Customer;
import app.model.dao.EntryJDBC;

public class EntryJDBCFactory {
	public static EntryJDBC createEntry(String text, Customer customer){
		return new EntryJDBC(text, customer);
	}

	public static EntryJDBC createEntry() {
		return new EntryJDBC();
	}
}
