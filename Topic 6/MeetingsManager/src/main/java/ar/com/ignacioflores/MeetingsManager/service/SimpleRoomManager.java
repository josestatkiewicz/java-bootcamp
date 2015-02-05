package ar.com.ignacioflores.MeetingsManager.service;

import java.util.List;

import ar.com.ignacioflores.MeetingsManager.domain.Room;

public class SimpleRoomManager implements RoomManager {

	private static final long serialVersionUID = 1L;
	private List<Room> rooms;
	
	public void createRoom(int roomId, String nameRoom, float[] size) {
		Room room = new Room();
		room.setRoomId(roomId);
		room.setNameRoom(nameRoom);
		room.setSize(size);
		rooms.add(room);
	}

	public void createRoom(String nameRoom, float[] size) {
		Room room = new Room();
		room.setNameRoom(nameRoom);
		room.setSize(size);
		rooms.add(room);
	}

	public void createRoom(int roomId, String nameRoom, float width, float lenght) {
		Room room = new Room();
		room.setRoomId(roomId);
		room.setNameRoom(nameRoom);
		room.setSize(width, lenght);
		rooms.add(room);
	}
	
	public void createRoom(String nameRoom, float width, float lenght) {
		Room room = new Room();
		room.setNameRoom(nameRoom);
		room.setSize(width, lenght);
		rooms.add(room);
	}
	
	public List<Room> getRooms() {
		return rooms;
	}
	
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public Room getRoom(int roomId) {
		Room res = null;
		for (int i=0; i<rooms.size(); i++) {
			if (rooms.get(i).getRoomId() == roomId) {
				res = rooms.get(i);
			}
		}
		return res;
	}

	public void cancelRoom(int roomId) {
		for (int i=0; i<rooms.size(); i++) {
			if (rooms.get(i).getRoomId() == roomId) {
				rooms.remove(i);
			}
		}
	}

	public void cancelRoom(Room room) {
		rooms.remove(room);
	}

}
