public class Main {
    public static void main(String[] args) {
        
        HouseBuilder houseBuilder = new HouseBuilder() {
            public void buildM2land() {
                house.set_m2land(300);
            }
            public void buildM2house() {
                house.set_m2house(200);
            }
            public void buildBedrooms() {
                house.set_bedrooms(3);
            }
            public void buildBathrooms() {
                house.set_bathrooms(2);
            }
            public void buildGarages() {
                house.set_garages(1);
            }
            public void buildFloors() {
                house.set_floors(1);
            }
            public void buildAntiquity() {
                house.set_antiquity(10);
            }
            public void buildRooms() {
                
                // Not using a room object
                RoomBuilder roomBuilder = new RoomBuilder() {
                    
                    public void buildName() {
                        room.set_name("Living");
                    }
                    public void buildDimensions() {
                        room.set_dimensions(5, 4);
                    }
                    public void buildDescription() {
                        room.set_description("so cute");
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
                
                
                house.set_rooms(rooms);
            }
            public void buildComforts() {
                
                
                // Not using a comfort object
                ComfortBuilder comfortBuilder = new ComfortBuilder() {
                    public void buildName() {
                        comfort.set_name("Pool");
                    }
                    public void buildDescription() {
                        comfort.set_description("so big");
                    }
                };
                ComfortMaker comfortMaker = new ComfortMaker();
                comfortMaker.setComfortBuilder(comfortBuilder);
                comfortMaker.makeComfort();
                
                
                 // Using Central_heatingComfortBuilder
                ComfortBuilder comfortBuilder1 = new Central_heatingComfortBuilder();
                ComfortMaker comfortMaker1 = new ComfortMaker();
                comfortMaker1.setComfortBuilder(comfortBuilder1);
                comfortMaker1.makeComfort();
                
                Comfort[] comforts = {comfortMaker.getComfort(), comfortMaker1.getComfort()};

                
                house.set_comforts(comforts);
            }
            public void buildDescription() {
                house.set_description("so cute");
            }
        };
        HouseMaker houseMaker = new HouseMaker();
        houseMaker.setHouseBuilder(houseBuilder);
        houseMaker.makeHouse();
        House house = houseMaker.getHouse();
        
        System.out.println(house);
        
        //using a Neighborhood_houseHouseBuilder
        HouseBuilder houseBuilder1 = new Neighborhood_houseHouseBuilder();
        HouseMaker houseMaker1 = new HouseMaker();
        houseMaker1.setHouseBuilder(houseBuilder1);
        houseMaker1.makeHouse();
        House house1 = houseMaker1.getHouse();
        
        System.out.println(house1);
    }
}
