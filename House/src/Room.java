class Room {
    // Private instance variable, not accessible from outside this class
    private String name;
    private int lenght;
    private int width;
    private String description;

    //Setters
    public void set_name(String name){
        this.name = name;
    }
    public void set_dimensions(int lenght, int width){
        this.lenght = lenght;
        this.width = width;
    }
    public void set_description(String description){
        this.description = description;
    }

    //toString Method
    public String toString() {
        return  name + " - " + this.lenght + " x " + this.width + "  (" + this.description + ")";
    }
}
