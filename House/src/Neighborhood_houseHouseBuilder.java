public class Neighborhood_houseHouseBuilder extends HouseBuilder{
    public void buildM2land(){
        house.set_m2land(240);
    };
    public void buildM2house(){
        house.set_m2house(100);
    };
    public void buildBedrooms(){
        house.set_bedrooms(2);
    };
    public void buildBathrooms(){
        house.set_bathrooms(1);
    };
    public void buildGarages(){
        house.set_garages(0);
    };
    public void buildFloors(){
        house.set_floors(1);
    };
    public void buildAntiquity(){
        house.set_antiquity(0);
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
        house.set_rooms(rooms);
    };
    public void buildComforts(){
        Comfort[] comforts = {};
        house.set_comforts(comforts);
    };
    public void buildDescription(){
        house.set_description("A little Neighborhood house");
    };
}
