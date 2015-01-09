import java.util.Scanner;
import javax.xml.bind.DatatypeConverter;

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
        public void set_m2land(int m2land) {
            this.m2land = m2land;
        }
        public void set_m2house(int m2house) {
            this.m2house = m2house;
        }
        public void set_bedrooms(int bedrooms) {
            this.bedrooms = bedrooms;
        }
        public void set_bathrooms(int bathrooms) {
            this.bathrooms = bathrooms;
        }
	public void set_garages(int garages) {
            this.garages = garages; 
	}
        public void set_floors(int floors) {
            this.floors = floors; 
	}
	public void set_antiquity(int antiquity) {
            this.antiquity = antiquity; 
	}
        public void set_rooms(Room[] rooms) {
            this.rooms = rooms; 
	}
        public void set_comforts(Comfort[] comforts) {
            this.comforts = comforts; 
	}
	public void set_description(String description) {
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
                + show_rooms()
                + "\n Comforts: "
                + show_comforts()
                    );
                   
           
        }

        public String show_comforts() {
            String s = "";
            for (int i = 0; i<comforts.length;i++){
                s = s + "\n   " + String.valueOf(comforts[i]);
            }
            return s;
        }
        public String show_rooms() {
            String s = "";
            for (int i = 0; i<rooms.length;i++){
                s = s + "\n   " + String.valueOf(rooms[i]);
            }
            return s;
        }
	
	
	
}
