package ar.com.ignacioflores.highSchool.dao;

import java.util.List;

import ar.com.ignacioflores.highSchool.model.Student;

public interface StudentDAO {

	public void addStudent(Student student);
    public void updateStudent(Student student);
    public List<Student> listStudents();
    public Student getStudentById(int studentId);
    public void removeStudent(int studentId);
}
