package mypoint;

public class MyCircle {
    // Private instance variable, not accessible from outside this class
    private MyPoint center;
    private int radius;
    
    // Constructors
    public MyCircle(int x, int y, int radius) {
        this.center.setXY(x, y);
        this.radius = radius;
    }
    public MyCircle(MyPoint center, int radius) {
        this.center = center;
        this.radius = radius;
    }
    
    // Getters
    public int getRadius(){
        return this.radius;
    }
    public MyPoint getCenter(){
        return this.center;
    }
    public int getCenterX(){
        return this.center.getX();
    }
    public int getCenterY(){
        return this.center.getY();
    }
    public double getArea(){
        return (3.1415926535 * this.radius * this.radius);
    }
    
    // Setters
    public void setRadius(int radius){
        this.radius = radius;
    }
    public void setCenter (MyPoint center){
        this.center = center;
    }
    public void setCenterXY (int x, int y){
        this.center.setXY(x, y);
    }
    
    // ToString Method
    public String toString(){
        return("Center:" + this.center + " Radius:" + this.radius);
    }
}
