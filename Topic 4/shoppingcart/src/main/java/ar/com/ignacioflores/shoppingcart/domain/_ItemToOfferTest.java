package ar.com.ignacioflores.shoppingcart.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class _ItemToOfferTest {

	@Test
	public void ItemToOfferTest() {
		
		Product testProduct = new Product("T-shirt", "XL", 70);
		int testQuantity = 3;
		String testToString = 	testProduct + "\n" + 
								"Quantity: " + testQuantity;
		
		ItemToOffer itemToOffer = new ItemToOffer();
		
		itemToOffer.setItem(testProduct);
		itemToOffer.setQuantity(3);
		
		assertEquals("ItemToPurchase Test get&set product", testProduct, itemToOffer.getItem());
		assertEquals("ItemToPurchase Test get&set quantity", testQuantity, itemToOffer.getQuantity());
		
		assertEquals("ItemToPurchase Test toString", testToString, String.valueOf(itemToOffer));
	}

}
