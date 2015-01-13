package com.ignacio.hospital;
public class PatientFactory {
	
	public static Patient createPatient(int dni, String lastname, String name, Condition condition){
		Patient patient = new Patient(dni, lastname, name, condition);
		return patient;
	}
}