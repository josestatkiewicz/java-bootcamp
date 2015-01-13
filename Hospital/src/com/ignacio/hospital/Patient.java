package com.ignacio.hospital;
public class Patient {
	
	public int dni;
	public String lastname;
	public String name;
	public Condition condition;
	
	public Patient(int dni, String lastname, String name, Condition condition){
		this.dni = dni;
		this.lastname = lastname;
		this.name = name;
		this.condition = condition;
	}
	
	// Setters
	public void setDni(int dni){
		this.dni = dni;
	};
	public void setLastname(String lastname){
		this.lastname = lastname;
	};
	public void setName(String name){
		this.name = name;
	};
	public void setCondition(Condition condition){
		this.condition = condition;
	};
	
	// Getters
	public int getDni(){
		return this.dni;
	}
	public String getLastname(){
		return this.lastname;
	}
	public String getName(){
		return this.name;
	}
	public Condition getcondition(){
		return this.condition;
	}
	
	// toString Method
	public String toString(){
		return ("Patient: " + this.lastname + " " + this.name +
				"\nDNI: " + this.dni +
				"\nCondition: " + this.condition);
	}
}
