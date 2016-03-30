package app.factory;

import app.model.sets.OfferSet;

public class OfferSetFactory {
	
	/**
	 * Create a new OfferSet
	 * @return a default OfferSet
	 */
	public OfferSet createOfferSet(){
		return new OfferSet();
	}
		
}
