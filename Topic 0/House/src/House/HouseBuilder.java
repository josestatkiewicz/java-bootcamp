package House;

import Classes.House;

abstract class HouseBuilder {
    
    protected House house;

    public House getHouse() { 
        return house; 
    }
    
    public void createNewHouse() { 
        house = new House(); 
    }
    abstract void buildM2land();
    abstract void buildM2house();
    abstract void buildBedrooms();
    abstract void buildBathrooms();
    abstract void buildGarages();
    abstract void buildFloors();
    abstract void buildAntiquity();
    abstract void buildRooms();
    abstract void buildComforts();
    abstract void buildDescription();
}
