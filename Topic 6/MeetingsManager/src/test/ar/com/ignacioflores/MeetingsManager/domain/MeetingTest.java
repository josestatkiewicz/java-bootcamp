package ar.com.ignacioflores.MeetingsManager.domain;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class MeetingTest {

	private Meeting meeting;
	private Attendee attendee1;
	private Attendee attendee2;
	private Room room;
	
	@Before
    public void setUp() throws Exception {
        meeting = new Meeting();
        
        attendee1 = new Attendee();
        attendee1.setLastName("Gauna");
        attendee1.setFirstName("Mario");
        attendee1.setDateOfBirth("1992-11-12");
        
        attendee2 = new Attendee();
        attendee2.setLastName("Ferreyra");
        attendee2.setFirstName("Gustavo");
        attendee1.setDateOfBirth("1993-10-11");
        
        room = new Room();
        room.setNameRoom("Presentation room");
        room.setSize(12, 6);
    }

	@Test
    public void testId() {
		meeting.setMeetingId(1);
        assertEquals(1, meeting.getMeetingId());
    }
	
	@Test
    public void testAddAndGetAttendees() {
		ArrayList<Attendee> testAttendees = new ArrayList<Attendee>();
		testAttendees.add(attendee1);
		testAttendees.add(attendee2);
		
        meeting.addAttendee(attendee1);
        meeting.addAttendee(attendee2);
        assertEquals(testAttendees, meeting.getAttendees());
    }
	@Test
	public void testSetAndGetRoom() {
		Room testRoom = new Room();
		testRoom = room;
		
        meeting.setRoom(testRoom);
        assertEquals(testRoom, meeting.getRoom());
    }
	@Test
	public void testSetAndGetDateSlot() throws ParseException {
		String testDateSlot;
		testDateSlot = "2015-02-12";
		
        meeting.setDateSlot(testDateSlot);
        assertEquals(testDateSlot, meeting.getDateSlot());
    }
	@Test
	public void testSetAndGetTimeSlot() throws ParseException {
		String testTimeBefore = "16:00";
		String testTimeTo = "18:00";
		
        meeting.setTimeBefore(testTimeBefore);
        meeting.setTimeTo(testTimeTo);
        assertEquals(testTimeBefore, meeting.getTimeBefore());
        assertEquals(testTimeTo, meeting.getTimeTo());
    }
	@Test
	public void testToString() throws ParseException {
		ArrayList<Attendee> testAttendees = new ArrayList<Attendee>();
		testAttendees.add(attendee1);
		testAttendees.add(attendee2);
        meeting.addAttendee(attendee1);
        meeting.addAttendee(attendee2);
        
        Room testRoom = new Room();
		testRoom = room;
        meeting.setRoom(testRoom);
        
        String testDateSlot = "2015-02-12";
        meeting.setDateSlot(testDateSlot);
        
        String testTimeBefore = "16:00";
        String testTimeTo = "18:00";
        meeting.setTimeBefore(testTimeBefore);
        meeting.setTimeTo(testTimeTo);
		
		String testRes ="Meeting:" + "\n" + 
						"  Attendees:" + "\n" +
						"    " + testAttendees.get(0).getLastName().toUpperCase() + ", " + testAttendees.get(0).getFirstName() + "\n" +
						"    " + testAttendees.get(1).getLastName().toUpperCase() + ", " + testAttendees.get(1).getFirstName() + "\n" +
				 		"  Room:" + "\n" + 
						"    " + testRoom.getNameRoom() + "\n" +
						"  Date:" + "\n" +
						"    " + testDateSlot + "\n" +
						"  Time slot:" + "\n" +
						"    Before: " + testTimeBefore + "hs to " + testTimeTo + "hs";
		
        assertEquals(testRes, meeting.toString());
    }
	

}
