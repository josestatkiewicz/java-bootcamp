package ar.com.ignacioflores.shoppingcart.domain;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class _UserTest {

	@Test
	public void test() {
		User user = new User();
		
		int testIdUser = 1;
		String testPassword = "pass";
		String testName = "Ignacio";
		String testLastName = "Flores";
		String testEmail = "ignacioflores@outlook.com";
		BigInteger testPhone = BigInteger.valueOf(Long.parseLong("3624783183"));
		
		user.setPassword(testPassword);
		user.setName(testName);
		user.setLastName(testLastName);
		user.setEmail(testEmail);
		user.setPhone(testPhone);
		
		String testToString = 	"User: " + testLastName.toUpperCase() + ", " + testName + "\n" +
								"UserId: " + testIdUser + "\n" +
								"Email: " + testEmail + "\n" +
								"Phone: " + testPhone;
		
		assertEquals("Product Test toString", testToString, String.valueOf(user));
	}

}
