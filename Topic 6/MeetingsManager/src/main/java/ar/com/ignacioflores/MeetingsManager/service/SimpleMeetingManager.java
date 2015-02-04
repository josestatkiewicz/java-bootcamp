package ar.com.ignacioflores.MeetingsManager.service;

import java.text.ParseException;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import ar.com.ignacioflores.MeetingsManager.domain.Attendee;
import ar.com.ignacioflores.MeetingsManager.domain.Meeting;
import ar.com.ignacioflores.MeetingsManager.domain.Room;

public class SimpleMeetingManager implements MeetingManager {

	private static final long serialVersionUID = 1L;
	private List<Meeting> meetings;

	public void setMeetings(List<Meeting> meetings) {
		this.meetings = meetings;
	}

	public List<Meeting> getMeetings() {
		return meetings;
	}

	public Meeting getMeeting(int meetingId) {
		Meeting res = null;
		for (int i=0; i<meetings.size(); i++) {
			if (meetings.get(i).getMeetingId() == meetingId) {
				res = meetings.get(i);
			}
		}
		return res;
	}; 
	
	public void createMeeting(ArrayList<Attendee> attendees, Room room, Date dateSlot, Date timeBefore, Date timeTo) {
		
		Meeting meeting = new Meeting();
		
		for (int i=0; i<attendees.size(); i++) {
			meeting.addAttendee(attendees.get(i));
		}
		meeting.setRoom(room);
		meeting.setDateSlot(dateSlot);
		meeting.setTimeBefore(timeBefore);
		meeting.setTimeTo(timeTo);
		meetings.add(meeting);
	}
	
	public void createMeeting(int meetingId, ArrayList<Attendee> attendees, Room room, Date dateSlot, Date timeBefore, Date timeTo) {
		Meeting meeting = new Meeting();
		
		meeting.setMeetingId(meetingId);
		for (int i=0; i<attendees.size(); i++) {
			meeting.addAttendee(attendees.get(i));
		}
		meeting.setRoom(room);
		meeting.setDateSlot(dateSlot);
		meeting.setTimeBefore(timeBefore);
		meeting.setTimeTo(timeTo);
		meetings.add(meeting);
	}
	
	public void createMeeting(ArrayList<Attendee> attendees, Room room, String dateSlot, String timeBefore, String timeTo) throws ParseException {
		
		Meeting meeting = new Meeting();
		
		for (int i=0; i<attendees.size(); i++) {
			meeting.addAttendee(attendees.get(i));
		}
		meeting.setRoom(room);
		meeting.setDateSlot(dateSlot);
		meeting.setTimeBefore(timeBefore);
		meeting.setTimeTo(timeTo);
		meetings.add(meeting);
	}
	
	public void createMeeting(int meetingId, ArrayList<Attendee> attendees, Room room, String dateSlot, String timeBefore, String timeTo) throws ParseException {
		
		Meeting meeting = new Meeting();
		
		meeting.setMeetingId(meetingId);
		for (int i=0; i<attendees.size(); i++) {
			meeting.addAttendee(attendees.get(i));
		}		
		meeting.setRoom(room);
		meeting.setDateSlot(dateSlot);
		meeting.setTimeBefore(timeBefore);
		meeting.setTimeTo(timeTo);
		meetings.add(meeting);
	}
	
	public void cancelMeeting(Meeting meeting) {
		meetings.remove(meeting);
	}
	
	public void cancelMeeting(int meeting) {
		meetings.remove(meeting);
	}
	
	public void updateMeeting(Meeting oldMeeting, Meeting newMeeting) {
		int index = meetings.indexOf(oldMeeting);
		meetings.remove(oldMeeting);
		meetings.add(index, newMeeting);
	}
	
	public void updateMeeting(int oldMeeting, Meeting newMeeting) {
		meetings.remove(oldMeeting);
		meetings.add(oldMeeting, newMeeting);
	}
}
