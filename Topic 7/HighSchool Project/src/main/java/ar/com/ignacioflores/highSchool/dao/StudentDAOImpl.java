package ar.com.ignacioflores.highSchool.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ar.com.ignacioflores.highSchool.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addStudent(Student student) {
		Session session = this.sessionFactory.openSession();
		session.save(student);
		logger.info("Student saved successfully, Student Details=" + student);
	}

	@Override
	public void updateStudent(Student student) {
		Session session = this.sessionFactory.openSession();
		session.update(student);
		logger.info("Student updated successfully, Student Details=" + student);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> listStudents() {
		Session session = this.sessionFactory.openSession();
		List<Student> students;
		students = (List<Student>) session.createCriteria(Student.class).list();
		for(Student student : students){
			logger.info("Student List::"+student);
		}
		return students;
	}

	@Override
	public Student getStudentById(int id) {
		Session session = this.sessionFactory.openSession();		
		Student student = (Student) session.load(Student.class, new Integer(id));
		logger.info("Student loaded successfully, Student details=" + student);
		return student;
	}

	@Override
	public void removeStudent(int id) {
		Session session = this.sessionFactory.openSession();
		Student student = (Student) session.load(Student.class, new Integer(id));
		if(null != student){
			session.delete(student);
		}
		logger.info("Student deleted successfully, Student details=" + student);
	}

}
