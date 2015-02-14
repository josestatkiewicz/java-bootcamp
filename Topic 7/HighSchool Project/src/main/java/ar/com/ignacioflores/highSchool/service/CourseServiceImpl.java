package ar.com.ignacioflores.highSchool.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ignacioflores.highSchool.dao.CourseDAO;
import ar.com.ignacioflores.highSchool.model.Course;

@Service
public class CourseServiceImpl implements CourseService, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private CourseDAO courseDAO;

	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	@Override
	@Transactional
	public void addCourse(Course course) {
		this.courseDAO.addCourse(course);
	}

	@Override
	@Transactional
	public void updateCourse(Course course) {
		this.courseDAO.updateCourse(course);
	}

	@Override
	@Transactional
	public List<Course> listCourses() {
		return this.courseDAO.listCourses();
	}

	@Override
	@Transactional
	public Course getCourseById(int id) {
		return this.courseDAO.getCourseById(id);
	}

	@Override
	@Transactional
	public void removeCourse(int id) {
		this.courseDAO.removeCourse(id);
	}

}
