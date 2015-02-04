package ar.com.ignacioflores.MeetingsManager.service;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ar.com.ignacioflores.MeetingsManager.domain.Attendee;
import ar.com.ignacioflores.MeetingsManager.domain.Meeting;
import ar.com.ignacioflores.MeetingsManager.domain.Room;

public class SimpleMeetingManagerTest {

	private SimpleMeetingManager meetingManager;
	private List<Meeting> meetings;
	
	private Meeting meeting1;
	private Meeting meeting2;
	private Meeting meeting3;
	ArrayList<Attendee> attendees = new ArrayList<Attendee>();
	private Attendee attendee1;
	private Attendee attendee2;
	private Room room1;
	private Room room2;
	String dateSlot1;
	String dateSlot2;
	String timeBefore1;
	String timeTo1;
	String timeBefore2;
	String timeTo2;
	
	@Before
	public void setUp() throws Exception {
		meetingManager = new SimpleMeetingManager();
        
        attendee1 = new Attendee();
        attendee1.setLastName("Gauna");
        attendee1.setFirstName("Mario");
        attendee1.setDateOfBirth("1992-11-12");
        
        attendee2 = new Attendee();
        attendee2.setLastName("Ferreyra");
        attendee2.setFirstName("Gustavo");
        attendee2.setDateOfBirth("1993-10-11");
        
        room1 = new Room();
        room1.setNameRoom("Presentation room");
        room1.setSize(12, 6);
        
        room2 = new Room();
        room2.setNameRoom("Conferenses room");
        room2.setSize(20, 10);
        
		dateSlot1 = "2015-02-12";
		dateSlot2 = "2015-02-13";
		
		timeBefore1 = "16:00";
		timeTo1 = "18:00";
        
		timeBefore2 = "17:00";
		timeTo2 = "18:00";
        
		meeting1 = new Meeting();
        meeting1.addAttendee(attendee1);
        meeting1.setRoom(room1);
        meeting1.setDateSlot(dateSlot1);
        meeting1.setTimeBefore(timeBefore1);
        meeting1.setTimeTo(timeTo1);
        
        meeting2 = new Meeting();
        meeting2.addAttendee(attendee1);
        meeting2.addAttendee(attendee2);
        meeting2.setRoom(room2);
        meeting2.setDateSlot(dateSlot2);
        meeting2.setTimeBefore(timeBefore2);
        meeting2.setTimeTo(timeTo2);
        
        meetings = new ArrayList<Meeting>();
        meetings.add(meeting1);
        meetings.add(meeting2);
        
        meetingManager.setMeetings(meetings);
	}
	
	@Test
	public void testGetMeetings() {
		List<Meeting> meetings = meetingManager.getMeetings();
		assertEquals(meeting1.toString(), meetings.get(0).toString());
		assertEquals(meeting2.toString(), meetings.get(1).toString());
	}
	@Test 
	public void testCreateMeeting() throws ParseException {
		attendees.add(attendee2);
		meeting3 = new Meeting();
        meeting3.addAttendee(attendee2);
        meeting3.setRoom(room1);
        meeting3.setDateSlot(dateSlot2);
        meeting3.setTimeBefore(timeBefore1);
        meeting3.setTimeTo(timeTo1);
		List<Meeting> meetings = meetingManager.getMeetings();
		assertEquals(2, meetings.size());
		meetingManager.createMeeting(attendees, room1, dateSlot2, timeBefore1, timeTo1);
		assertEquals(3, meetings.size());
		assertEquals(meeting3.toString(), meetings.get(2).toString());
	}
	@Test 
	public void testCancelMeeting() {
		List<Meeting> meetings = meetingManager.getMeetings();
		assertEquals(2, meetings.size());
		meetingManager.cancelMeeting(1);
		assertEquals(1, meetings.size()); 
	}
	@Test
	public void testUpdateMeeting() throws ParseException {
		
		attendees.add(attendee2);
		meeting3 = new Meeting();
        meeting3.addAttendee(attendee2);
        meeting3.setRoom(room1);
        meeting3.setDateSlot(dateSlot2);
        meeting3.setTimeBefore(timeBefore1);
        meeting3.setTimeTo(timeTo1);
		
		int oldMeetingTestInt = 0;
		Meeting oldMeetingTestMeeting = meetings.get(0);
		Meeting newMeetingTest = meeting3;
		
		meetingManager.updateMeeting(oldMeetingTestInt, newMeetingTest);
		assertEquals(newMeetingTest, meetings.get(0));
		
		oldMeetingTestMeeting = meetings.get(1);
		
		meetingManager.updateMeeting(oldMeetingTestMeeting, newMeetingTest);
		assertEquals(newMeetingTest, meetings.get(1));
	}
}
