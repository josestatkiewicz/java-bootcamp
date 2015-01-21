package ar.com.ignacioflores.tdd.item_3;

public class File {
	String path;
	String name;
	String content;
	
	public File(String path, String name, String content) {
		setPath(path);
		setName(name);
		setContent(content);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public void setContent(String content){
		this.content = content;
	}
	public String getPath(){
		return this.path;
	}
	public String getName(){
		return this.name;
	}
	public String getContent(){
		return this.content;
	}
	
	@Override
	public String toString() {
		return ("File: " + "'" + this.name + "'" +"  Path: " + "'" + path + "'"); 
	}
}
