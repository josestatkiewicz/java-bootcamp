package ar.com.ignacioflores.highSchool.service;

import java.util.List;

import ar.com.ignacioflores.highSchool.model.CriticsStudents;

public interface CriticsStudentsService{

    public List<CriticsStudents> listCriticsStudentss();
    public CriticsStudents getCriticsStudentsById(int criticsStudentsId);
	
}