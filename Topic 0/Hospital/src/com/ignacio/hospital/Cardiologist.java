package com.ignacio.hospital;
public class Cardiologist extends Doctor{
	
	public Cardiologist(int dni, String lastname, String name) {
		super(dni, lastname, name, "Cardiologist");
	}

	public void setEspeciality() {
		this.especiality = "Cardiologist";
	}	 
}