package ar.com.ignacioflores.highSchool.service;

import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ignacioflores.highSchool.dao.TimeCourseDAO;
import ar.com.ignacioflores.highSchool.model.TimeCourse;

@Service
public class TimeCourseServiceImpl implements TimeCourseService, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private TimeCourseDAO timeCourseDAO;

	public void setTimeCourseDAO(TimeCourseDAO timeCourseDAO) {
		this.timeCourseDAO = timeCourseDAO;
	}

	@Override
	@Transactional
	public void addTimeCourse(TimeCourse timeCourse) {
		this.timeCourseDAO.addTimeCourse(timeCourse);
	}

	@Override
	@Transactional
	public void updateTimeCourse(TimeCourse timeCourse) {
		this.timeCourseDAO.updateTimeCourse(timeCourse);
	}

	@Override
	@Transactional
	public List<TimeCourse> listTimeCourses() {
		return this.timeCourseDAO.listTimeCourses();
	}

	@Override
	@Transactional
	public TimeCourse getTimeCourseById(int id) {
		return this.timeCourseDAO.getTimeCourseById(id);
	}

	@Override
	@Transactional
	public void removeTimeCourse(int id) {
		this.timeCourseDAO.removeTimeCourse(id);
	}

}