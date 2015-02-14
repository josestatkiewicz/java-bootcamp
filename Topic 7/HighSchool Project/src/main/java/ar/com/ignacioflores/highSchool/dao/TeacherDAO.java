package ar.com.ignacioflores.highSchool.dao;

import java.util.List;

import ar.com.ignacioflores.highSchool.model.Teacher;

public interface TeacherDAO {

	public void addTeacher(Teacher teacher);
    public void updateTeacher(Teacher teacher);
    public List<Teacher> listTeachers();
    public Teacher getTeacherById(int teacherId);
    public void removeTeacher(int teacherId);
}
