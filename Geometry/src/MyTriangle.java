public class MyTriangle {
    
     // Private instance variable, not accessible from outside this class
    private MyPoint v1;
    private MyPoint v2;
    private MyPoint v3;
    
    // Constructors
    public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        this.v1.setXY(x1, y1);
        this.v2.setXY(x2, y2);
        this.v3.setXY(x3, y3);
    }
    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3){
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }
    
    // ToString Method
    public String toString(){
        return("Vertice 1:" + this.v1 + "\nVertice 2:" + this.v2 + "\nVertice 3:" + this.v3);
    }
}