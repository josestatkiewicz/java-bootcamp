package ar.com.ignacioflores.shoppingcart.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class _ProductTest {

	@Test
	public void ProductTest() {
		
		Product product = new Product();
		
		String testName = "T-shirt";
		String testDescription = "so cute";
		int testIdProduct = 1;
		double testPrice = 70;
		String testToString = 	"[id: " + testIdProduct + ", name: " + testName + 
							", description: " + testDescription + ", unit price: $" + testPrice + "]";
		
		product.setName(testName);
		product.setDescription(testDescription);
		product.setPrice(testPrice);
		
		assertEquals("Product Test get&set name", testName, product.getName());
		assertEquals("Product Test get&set description", testName, product.getName());
		assertEquals("Product Test get&set idProduct", testName, product.getName());
		assertEquals("Product Test get&set price", testName, product.getName());
		
		assertEquals("Product Test toString", testToString, String.valueOf(product));
			
	}

}
