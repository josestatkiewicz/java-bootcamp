package ar.com.ignacioflores.MeetingsManager.service;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import ar.com.ignacioflores.MeetingsManager.domain.Attendee;
import ar.com.ignacioflores.MeetingsManager.domain.Meeting;
import ar.com.ignacioflores.MeetingsManager.domain.Room;

public interface MeetingManager extends Serializable{

	public void createMeeting(ArrayList<Attendee> attendees, Room room, Date dateSlot, Date timeBefore, Date timeTo);
	public void createMeeting(ArrayList<Attendee> attendees, Room room, String dateSlot, String timeBefore, String timeTo) throws ParseException;
	public void createMeeting(int meetingId, ArrayList<Attendee> attendees, Room room, Date dateSlot, Date timeBefore, Date timeTo);
	public void createMeeting(int meetingId, ArrayList<Attendee> attendees, Room room, String dateSlot, String timeBefore, String timeTo) throws ParseException;
	public List<Meeting> getMeetings();
	public Meeting getMeeting(int meetingId);
	public void cancelMeeting(Meeting meeting);
	public void cancelMeeting(int meeting);
	public void updateMeeting(Meeting oldMeeting, Meeting newMeeting);
	public void updateMeeting(int oldMeeting, Meeting newMeeting);
}
