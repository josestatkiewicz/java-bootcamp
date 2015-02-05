package ar.com.ignacioflores.MeetingsManager.domain;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Attendee implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static int id = 0;
	private int attendeeId;
	private String lastName;
	private String firstName;
	private SimpleDateFormat ftDate = new SimpleDateFormat("yyyy-MM-dd");
	private Date dateOfBirth = new Date();
	
	public Attendee() {
		super();
		this.attendeeId = id;
		id++;
	}
	public int getAttendeeId() {
		return attendeeId;
	}
	public void setAttendeeId(int attendeeId) {
		this.attendeeId = attendeeId;
	}
	public String getLastName() {
		return lastName.toUpperCase();
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getDateOfBirth() {
		return ftDate.format(dateOfBirth);
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) throws ParseException {
		this.dateOfBirth = ftDate.parse(dateOfBirth);
	}
	
	@Override
	public String toString() {
		return 	"Attendee: " + lastName + ", " + firstName + "\n" +
				"DateOfBirth: " + ftDate.format(dateOfBirth);
	}
	
	
}
