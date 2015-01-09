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
