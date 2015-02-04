package ar.com.ignacioflores.MeetingsManager.domain;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

public class AtendeeTest {

	private Attendee attendee;
		
	@Before
    public void setUp() throws Exception {
        attendee = new Attendee();
    }
	@Test
    public void testSetAndGetLastName() {
        String testLastName = "Gauna";
        attendee.setLastName(testLastName);
        assertEquals(testLastName, attendee.getLastName());
    }
	@Test
    public void testSetAndGetFirstName() {
        String testFirstName = "Marcos";
        attendee.setFirstName(testFirstName);
        assertEquals(testFirstName, attendee.getFirstName());
    }
	@Test
    public void testSetAndGetDateOfBirth() throws ParseException {
		String testDateOfBirth = "2015-02-14";
        attendee.setDateOfBirth("2015-02-14");
        assertEquals(testDateOfBirth, attendee.getDateOfBirth().toString());
    }
	@Test
	public void testToString() throws ParseException {
		String testLastName = "Gauna";
        attendee.setLastName(testLastName);
        String testFirstName = "Marcos";
        attendee.setFirstName(testFirstName);
        String testDateOfBirth = "2015-02-14";
        attendee.setDateOfBirth("2015-02-14");
        
		String testRes ="Attendee: " + testLastName.toUpperCase() + ", " + testFirstName + "\n" +
						"DateOfBirth: " + testDateOfBirth;
		assertEquals(testRes, attendee.toString());
	}
}
