package House;
import Classes.Comfort;

public class MakeAComfort {
	
    ComfortBuilder abstractComfort;
 
    public MakeAComfort(ComfortBuilder abstractComfort) {
        this.abstractComfort = abstractComfort;
        abstractComfort.buildName();
        abstractComfort.buildDescription();
    }   

    public Comfort seeComfort(){
        return abstractComfort.getComfort();
    }
}
