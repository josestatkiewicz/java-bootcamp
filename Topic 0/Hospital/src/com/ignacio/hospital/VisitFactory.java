package com.ignacio.hospital;

public class VisitFactory {

	public static Visit createVisit(Patient patient, Doctor doctor, String anotations){
		Visit visit = new Visit(patient, doctor, anotations);
		return visit;
	}
}
