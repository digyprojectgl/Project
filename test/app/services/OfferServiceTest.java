package app.services;

import app.model.Offer;
import app.model.Product;
import app.model.ProductCategory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created on 31/03/2016.
 *
 * @author Arthur
 */
public class OfferServiceTest {
    OfferService offerService;

    @Before
    public void setUp() throws Exception {
        offerService = new OfferService();

    }

    @Test
    public void deleteOffer() throws Exception {
        Offer offerTest = offerService.getAllOffers().getOffers().get(0);
        offerService.deleteOffer(offerTest);
        assertFalse("This offer is not inside the database",offerService.getAllOffers().getOffers().contains(offerTest));
        offerService.createOffer(offerTest.getIdUser(),new Product(offerTest.getLabelProduct(),"test", new ProductCategory("test"),"true"),offerTest.getPrice(), offerTest.getQuantity());
    }

    @Test
    public void updateOffer() throws Exception {
        Offer offerTest = offerService.getAllOffers().getOffers().get(0);
        offerService.updateOffer(offerTest, 1.1f, 1);
        assertTrue(offerService.getAllOffers().getOffers().get(0).getPrice() == 1.1f);
        assertTrue(offerService.getAllOffers().getOffers().get(0).getQuantity() == 1);
        offerService.updateOffer(offerTest, 2f, 2);
    }
}