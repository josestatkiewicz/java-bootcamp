package ar.com.ignacioflores.highSchool.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ignacioflores.highSchool.dao.CoursesForStudentDAO;
import ar.com.ignacioflores.highSchool.model.CoursesForStudent;
import ar.com.ignacioflores.highSchool.model.CoursesForStudentId;

@Service
public class CoursesForStudentServiceImpl implements CoursesForStudentService, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private CoursesForStudentDAO coursesForCoursesForStudentDAO;

	public void setCoursesForStudentDAO(CoursesForStudentDAO coursesForCoursesForStudentDAO) {
		this.coursesForCoursesForStudentDAO = coursesForCoursesForStudentDAO;
	}

	@Override
	@Transactional
	public void addCoursesForStudent(CoursesForStudent coursesForCoursesForStudent) {
		this.coursesForCoursesForStudentDAO.addCoursesForStudent(coursesForCoursesForStudent);
	}

	@Override
	@Transactional
	public void updateCoursesForStudent(CoursesForStudent coursesForCoursesForStudent) {
		this.coursesForCoursesForStudentDAO.updateCoursesForStudent(coursesForCoursesForStudent);
	}

	@Override
	@Transactional
	public List<CoursesForStudent> listCoursesForStudents() {
		return this.coursesForCoursesForStudentDAO.listCoursesForStudent();
	}

	@Override
	@Transactional
	public CoursesForStudent getCoursesForStudentById(CoursesForStudentId coursesForStudentId) {
		return this.coursesForCoursesForStudentDAO.getCoursesForStudentById(coursesForStudentId);
	}

	@Override
	@Transactional
	public void removeCoursesForStudent(CoursesForStudentId coursesForStudentId) {
		this.coursesForCoursesForStudentDAO.removeCoursesForStudent(coursesForStudentId);
	}

}