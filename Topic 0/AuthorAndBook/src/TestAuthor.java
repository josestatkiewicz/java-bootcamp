public class TestAuthor {
    public static void main(String[] args) {
        Author a1 = new Author("Ignacio Flores", "ignacioflores@outlook.com", 'm');
        
        a1.set_email("ignacio.simon.flores@gmail.com");
        
        System.out.println(a1);
    }
}