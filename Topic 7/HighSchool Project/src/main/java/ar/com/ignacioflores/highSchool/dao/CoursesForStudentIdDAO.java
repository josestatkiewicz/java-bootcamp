package ar.com.ignacioflores.highSchool.dao;

import java.util.List;

import ar.com.ignacioflores.highSchool.model.CoursesForStudentId;

public interface CoursesForStudentIdDAO {

	public void addCoursesForStudentId(CoursesForStudentId coursesForCoursesForStudentId);
    public void updateCoursesForStudentId(CoursesForStudentId coursesForCoursesForStudentId);
    public List<CoursesForStudentId> listCoursesForStudentIds();
    public CoursesForStudentId getCoursesForStudentIdById(int coursesForCoursesForStudentId);
    public void removeCoursesForStudentId(int coursesForCoursesForStudentId);
}
