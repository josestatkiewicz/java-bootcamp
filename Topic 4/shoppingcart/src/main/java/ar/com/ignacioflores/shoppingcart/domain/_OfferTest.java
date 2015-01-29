package ar.com.ignacioflores.shoppingcart.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class _OfferTest {

	@Test
	public void OfferTest() {
		
		Offer offer = new Offer();
		
		Product testProduct1 = new Product("T-shirt", "XL", 70);
		Product testProduct2 = new Product("Jacket", "XL", 170);
		Product testProduct3 = new Product("Jeans", "XL", 100);
		
		int testQuantity1 = 3;
		int testQuantity2 = 2;
		int testQuantity3= 2;
		
		double testPrice = 480;
		
		String testDescription = "T-shirt free";
		
		ItemToOffer itemToOffer1 = new ItemToOffer(testProduct1, testQuantity1);
		ItemToOffer itemToOffer2 = new ItemToOffer(testProduct2, testQuantity2);
		ItemToOffer itemToOffer3 = new ItemToOffer(testProduct3, testQuantity3);
		
		offer.addItem(itemToOffer1);
		offer.addItem(itemToOffer2);
		offer.addItem(itemToOffer3);
		
		offer.removeItem(itemToOffer3);
		
		offer.setPrice(testPrice);
		offer.setDescription(testDescription);
		
		String testToString = 	"Offer items:"+ "\n" + 
								itemToOffer1 + "\n" + 
								itemToOffer2 + "\n" + 
								"Offer description: " + testDescription + "\n" + 
								"Offer price: $" + testPrice; 
		
		assertEquals("Offer Test toString", testToString, String.valueOf(offer));
	}
}
