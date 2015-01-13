public class TestBook {
    public static void main(String[] args) {
        Author a1 = new Author("Ignacio Flores", "ignacioflores@outlook.com", 'm');
        Book b1 = new Book("More C# for dummy", a1, 29.95, 888);
        
        Book b2 = new Book("More Java for dummy", new Author("Ignacio Flores", "ignacioflores@outlook.com", 'm'), 29.95, 888);
        
        System.out.println(b1);
        System.out.println(b2);
        
    }
}