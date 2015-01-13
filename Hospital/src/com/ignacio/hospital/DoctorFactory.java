package com.ignacio.hospital;
public class DoctorFactory {
	
	public static Doctor createCardiologist(int dni, String lastname, String name){
		Doctor doctor = new Cardiologist(dni, lastname, name);
		return doctor;
	}
	public static Doctor createClinical(int dni, String lastname, String name){
		Doctor doctor = new Clinical(dni, lastname, name);
		return doctor;
	}
}