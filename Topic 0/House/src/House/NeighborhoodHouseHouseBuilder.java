package House;
import Classes.Comfort;
import Classes.Room;

public class NeighborhoodHouseHouseBuilder extends HouseBuilder{
    public void buildM2land(){
        house.setM2land(240);
    };
    public void buildM2house(){
        house.setM2house(100);
    };
    public void buildBedrooms(){
        house.setBedrooms(2);
    };
    public void buildBathrooms(){
        house.setBathrooms(1);
    };
    public void buildGarages(){
        house.setGarages(0);
    };
    public void buildFloors(){
        house.setFloors(1);
    };
    public void buildAntiquity(){
        house.setAntiquity(0);
    };
    public void buildRooms(){
        RoomBuilder roomBuilder1 = new BedroomRoomBuilder();
        RoomMaker roomMaker1 = new RoomMaker();
        roomMaker1.setRoomBuilder(roomBuilder1);
        roomMaker1.makeRoom();
        RoomBuilder roomBuilder2 = new BedroomRoomBuilder();
        RoomMaker roomMaker2 = new RoomMaker();
        roomMaker2.setRoomBuilder(roomBuilder2);
        roomMaker2.makeRoom();
        Room[] rooms = {roomMaker1.getRoom(), roomMaker2.getRoom()};
        house.setRooms(rooms);
    };
    public void buildComforts(){
        Comfort[] comforts = {};
        house.setComforts(comforts);
    };
    public void buildDescription(){
        house.setDescription("A little Neighborhood house");
    };
}
