package ar.com.ignacioflores.MeetingsManager.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import ar.com.ignacioflores.MeetingsManager.domain.Attendee;

public class SimpleAttendeeManager implements AttendeesManager{

	private static final long serialVersionUID = 1L;
	private List<Attendee> attendees;
	
	public void createAttendee(int id, String lastName, String firstName, String dateOfBirth) throws ParseException {
		Attendee attendee = new Attendee();
		attendee.setAttendeeId(id);
		attendee.setLastName(lastName);
		attendee.setFirstName(firstName);
		attendee.setDateOfBirth(dateOfBirth);
		
		attendees.add(attendee);
	}
	
	public void createAttendee(int id, String lastName, String firstName, Date dateOfBirth) {
		Attendee attendee = new Attendee();
		attendee.setAttendeeId(id);
		attendee.setLastName(lastName);
		attendee.setFirstName(firstName);
		attendee.setDateOfBirth(dateOfBirth);
		
		attendees.add(attendee);
	}

	public void createAttendee(String lastName, String firstName, String dateOfBirth) throws ParseException {
		Attendee attendee = new Attendee();
		attendee.setLastName(lastName);
		attendee.setFirstName(firstName);
		attendee.setDateOfBirth(dateOfBirth);
		
		attendees.add(attendee);
	}

	public void createAttendee(String lastName, String firstName, Date dateOfBirth) {
		Attendee attendee = new Attendee();
		attendee.setLastName(lastName);
		attendee.setFirstName(firstName);
		attendee.setDateOfBirth(dateOfBirth);
		
		attendees.add(attendee);
	}

	public Attendee getAttendee(int attendeeId) {
		Attendee res = null;
		for (int i=0; i<attendees.size(); i++) {
			if (attendees.get(i).getAttendeeId() == attendeeId) {
				res = attendees.get(i);
			}
		}
		return res;
	}

	public void cancelAttendee(int attendee) {
		Attendee res = null;
		for (int i=0; i<attendees.size(); i++) {
			if (attendees.get(i).getAttendeeId() == attendee) {
				res = attendees.get(i);
			}
			attendees.remove(res);
		}
	}

	public void cancelAttendee(Attendee attendee) {
		attendees.remove(attendee);
		
	}

	public List<Attendee> getAttendees() {
		return attendees;
	}

	public void setAttendees(List<Attendee> attendees) {
		this.attendees = attendees;
	}

	
}
