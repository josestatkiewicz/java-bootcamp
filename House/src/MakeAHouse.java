public class MakeAHouse {
    HouseBuilder abstractHouse;
 
    public MakeAHouse(HouseBuilder abstractHouse) {
        this.abstractHouse = abstractHouse;
        abstractHouse.buildM2land();
        abstractHouse.buildM2house();
        abstractHouse.buildBedrooms();
        abstractHouse.buildBathrooms();
        abstractHouse.buildGarages();
        abstractHouse.buildFloors();
        abstractHouse.buildAntiquity();
        abstractHouse.buildRooms();
        abstractHouse.buildComforts();
        abstractHouse.buildDescription();
    }   

    public House seeHouse(){
        return abstractHouse.getHouse();
    }
}
