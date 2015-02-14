package ar.com.ignacioflores.highSchool.dao;

import java.util.List;

import ar.com.ignacioflores.highSchool.model.CriticsStudents;

public interface CriticsStudentsDAO {

    public List<CriticsStudents> listCriticsStudentss();
    public CriticsStudents getCriticsStudentsById(int criticsCriticsStudentssId);
}
