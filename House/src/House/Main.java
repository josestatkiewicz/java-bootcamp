package House;
import Classes.Comfort;
import Classes.House;
import Classes.Room;

public class Main {
    public static void main(String[] args) {
        
        HouseBuilder houseBuilder = new HouseBuilder() {
            public void buildM2land() {
                house.setM2land(300);
            }
            public void buildM2house() {
                house.setM2house(200);
            }
            public void buildBedrooms() {
                house.setBedrooms(3);
            }
            public void buildBathrooms() {
                house.setBathrooms(2);
            }
            public void buildGarages() {
                house.setGarages(1);
            }
            public void buildFloors() {
                house.setFloors(1);
            }
            public void buildAntiquity() {
                house.setAntiquity(10);
            }
            public void buildRooms() {
                
                // Not using a room object
                RoomBuilder roomBuilder = new RoomBuilder() {
                    
                    public void buildName() {
                        room.setName("Living");
                    }
                    public void buildDimensions() {
                        room.setDimensions(5, 4);
                    }
                    public void buildDescription() {
                        room.setDescription("so cute");
                    }
                };
                RoomMaker roomMaker = new RoomMaker();
                roomMaker.setRoomBuilder(roomBuilder);
                roomMaker.makeRoom();
                
                
                // Using BedroomRoomBuilder
                RoomBuilder roomBuilder1 = new BedroomRoomBuilder();
                RoomMaker roomMaker1 = new RoomMaker();
                roomMaker1.setRoomBuilder(roomBuilder1);
                roomMaker1.makeRoom();
                
                
                Room[] rooms = {roomMaker.getRoom(), roomMaker1.getRoom()};
                
                
                house.setRooms(rooms);
            }
            public void buildComforts() {
                
                // Not using a comfort object
                ComfortBuilder comfortBuilder = new ComfortBuilder() {
                    public void buildName() {
                        comfort.setName("Pool");
                    }
                    public void buildDescription() {
                        comfort.setDescription("so big");
                    }
                };
                ComfortMaker comfortMaker = new ComfortMaker();
                comfortMaker.setComfortBuilder(comfortBuilder);
                comfortMaker.makeComfort();
                
                
                 // Using CentralHeatingComfortBuilder
                ComfortBuilder comfortBuilder1 = new CentralHeatingComfortBuilder();
                ComfortMaker comfortMaker1 = new ComfortMaker();
                comfortMaker1.setComfortBuilder(comfortBuilder1);
                comfortMaker1.makeComfort();
                
                Comfort[] comforts = {comfortMaker.getComfort(), comfortMaker1.getComfort()};

                
                house.setComforts(comforts);
            }
            public void buildDescription() {
                house.setDescription("so cute");
            }
        };
        HouseMaker houseMaker = new HouseMaker();
        houseMaker.setHouseBuilder(houseBuilder);
        houseMaker.makeHouse();
        House house = houseMaker.getHouse();
        
        System.out.println(house);
        
        //using a NeighborhoodHouseHouseBuilder
        HouseBuilder houseBuilder1 = new NeighborhoodHouseHouseBuilder();
        HouseMaker houseMaker1 = new HouseMaker();
        houseMaker1.setHouseBuilder(houseBuilder1);
        houseMaker1.makeHouse();
        House house1 = houseMaker1.getHouse();
        
        System.out.println(house1);
    }
}
