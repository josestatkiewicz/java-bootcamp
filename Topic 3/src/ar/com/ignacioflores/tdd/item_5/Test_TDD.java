package ar.com.ignacioflores.tdd.item_5;

import static org.junit.Assert.*;
import org.junit.Test;

public class Test_TDD {

	@Test
	public void test() {
		assertEquals("Test toRoman", "A220", Soundex.toSoundex("Aeshahs"));
	}

}
