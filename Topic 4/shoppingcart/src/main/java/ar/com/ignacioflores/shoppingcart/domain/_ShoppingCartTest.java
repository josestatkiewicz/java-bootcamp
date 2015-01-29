package ar.com.ignacioflores.shoppingcart.domain;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class _ShoppingCartTest {

	@Test
	public void ShoppingCartTest() {
		
		ShoppingCart shoppingCart = new ShoppingCart();
		
		User testUser = new User();
		
		String testPassword = "pass";
		String testName = "Ignacio";
		String testLastName = "Flores";
		String testEmail = "ignacioflores@outlook.com";
		BigInteger testPhone = BigInteger.valueOf(Long.parseLong("3624783183"));
		
		testUser.setPassword(testPassword);
		testUser.setName(testName);
		testUser.setLastName(testLastName);
		testUser.setEmail(testEmail);
		testUser.setPhone(testPhone);
		
		shoppingCart.setUser(testUser);
		
		Product testProduct1 = new Product("T-shirt", "XL", 70);
		Product testProduct2 = new Product("Jacket", "XL", 170);
		Product testProduct3 = new Product("Jeans", "XL", 100);
		
		int testQuantity1 = 3;
		int testQuantity2 = 2;
		int testQuantity3= 2;
				
		double testAmount = 650;
		
		ItemToPurchase itemToPurchase1 = new ItemToPurchase(testProduct1, testQuantity1);
		ItemToPurchase itemToPurchase2 = new ItemToPurchase(testProduct2, testQuantity2);
		ItemToPurchase itemToPurchase3 = new ItemToPurchase(testProduct3, testQuantity3);
		
		shoppingCart.addItem(itemToPurchase1);
		shoppingCart.addItem(itemToPurchase2);
		shoppingCart.addItem(itemToPurchase3);
		
		shoppingCart.removeItem(itemToPurchase3);
		
		Offer offer1 = new Offer();
		
		ItemToOffer itemToOffer1 = new ItemToOffer(testProduct3, testQuantity3);
		double offerPriceTest = 100; 
		String offerDescriptionTest = "one jean free";
		
		offer1.addItem(itemToOffer1);
		offer1.setPrice(offerPriceTest);
		offer1.setDescription(offerDescriptionTest);
		
		shoppingCart.addOffer(offer1);
		
		String testToString = 	"ShoppingCart" + "\n" + 
								"User: " + testUser + "\n" +
								"Items:" + "\n" + 
								itemToPurchase1 + "\n" + 
								itemToPurchase2 + "\n" +
								"Offers:" + "\n" + 
								offer1 + "\n" +
								"Amount: $"+ testAmount;
		
		assertEquals("ShoppingCart Test toString", testToString, String.valueOf(shoppingCart));
		
	}

}
