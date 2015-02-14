package ar.com.ignacioflores.highSchool.service;

import java.util.List;

import ar.com.ignacioflores.highSchool.model.CoursesForStudentId;

public interface CoursesForStudentIdService{

	public void addCoursesForStudentId(CoursesForStudentId coursesForStudentId);
    public void updateCoursesForStudentId(CoursesForStudentId coursesForStudentId);
    public List<CoursesForStudentId> listCoursesForStudentIds();
    public CoursesForStudentId getCoursesForStudentIdById(int coursesForStudentIdId);
    public void removeCoursesForStudentId(int coursesForStudentIdId);
	
}