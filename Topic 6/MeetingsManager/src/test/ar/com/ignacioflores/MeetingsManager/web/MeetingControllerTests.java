package ar.com.ignacioflores.MeetingsManager.web;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.com.ignacioflores.MeetingsManager.service.SimpleMeetingManager;

public class MeetingControllerTests {

	@Test
    public void testHandleRequestView() throws Exception{		
        MeetingController controller = new MeetingController();
        controller.setMeetingManager(new SimpleMeetingManager());
        ModelAndView modelAndView = controller.handleRequest(null, null);		
        assertEquals("hello", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        @SuppressWarnings("unchecked")
        Map<String, Object> modelMap = (Map<String, Object>) modelAndView.getModel().get("model");
        String nowValue = (String) modelMap.get("now");
        assertNotNull(nowValue);
    }

}
