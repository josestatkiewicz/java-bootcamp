public class Author {
	private String name;
	private String email;
	private char gender;
        
    
    public Author (String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    } 
    
    public String get_name() {
        return name; 
    }
    
    public String get_email() {
        return email; 
    }
    
    public char get_gender() {
        return gender; 
    }
    
    public void set_email(String email) {
        this.email = email;
    }
    
    public String toString() {
        return  name + " (" + gender + ") at " + email;
    }
}