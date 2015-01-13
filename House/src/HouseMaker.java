public class HouseMaker {
    private HouseBuilder houseBuilder;
 
    public void setHouseBuilder(HouseBuilder hb) { 
        houseBuilder = hb; 
    }
    public House getHouse() { 
        return houseBuilder.getHouse(); 
    }
 
    public void makeHouse() {
        houseBuilder.createNewHouse();
        houseBuilder.buildM2land();
        houseBuilder.buildM2house();
        houseBuilder.buildBedrooms();
        houseBuilder.buildBathrooms();
        houseBuilder.buildGarages();
        houseBuilder.buildFloors();
        houseBuilder.buildAntiquity();
        houseBuilder.buildRooms();
        houseBuilder.buildComforts();
        houseBuilder.buildDescription();
    }
}
