package mypoint;

public class TestMyPoint {
    
    public static void main(String[] args) {
        // Test program
        MyPoint p1 = new MyPoint(3, 0);
        MyPoint p2 = new MyPoint(0, 4);
        MyPoint p3 = new MyPoint();
        p3.setX(1);
        p3.setY(1);
        MyPoint p4 = new MyPoint();
        p4.setXY(2, 2);
        
        // Testing the overloaded method distance()
        System.out.println(p1.distance(p2));    
        System.out.println(p1.distance(5, 6));  
        System.out.println(p3.distance(p4));    
    
        // Set array of MyPoint
        MyPoint[] points = new MyPoint[10]; // Declare and allocate an array of MyPoint
        for (int i = 0; i<10; i++) {
            points[i] = new MyPoint(i+1,i+1);    // Allocate each of MyPoint instances
        }
        
        for (int i = 0; i<10; i++) {
            System.out.println(points[i]);
        }
        
//        // Test MyCircle
//        MyCircle c1 = new MyCircle(p4, 2);
//        System.out.println(c1);
        
//        // Test MyTriangle
//        MyTriangle t1 = new MyTriangle(p1, p2, p3);
//        System.out.println(t1);
    }
    
    
}
