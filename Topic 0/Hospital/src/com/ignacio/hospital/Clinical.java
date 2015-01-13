package com.ignacio.hospital;
public class Clinical extends Doctor{
	
	public Clinical(int dni, String lastname, String name) {
		super(dni, lastname, name, "Clinical");
	}

	public void setEspeciality() {
		this.especiality = "Clinical";
	}	 
}