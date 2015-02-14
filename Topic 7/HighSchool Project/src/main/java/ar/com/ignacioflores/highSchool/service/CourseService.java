package ar.com.ignacioflores.highSchool.service;

import java.util.List;

import ar.com.ignacioflores.highSchool.model.Course;

public interface CourseService{

	public void addCourse(Course course);
    public void updateCourse(Course course);
    public List<Course> listCourses();
    public Course getCourseById(int courseId);
    public void removeCourse(int courseId);
	
}