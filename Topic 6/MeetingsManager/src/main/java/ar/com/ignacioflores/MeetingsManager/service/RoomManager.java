package ar.com.ignacioflores.MeetingsManager.service;

import java.io.Serializable;
import java.util.List;

import ar.com.ignacioflores.MeetingsManager.domain.Room;

public interface RoomManager extends Serializable {
	
	public void createRoom(int roomId, String nameRoom, float[] size);
	public void createRoom(int roomId, String nameRoom, float width, float lenght);
	public void createRoom(String nameRoom, float[] size);
	public void createRoom(String nameRoom, float width, float lenght);
	public List<Room> getRooms();
	public Room getRoom(int roomId);
	public void cancelRoom(int roomId);
	public void cancelRoom(Room room);
}
