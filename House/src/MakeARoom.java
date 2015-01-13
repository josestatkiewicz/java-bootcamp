public class MakeARoom {
    RoomBuilder abstractRoom;
 
    public MakeARoom(RoomBuilder abstractRoom) {
        this.abstractRoom = abstractRoom;
        abstractRoom.buildName();
        abstractRoom.buildDimensions();
        abstractRoom.buildDescription();
    }   

    public Room seeRoom(){
        return abstractRoom.getRoom();
    }
}