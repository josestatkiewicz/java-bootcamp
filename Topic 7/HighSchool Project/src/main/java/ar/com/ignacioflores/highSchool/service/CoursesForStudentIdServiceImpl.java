package ar.com.ignacioflores.highSchool.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ignacioflores.highSchool.dao.CoursesForStudentIdDAO;
import ar.com.ignacioflores.highSchool.model.CoursesForStudentId;

@Service
public class CoursesForStudentIdServiceImpl implements CoursesForStudentIdService, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private CoursesForStudentIdDAO coursesForStudentIdDAO;

	public void setCoursesForStudentIdDAO(CoursesForStudentIdDAO coursesForStudentIdDAO) {
		this.coursesForStudentIdDAO = coursesForStudentIdDAO;
	}

	@Override
	@Transactional
	public void addCoursesForStudentId(CoursesForStudentId coursesForStudentId) {
		this.coursesForStudentIdDAO.addCoursesForStudentId(coursesForStudentId);
	}

	@Override
	@Transactional
	public void updateCoursesForStudentId(CoursesForStudentId coursesForStudentId) {
		this.coursesForStudentIdDAO.updateCoursesForStudentId(coursesForStudentId);
	}

	@Override
	@Transactional
	public List<CoursesForStudentId> listCoursesForStudentIds() {
		return this.coursesForStudentIdDAO.listCoursesForStudentIds();
	}

	@Override
	@Transactional
	public CoursesForStudentId getCoursesForStudentIdById(int id) {
		return this.coursesForStudentIdDAO.getCoursesForStudentIdById(id);
	}

	@Override
	@Transactional
	public void removeCoursesForStudentId(int id) {
		this.coursesForStudentIdDAO.removeCoursesForStudentId(id);
	}

}
