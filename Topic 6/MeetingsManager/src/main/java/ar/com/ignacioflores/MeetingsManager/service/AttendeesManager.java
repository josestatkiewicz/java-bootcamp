package ar.com.ignacioflores.MeetingsManager.service;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import ar.com.ignacioflores.MeetingsManager.domain.Attendee;

public interface AttendeesManager extends Serializable {
	
	public void createAttendee(int id, String lastName, String firstName, String dateOfBirth) throws ParseException;
	public void createAttendee(int id, String lastName, String firstName, Date dateOfBirth);
	public void createAttendee(String lastName, String firstName, String dateOfBirth) throws ParseException;
	public void createAttendee(String lastName, String firstName, Date dateOfBirth);
	public List<Attendee> getAttendees();
	public Attendee getAttendee(int attendeeId);
	public void cancelAttendee(int attendee);
	public void cancelAttendee(Attendee attendee);
}
