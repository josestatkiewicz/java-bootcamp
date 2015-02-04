package ar.com.ignacioflores.MeetingsManager.domain;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class RoomTest {

	private Room room;
	
	@Before
    public void setUp() throws Exception {
        room = new Room();
    }
	
	@Test
    public void testSetAndGetNameRoom() {
        String testNameRoom = "Room 1";
        room.setNameRoom(testNameRoom);
        assertEquals(testNameRoom, room.getNameRoom());
    }
	@Test
    public void testSetAndGetSize() {
        float[] testSize = {7,10};
        room.setSize(7,10);
        assertEquals(Arrays.toString(testSize), Arrays.toString(room.getSize()));
    }
	@Test
	public void testToString() {
		String testNameRoom = "Room 1";
        room.setNameRoom(testNameRoom);
        float[] testSize = {7,10};
        room.setSize(7,10);
		
		String testRes ="Name room:" + testNameRoom + "\n" + 
						"Size room: " + String.valueOf(testSize[0]) + " x " + String.valueOf(testSize[1]);
		assertEquals(testRes, room.toString());
	}

}
