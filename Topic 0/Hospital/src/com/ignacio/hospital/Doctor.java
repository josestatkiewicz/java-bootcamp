package com.ignacio.hospital;
public abstract class Doctor {
	
	public int dni;
	public String lastname;
	public String name;
	public String especiality;
	
	public Doctor(int dni, String lastname, String name, String especiality){
		this.dni = dni;
		this.lastname = lastname;
		this.name = name;
		this.especiality = especiality;
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
	public String getEspeciality(){
		return this.especiality;
	}
	
	// toString Method
	public String toString(){
		return ("Doctor: " + this.lastname + " " + this.name +
				"\nDNI: " + this.dni +
				"\nEspeciality: " + this.especiality);
	}
}
