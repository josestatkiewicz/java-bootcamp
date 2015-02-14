package ar.com.ignacioflores.highSchool.service;

import java.util.List;

import ar.com.ignacioflores.highSchool.model.CoursesForStudent;
import ar.com.ignacioflores.highSchool.model.CoursesForStudentId;

public interface CoursesForStudentService{

	public void addCoursesForStudent(CoursesForStudent coursesForCoursesForStudent);
    public void updateCoursesForStudent(CoursesForStudent coursesForCoursesForStudent);
    public List<CoursesForStudent> listCoursesForStudents();
    public CoursesForStudent getCoursesForStudentById(CoursesForStudentId coursesForStudentId);
    public void removeCoursesForStudent(CoursesForStudentId coursesForStudentId);
	
}