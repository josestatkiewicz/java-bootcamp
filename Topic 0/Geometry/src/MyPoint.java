public class MyPoint {
    
    // Private instance variable, not accessible from outside this class
	private int x;
    private int y;
    
    // Constructors
    public MyPoint() {
        this.x = 0;
        this.y = 0;
    }
    public MyPoint(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    // Setters
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setXY(int x,int y){
        this.x = x;
        this.y = y;
    }
    
    // Getters
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    
    // ToString Method
    public String toString(){
        return("(" + x + "," + y + ")");
    }
    
    // Distance Method
    public double distance(int x, int y){
        int xDiff = this.x - x;
        int yDiff = this.y - y;
        return Math.sqrt(xDiff*xDiff + yDiff*yDiff);
    }
    public double distance(MyPoint another){
        int xDiff = this.x - another.x;
        int yDiff = this.y - another.y;
        return Math.sqrt(xDiff*xDiff + yDiff*yDiff);
    }
}