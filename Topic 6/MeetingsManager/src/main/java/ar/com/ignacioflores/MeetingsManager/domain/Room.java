package ar.com.ignacioflores.MeetingsManager.domain;

import java.io.Serializable;

public class Room implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static int id = 0;
	private int roomId;
	private String nameRoom;
	private float[] size = new float[2];
	
	
	public Room() {
		super();
		this.roomId = id;
		id = id+1;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getNameRoom() {
		return nameRoom;
	}
	public void setNameRoom(String nameRoom) {
		this.nameRoom = nameRoom;
	}
	public float[] getSize() {
		return size;
	}
	public void setSize(float width, float lenght) {
		this.size[0] = width;
		this.size[1] = lenght;
	}
	public void setSize(float[] size) {
		this.size[0] = size[0];
		this.size[1] = size[1];
	}
	@Override
	public String toString() {
		return	"Name room:" + nameRoom + "\n" + 
				"Size room: " + String.valueOf(size[0]) + " x " + String.valueOf(size[1]);
	}
}
