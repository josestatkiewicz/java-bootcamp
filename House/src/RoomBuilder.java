abstract class RoomBuilder{
    
    protected Room room;

    public Room getRoom() { 
        return room; }
    
    public void createNewRoom() { 
        room = new Room(); 
    }
    
    abstract void buildName();
    abstract void buildDimensions();
    abstract void buildDescription();
    
}
