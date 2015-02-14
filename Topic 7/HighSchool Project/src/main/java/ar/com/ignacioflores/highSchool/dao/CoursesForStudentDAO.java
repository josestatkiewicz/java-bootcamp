package ar.com.ignacioflores.highSchool.dao;

import java.util.List;

import ar.com.ignacioflores.highSchool.model.CoursesForStudent;
import ar.com.ignacioflores.highSchool.model.CoursesForStudentId;

public interface CoursesForStudentDAO {
	public void addCoursesForStudent(CoursesForStudent coursesForStudent);
    public void updateCoursesForStudent(CoursesForStudent coursesForStudent);
    public List<CoursesForStudent> listCoursesForStudent();
    public CoursesForStudent getCoursesForStudentById(CoursesForStudentId coursesForStudentId);
    public void removeCoursesForStudent(CoursesForStudentId coursesForStudentId);
}
