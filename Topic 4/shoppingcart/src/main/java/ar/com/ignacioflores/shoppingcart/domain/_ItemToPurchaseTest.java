package ar.com.ignacioflores.shoppingcart.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class _ItemToPurchaseTest {

	@Test
	public void ItemToPurchaseTest() {
		
		Product testProduct = new Product("T-shirt", "XL", 70);
		int testQuantity = 3;
		double testPrice = 210;
		String testToString = 	testProduct + "\n" + 
								"Quantity: " + testQuantity + "\n" + 
								"Price: $" + testPrice;
		
		ItemToPurchase itemToPurchase = new ItemToPurchase();
		
		itemToPurchase.setProduct(testProduct);
		itemToPurchase.setQuantity(3);
		
		assertEquals("ItemToPurchase Test get&set product", testProduct, itemToPurchase.getProduct());
		assertEquals("ItemToPurchase Test get&set quantity", testQuantity, itemToPurchase.getQuantity());
		assertEquals("ItemToPurchase Test get&set price", String.valueOf(testPrice), String.valueOf(itemToPurchase.getPrice()));
		
		assertEquals("ItemToPurchase Test toString", testToString, String.valueOf(itemToPurchase));
	}

}
