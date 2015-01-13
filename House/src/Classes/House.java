package Classes;
public class House {
	
	// Private instance variable, not accessible from outside this class
	private int m2land;
	private int m2house;
	private int bedrooms;
	private int bathrooms;
	private int garages;
	private int floors;
	private int antiquity;
    private Room[] rooms;
    private Comfort[] comforts;
	private String description;
        
    //Setters (only for garages, antiquity and description)
    public void setM2land(int m2land) {
        this.m2land = m2land;
    }
    public void setM2house(int m2house) {
        this.m2house = m2house;
    }
    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }
    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }
	public void setGarages(int garages) {
            this.garages = garages; 
	}
        public void setFloors(int floors) {
            this.floors = floors; 
	}
	public void setAntiquity(int antiquity) {
            this.antiquity = antiquity; 
	}
        public void setRooms(Room[] rooms) {
            this.rooms = rooms; 
	}
        public void setComforts(Comfort[] comforts) {
            this.comforts = comforts; 
	}
	public void setDescription(String description) {
            this.description = description; 
	}
        
    //toString Method
    public String toString() {
        return (
            "House:"   
            + "\n Size of Land: " + m2land + "m2"
			+ "\n Size of House: " + m2house + "m2"
			+ "\n Quantity of bedrooms: " + bedrooms
			+ "\n Quantity of bathrooms: " + bathrooms
			+ "\n Quantity of garages: " + garages
			+ "\n Years of antiquity: " + antiquity
            + "\n Floors: " + floors
            + "\n Description: " + description
            + "\n Rooms: "
            + showRooms()
            + "\n Comforts: "
            + showComforts()
                );
    }

    public String showComforts() {
        String s = "";
        for (int i = 0; i<comforts.length;i++){
            s = s + "\n   " + String.valueOf(comforts[i]);
        }
        return s;
    }
    public String showRooms() {
        String s = "";
        for (int i = 0; i<rooms.length;i++){
            s = s + "\n   " + String.valueOf(rooms[i]);
        }
        return s;
    }
}