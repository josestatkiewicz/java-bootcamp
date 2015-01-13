package Classes;
public class Comfort {
    
    // Private instance variable, not accessible from outside this class
    private String name;
    private String description;

    //Setters
    public void setName(String name){
        this.name = name;
    }
    public void setDescription(String description){
        this.description = description;
    }    
    
    //toString Method
    public String toString() {
        return  name + " (" + this.description + ")";
    }
    
}
