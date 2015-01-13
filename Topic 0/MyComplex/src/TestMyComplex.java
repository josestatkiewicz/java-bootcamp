public class TestMyComplex {
    
	public static void main(String[] args) {
         MyComplex comp1 = new MyComplex(2, 3);
         MyComplex comp2 = new MyComplex(3, 2);
         MyComplex comp3 = new MyComplex(0, 0);
         
         comp2.setImag(5);
         comp3.setValue(1, 0);
         
         //is Real?
         if (comp3.isReal()){
             System.out.println("yes, is real");
         }
         else{
             System.out.println("no, is not real");
         }
         
         //is Imaginary?
         if (comp3.isImaginary()){
             System.out.println("yes, is imaginary");
         }
         else{
             System.out.println("no, is not imaginary");
         }
         
         //are equals?
         if (comp3.isImaginary()){
             System.out.println("yes");
         }
         else{
             System.out.println("no");
         }
         
    }
}