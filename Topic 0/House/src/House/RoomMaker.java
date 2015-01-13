package House;
import Classes.Room;

public class RoomMaker {
	
    private RoomBuilder roomBuilder;
 
    public void setRoomBuilder(RoomBuilder rb) { 
        roomBuilder = rb; 
    }
    public Room getRoom() { 
        return roomBuilder.getRoom(); 
    }
 
    public void makeRoom() {
       roomBuilder.createNewRoom();
       roomBuilder.buildName();
       roomBuilder.buildDimensions();
       roomBuilder.buildDescription();
    }
}
