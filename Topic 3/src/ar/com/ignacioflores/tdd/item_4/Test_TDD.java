package ar.com.ignacioflores.tdd.item_4;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test_TDD {

	@Test
	public void test() throws Exception {
		
		assertEquals("Test toRoman", "MMCCCXLV", Roman.toRoman(2345));
		
		assertEquals("Test toInt", 2345, Roman.toInt("MMCCCXLV"));
	}

}
