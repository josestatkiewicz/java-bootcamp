package ar.com.ignacioflores.highSchool.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ignacioflores.highSchool.dao.TeacherDAO;
import ar.com.ignacioflores.highSchool.model.Teacher;

@Service
public class TeacherServiceImpl implements TeacherService, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private TeacherDAO teacherDAO;

	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	@Override
	@Transactional
	public void addTeacher(Teacher teacher) {
		this.teacherDAO.addTeacher(teacher);
	}

	@Override
	@Transactional
	public void updateTeacher(Teacher teacher) {
		this.teacherDAO.updateTeacher(teacher);
	}

	@Override
	@Transactional
	public List<Teacher> listTeachers() {
		return this.teacherDAO.listTeachers();
	}

	@Override
	@Transactional
	public Teacher getTeacherById(int id) {
		return this.teacherDAO.getTeacherById(id);
	}

	@Override
	@Transactional
	public void removeTeacher(int id) {
		this.teacherDAO.removeTeacher(id);
	}

}