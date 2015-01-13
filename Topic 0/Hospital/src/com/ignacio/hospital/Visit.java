package com.ignacio.hospital;

import java.util.Calendar;
import java.util.Date;


public class Visit {
	
	public Patient patient;
	public Doctor doctor;
	public String anotations;
	public Date time;
	
	public Visit(Patient patient, Doctor doctor, String anotations){
		setPatient(patient);
		setDoctor(doctor);
		setAnotations(anotations);
	}
	
	// Setters
	public void setPatient(Patient patient){
		this.patient = patient;
	};
	public void setDoctor(Doctor doctor){
		this.doctor = doctor;
	};
	public void setAnotations(String anotations){
		this.anotations = anotations;
	};
	public void setTime(){
		this.time = Calendar.getInstance().getTime(); 
	}
	
	// Getters
	public Patient getPatient(){
		return this.patient;
	}
	public Doctor getDoctor(){
		return this.doctor;
	}
	public String getAnotations(){
		return this.anotations;
	}
	public Date getTime(){
		return this.time;
	}
	
	// toString Method
	public String toString(){
		return ("The Patient " + this.patient.lastname + " " + this.patient.name + 
				", DNI: " + this.patient.dni +
				"\nVisited to Dr. " + this.doctor.lastname + " " + this.doctor.name +
				"\nTo treat your " + this.patient.condition + 
				"\nAnotations: " + this.anotations);
	}
}
