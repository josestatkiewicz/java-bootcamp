package Classes;
public class Room {
    // Private instance variable, not accessible from outside this class
    private String name;
    private int lenght;
    private int width;
    private String description;

    //Setters
    public void setName(String name){
        this.name = name;
    }
    public void setDimensions(int lenght, int width){
        this.lenght = lenght;
        this.width = width;
    }
    public void setDescription(String description){
        this.description = description;
    }

    //toString Method
    public String toString() {
        return  name + " - " + this.lenght + " x " + this.width + "  (" + this.description + ")";
    }
}
