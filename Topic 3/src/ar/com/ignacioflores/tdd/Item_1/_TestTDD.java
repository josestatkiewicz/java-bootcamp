package ar.com.ignacioflores.tdd.Item_1;

import static org.junit.Assert.*;

import org.junit.Test;

public class _TestTDD {

	@Test
	public void ParsingMoneyTest() {
		
		ParsingMoney number = new ParsingMoney();
		assertEquals(	"Number to String", "two thousand five hundred twenty-three and 04/100 dollars", 
						number.toString(2523.04));
	}
}
