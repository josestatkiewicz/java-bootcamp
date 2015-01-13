package House;
class BedroomRoomBuilder extends RoomBuilder {
	public void buildName()         { room.setName("Bedroom"); }
    public void buildDimensions()    { room.setDimensions(3, 4); }
    public void buildDescription()  { room.setDescription("So cute"); }
}