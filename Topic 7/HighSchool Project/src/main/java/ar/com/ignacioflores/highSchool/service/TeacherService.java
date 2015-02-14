package ar.com.ignacioflores.highSchool.service;

import java.util.List;

import ar.com.ignacioflores.highSchool.model.Teacher;

public interface TeacherService{

	public void addTeacher(Teacher teacher);
    public void updateTeacher(Teacher teacher);
    public List<Teacher> listTeachers();
    public Teacher getTeacherById(int teacherId);
    public void removeTeacher(int teacherId);
	
}