<<<<<<< HEAD
public class Circle {           
	// private instance variable, not accessible from outside this class
	private double radius;
	private String color;
	   
//	// 1st constructor, which sets both radius and color to default
//	public Circle() {
//		radius = 1.0;
//		color = "red";
//	}
	   
//	// 2nd constructor with given radius, but color default
//		public Circle(double r) {
//		radius = r;
//		color = "red";
//	}
	   
	// A public method for retrieving the radius
	public double getRadius() {
		return radius; 
	}
   
	// A public method for computing the area of circle
	public double getArea() {
		return radius*radius*Math.PI;
	}
	   
//	// 1_ Constructor: Modify the class Circle to include a third constructor for constructing a Circle instance with the given radius and color. 
//	// Constructor to construct a new instance of Circle with the given radius and color
//	public Circle (double r, String c) {
//		radius = r;
//		color = c;
//	}
	   
	   
	// 2_ Getter: Add a getter for variable color for retrieving the color of a Circle instance.
	// Getter for instance variable color
	public String getColor() {
		return color;
	}
		
	   
//	// 4_ Setter: Is there a need to change the values of radius and color of a Circle instance after it is constructed? If so, add two public methods called setters for changing the radius and color of a Circle instance as follows: 
//	// Setter for instance variable radius
//	public void setRadius(double r) {
//		radius = r;
//	}
//			 
//	// Setter for instance variable color
//	public void setColor(String c) { 
//		color = c;
//	}
		
		
	// 5_ Keyword "this": Instead of using variable names such as r (for radius) and c (for color) in the methods' arguments, it is better to use variable names radius (for radius) and color (for color) and use the special keyword "this" to resolve the conflict between instance variables and methods' arguments. For example: 
	// Setter of radius
	public void setRadius(double radius) {
		this.radius = radius;   // "this.radius" refers to the instance variable
								// "radius" refers to the method's argument
	}
	// Setter of color
	public void setColor(String color) {
		this.color = color;   	// "this.color" refers to the instance variable
								// "color" refers to the method's argument
	}
	// 1st constructor, which sets both radius and color to default
	public Circle() {
		this.radius = 1.0;
		this.color = "red";
	}
	// 2nd constructor with given radius, but color default
	public Circle(double radius) {
		this.radius = radius;
		this.color = "red";
			   }
	// Constructor to construct a new instance of Circle with the given radius and color
	public Circle (double radius, String color) {
		this.radius = radius;
		this.color = color;
	}
			   
	// 6_ Method toString(): Every well-designed Java class should contain a public method called toString() that returns a short description of the instance (in a return type of String). The toString() method can be called explicitly (via instanceName.toString()) just like any other method; or implicitly through println(). If an instance is passed to the println(anInstance) method, the toString() method of that instance will be invoked implicitly. For example, include the following toString() methods to the Circle class:
	public String toString() {
		return "Circle: radius=" + radius + " color=" + color;
	}		
=======
public class Circle {           // save as "Circle.java"
   // private instance variable, not accessible from outside this class
   private double radius;
   private String color;
   
//   // 1st constructor, which sets both radius and color to default
//   public Circle() {
//      radius = 1.0;
//      color = "red";
//   }
   
//   // 2nd constructor with given radius, but color default
//   public Circle(double r) {
//      radius = r;
//      color = "red";
//   }
   
   // A public method for retrieving the radius
   public double getRadius() {
     return radius; 
   }
   
   // A public method for computing the area of circle
   public double getArea() {
      return radius*radius*Math.PI;
   }
   
   // 1_ Constructor: Modify the class Circle to include a third constructor for constructing a Circle instance with the given radius and color. 
//	   // Constructor to construct a new instance of Circle with the given radius and color
//	   public Circle (double r, String c) {
//		   radius = r;
//		   color = c;
//	   }
   
   
   // 2_ Getter: Add a getter for variable color for retrieving the color of a Circle instance.
	   // Getter for instance variable color
	   public String getColor() {
		   return color;
	   }
	
   
//   // 4_ Setter: Is there a need to change the values of radius and color of a Circle instance after it is constructed? If so, add two public methods called setters for changing the radius and color of a Circle instance as follows: 
//	   // Setter for instance variable radius
//	   public void setRadius(double r) {
//		   radius = r;
//	   }
//		 
//	   // Setter for instance variable color
//	   public void setColor(String c) { 
//		   color = c;
//	   }
	
	
	// 5_ Keyword "this": Instead of using variable names such as r (for radius) and c (for color) in the methods' arguments, it is better to use variable names radius (for radius) and color (for color) and use the special keyword "this" to resolve the conflict between instance variables and methods' arguments. For example: 
		// Setter of radius
		public void setRadius(double radius) {
		   this.radius = radius;   // "this.radius" refers to the instance variable
		                           // "radius" refers to the method's argument
		}
		// Setter of color
			public void setColor(String color) {
			   this.color = color;   	// "this.color" refers to the instance variable
			                           	// "color" refers to the method's argument
			}
		// 1st constructor, which sets both radius and color to default
		   public Circle() {
		      this.radius = 1.0;
		      this.color = "red";
		   }
		// 2nd constructor with given radius, but color default
		   public Circle(double radius) {
		      this.radius = radius;
		      this.color = "red";
		   }
		// Constructor to construct a new instance of Circle with the given radius and color
		   public Circle (double radius, String color) {
			   this.radius = radius;
			   this.color = color;
		   }
		   
	   // 6_ Method toString(): Every well-designed Java class should contain a public method called toString() that returns a short description of the instance (in a return type of String). The toString() method can be called explicitly (via instanceName.toString()) just like any other method; or implicitly through println(). If an instance is passed to the println(anInstance) method, the toString() method of that instance will be invoked implicitly. For example, include the following toString() methods to the Circle class:
		   public String toString() {
			   return "Circle: radius=" + radius + " color=" + color;
			}
	
>>>>>>> 68a64ebc24a88fd5ffa54a9801416879ce93022f
}