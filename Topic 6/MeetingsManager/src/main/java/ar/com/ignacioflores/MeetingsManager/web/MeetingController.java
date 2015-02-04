package ar.com.ignacioflores.MeetingsManager.web;

import java.io.IOException;
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

import ar.com.ignacioflores.MeetingsManager.service.MeetingManager;

@Controller
public class MeetingController {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private MeetingManager meetingManager;
	
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
	
	
	@RequestMapping(value = "/meetings/cancel/{id}", method = RequestMethod.DELETE)
	public @ResponseBody String cancelMeeting(@PathVariable("id") int meetingId) {
		meetingManager.getMeeting(meetingId);
        meetingManager.cancelMeeting(meetingId);
        return "redirect:/meetings";
	}
	
	
	public void setMeetingManager(MeetingManager meetingManager) {
		this.meetingManager = meetingManager;
	}
}