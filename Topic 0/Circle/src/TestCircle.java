public class TestCircle {        // save as "TestCircle.java"
	public static void main(String[] args) {
		// Declare and allocate an instance of class Circle called c1
		//  with default radius and color
		Circle c1 = new Circle();
		// Use the dot operator to invoke methods of instance c1.
		System.out.println("The circle has radius of " + c1.getRadius() + " and area of " + c1.getArea() + " and you color is " + c1.getColor());
   
		// Declare and allocate an instance of class circle called c2
		//  with the given radius and default color
		Circle c2 = new Circle(2.0);
		// Use the dot operator to invoke methods of instance c2.
		System.out.println("The circle has radius of " + c2.getRadius() + " and area of " + c2.getArea() + " and you color is " + c2.getColor());
      
		// Declare and allocate an instance of class circle called c3
		// With the given radius and color
		// Circle c3 = new Circle(3.0, "blue");
		// Use the dot operator to invoke methods of instance c3.
		// System.out.println("The circle has radius of " + c3.getRadius() + " and area of " + c3.getArea() + " and you color is " + c3.getColor());
      
      
		// 3_ Public vs. private: In TestCircle, can you access the instance variable radius directly (e.g., System.out.println(c1.radius)); or assign a new value to radius (e.g., c1.radius=5.0)? Try it out and explain the error messages.
		// System.out.println(c1.radius);
		// The error generated is the radius attribute is not visible from TestCircle
	      
		// c1.radius=5.0;
		// Generates exactly the same error
      
		// 4_ Modify the TestCircle to test these methods, e.g., 
		Circle c3 = new Circle();   	// construct an instance of Circle
		c3.setRadius(5.0);          	// change radius
		c3.setColor("gray");       	// change color
		System.out.println("The circle has radius of " + c3.getRadius() + " and area of " + c3.getArea() + " and you color is " + c3.getColor());
	      
		// 6_ Method toString(): Every well-designed Java class should contain a public method called toString() that returns a short description of the instance (in a return type of String). The toString() method can be called explicitly (via instanceName.toString()) just like any other method; or implicitly through println(). If an instance is passed to the println(anInstance) method, the toString() method of that instance will be invoked implicitly. For example, include the following toString() methods to the Circle class: 
		Circle c4 = new Circle(1.2);
		System.out.println(c4.toString());  // explicit call
		System.out.println(c4);             // println() calls toString() implicitly, same as above
		System.out.println("Operator '+' invokes toString() too: " + c4);  // '+' invokes toString() too
	}
}