public class MyComplex {
<<<<<<< HEAD
	// Private instance variable, not accessible from outside this class
=======
    // Private instance variable, not accessible from outside this class
>>>>>>> 68a64ebc24a88fd5ffa54a9801416879ce93022f
    private double real;
    private double imag;
    
    // Constructor
    public MyComplex(double real, double imag){
        this.real = real;
        this.imag = imag;
    }
    
    // Getters
    public double getReal(){
        return this.real;
    }
    public double getImag(){
        return this.imag;
    }
    
    // Setters
    public void setReal(double real){
        this.real = real;
    }
    public void setImag(double imag){
        this.imag = imag;
    }
    public void setValue(double real, double imag){
        this.setReal(real);
        this.setImag(imag);
    }
    
    // ToString Method
    public String toString(){
        return("(" + this.real + "," + this.imag + "i)");
    }
    
    // Other Methods
    public boolean isReal(){
        if (this.imag == 0){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean isImaginary(){
        if (this.imag != 0){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean equals(double real, double imag){
        if (this.real == real && this.imag == imag){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean equals(MyComplex another){
        if (this.real == another.real && this.imag == another.imag){
            return true;
        }
        else{
            return false;
        }
    }
    public double magnitude(){
        return Math.sqrt(this.real * this.real + this.imag * this.imag);
    }
    public double argumentInRadians(){
        return Math.atan2(this.imag, this.real);
    }
    public int argumentInDegrees(){
        return (int) ((Math.atan2(this.imag, this.real)* 180) / 3.1416);
    }
    public MyComplex conjugate(){
        return new MyComplex(this.real, (- this.imag));
    }
    public MyComplex add(MyComplex another){
        return new MyComplex(this.real + another.real, this.imag + another.imag);
    }
    public MyComplex substract(MyComplex another){
        return new MyComplex(this.real - another.real, this.imag - another.imag);
    }
    public MyComplex multiplyWith(MyComplex another){
        return new MyComplex(this.real * another.real - this.imag * another.imag, this.real * another.imag + this.imag * another.real);
    }
    public MyComplex divideBy(MyComplex another){
        MyComplex temp = this.multiplyWith(another.conjugate());
        double a = (temp.real)/(another.real * another.real + another.imag * another.imag);
        double b = (temp.imag)/(another.real * another.real + another.imag * another.imag);
       
        return new MyComplex(a, b);
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 68a64ebc24a88fd5ffa54a9801416879ce93022f
