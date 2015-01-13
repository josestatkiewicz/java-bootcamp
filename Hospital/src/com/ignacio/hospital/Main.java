package com.ignacio.hospital;
public class Main {
	public static void main(String[] args) {
		Doctor doctor1 = DoctorFactory.createCardiologist(124412412, "Ramirez", "Hernan");
		Doctor doctor2 = DoctorFactory.createClinical(15212412, "Gutierrez", "Romina");
		Patient patient1 = PatientFactory.createPatient(36981827, "Alamendra", "Mario", Condition.cancer);
		Patient patient2 = PatientFactory.createPatient(37931827, "Alfonso", "María", Condition.hepatitis);
		
		Visit visit1 = VisitFactory.createVisit(patient1, doctor1, "");
		Visit visit2 = VisitFactory.createVisit(patient2, doctor2, "");
		
		System.out.println(visit1);
		System.out.println("");
		System.out.println(visit2);
	}
}