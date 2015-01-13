package House;
import Classes.Comfort;

public class ComfortMaker {
	
    private ComfortBuilder comfortBuilder;
 
    public void setComfortBuilder(ComfortBuilder cb) { 
        comfortBuilder = cb; 
    }
    public Comfort getComfort() { 
        return comfortBuilder.getComfort(); 
    }
 
    public void makeComfort() {
       comfortBuilder.createNewComfort();
       comfortBuilder.buildName();
       comfortBuilder.buildDescription();
    }
}
