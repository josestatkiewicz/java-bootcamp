package ar.com.ignacioflores.tdd.Item_2;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

public class _TestTDD {

	@Test
	public void WordWrappingTest() {
		WordWrapping element = new WordWrapping();
		ArrayList<String> expected;
		
		expected = new ArrayList<String>();
		expected.add("The lenght of this string is30");
		assertEquals("Test WordWrapping 1", expected, element.wrap("The lenght of this string is30", 60));
		
		expected = new ArrayList<String>();
		expected.add("Hello");
		expected.add("Word!");
		assertEquals("Test WordWrapping 2", expected, element.wrap("Hello Word!", 7));
		
		expected = new ArrayList<String>();
		expected.add("a b");
		expected.add("c d");
		expected.add("e f");
		assertEquals("Test WordWrapping 3", expected, element.wrap("a b c d e f", 3));
		
		expected = new ArrayList<String>();
		expected.add("Excel");
		expected.add("ent");
		assertEquals("Test WordWrapping 2", expected, element.wrap("Excelent", 5));
		
	}
}
