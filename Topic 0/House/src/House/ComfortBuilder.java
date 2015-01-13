package House;

import Classes.Comfort;

public abstract class ComfortBuilder {
    
    protected Comfort comfort;

    public Comfort getComfort() { 
        return comfort; 
    }
    
    public void createNewComfort() { 
        comfort = new Comfort(); 
    }
    
    abstract void buildName();
    abstract void buildDescription();
    
}
