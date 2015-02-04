package ar.com.ignacioflores.MeetingsManager.domain;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

public class Meeting implements Serializable{

	private static final long serialVersionUID = 1L;

	private static int id = 0;
	private int meetingId;
	private ArrayList<Attendee> attendees = new ArrayList<Attendee>();
	private Room room;
	private SimpleDateFormat ftDate = new SimpleDateFormat("yyyy-MM-dd");
	private Date dateSlot = new Date();
	private SimpleDateFormat ftTime = new SimpleDateFormat("HH:mm"); 
	private Date timeBefore = new Date();
	private Date timeTo = new Date();
	
	
	public Meeting() {
		super();
		this.meetingId = id;
		id = id+1;
	}
	public int getMeetingId() {
		return meetingId;
	}
	public void setMeetingId(int meetingId) {
		this.meetingId = meetingId;
	}
	public ArrayList<Attendee> getAttendees() {
		return attendees;
	}
	public void addAttendee(Attendee attendee) {
		this.attendees.add(attendee);
	}
	public void setAttendees(ArrayList<Attendee> attendees) {
		this.attendees = attendees;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public String getDateSlot() {
		return ftDate.format(dateSlot);
	}
	public void setDateSlot(Date dateSlot) {
		this.dateSlot = dateSlot;
	}
	public void setDateSlot(String dateSlot) throws ParseException {		
		this.dateSlot = ftDate.parse(dateSlot);	
	}
	public String getTimeBefore() {
		return ftTime.format(timeBefore);
	}
	public void setTimeBefore(Date timeBefore) {
		this.timeBefore = timeBefore;
	}
	public void setTimeBefore(String timeBefore) throws ParseException {
		this.timeBefore = ftTime.parse(timeBefore);
	}
	public String getTimeTo() {
		return ftTime.format(timeTo);
	}
	public void setTimeTo(Date timeTo) {
		this.timeTo = timeTo;
	}
	public void setTimeTo(String timeTo) throws ParseException {
		this.timeTo = ftTime.parse(timeTo);
	}	
	
	@Override
	public String toString() {
		return 	"Meeting:" + "\n" + 
				"  Attendees:" + "\n" +
				showAttendees() +
		 		"  Room:" + "\n" + 
				"    " + room.getNameRoom().toString() + "\n" +
				"  Date:" + "\n" +
				"    " + ftDate.format(dateSlot) + "\n" +
				"  Time slot:" + "\n" +
				"    Before: " + ftTime.format(timeBefore) + "hs to " + ftTime.format(timeTo) + "hs";
	}
	
	private String showAttendees() {
		
		String res = ""; 
		for (int i=0; i<attendees.size(); i++) {
			res = 	res + "    " + 
					attendees.get(i).getLastName().toUpperCase() + ", " + attendees.get(i).getFirstName() + "\n";
		}
		return res;
	}
}
