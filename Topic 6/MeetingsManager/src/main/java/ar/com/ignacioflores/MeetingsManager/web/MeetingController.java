package ar.com.ignacioflores.MeetingsManager.web;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ar.com.ignacioflores.MeetingsManager.domain.Attendee;
import ar.com.ignacioflores.MeetingsManager.domain.Room;
import ar.com.ignacioflores.MeetingsManager.service.AttendeesManager;
import ar.com.ignacioflores.MeetingsManager.service.MeetingManager;
import ar.com.ignacioflores.MeetingsManager.service.RoomManager;

@Controller
public class MeetingController {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private MeetingManager meetingManager;
	@Autowired
	private AttendeesManager attendeeManager;
	@Autowired
	private RoomManager roomManager;
	
	@RequestMapping(value = "/meetings")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

        Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("meetings", this.meetingManager.getMeetings());
        
        return new ModelAndView("meetings", "model", myModel);
        
	}
	
	@RequestMapping(value = "/meetings/{id}", method = RequestMethod.GET)
	public @ResponseBody String getMeeting(@PathVariable("id") int meetingId) {
        
        return meetingManager.getMeeting(meetingId).toString();
        
	}

	@RequestMapping(value = "/meetings/cancel/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
	public @ResponseBody void cancelMeeting(@PathVariable("id") int meetingId) {
        meetingManager.cancelMeeting(meetingId);
	}
	
	@RequestMapping(value = "/meetings/create/{id}/{attendees}/{room}/{dateSlot}/{timeBefore}/{timeTo}", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody void createMeeting(@PathVariable("id") int meetingId,
								    		@PathVariable("attendees") int[] attendeesIds,
								    		@PathVariable("room") int roomId,
								    		@PathVariable("dateSlot") String dateSlot,
								    		@PathVariable("timeBefore") String timeBefore ,
								    		@PathVariable("timeTo") String timeTo) throws ParseException {
		ArrayList<Attendee> attendees = new ArrayList<Attendee>();
		for (int i : attendeesIds) {
			attendees.add(attendeeManager.getAttendee(i));
		}
		Room room = roomManager.getRoom(roomId);
		meetingManager.createMeeting(meetingId, attendees, room, dateSlot, timeBefore, timeTo);
    }
	
	@RequestMapping(value = "/meetings/update/{id}/{attendees}/{room}/{dateSlot}/{timeBefore}/{timeTo}", method = {RequestMethod.GET, RequestMethod.PUT})
    public @ResponseBody void updateMeeting(@PathVariable("id") int meetingId,
								    		@PathVariable("attendees") int[] attendeesIds,
								    		@PathVariable("room") int roomId,
								    		@PathVariable("dateSlot") String dateSlot,
								    		@PathVariable("timeBefore") String timeBefore ,
								    		@PathVariable("timeTo") String timeTo) throws ParseException {
		ArrayList<Attendee> attendees = new ArrayList<Attendee>();
		for (int i : attendeesIds) {
			attendees.add(attendeeManager.getAttendee(i));
		}
		Room room = roomManager.getRoom(roomId);
		if (attendeesIds != null) {
			meetingManager.getMeeting(meetingId).setAttendees(attendees);
		}
		if (room != null) {
			meetingManager.getMeeting(meetingId).setRoom(room);
		}
		if (dateSlot != null) {
			meetingManager.getMeeting(meetingId).setDateSlot(dateSlot);
		}
		if (timeBefore != null) {
			meetingManager.getMeeting(meetingId).setTimeBefore(timeBefore);
		}
		if (timeTo != null) {
			meetingManager.getMeeting(meetingId).setTimeTo(timeTo);
		}
    }
	
	public void setMeetingManager(MeetingManager meetingManager) {
		this.meetingManager = meetingManager;
	}
}