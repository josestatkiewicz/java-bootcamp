package ar.com.ignacioflores.highSchool.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ar.com.ignacioflores.highSchool.model.Teacher;

@Repository
public class TeacherDAOImpl implements TeacherDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(TeacherDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addTeacher(Teacher teacher) {
		Session session = this.sessionFactory.openSession();
		session.save(teacher);
		logger.info("Teacher saved successfully, Teacher Details=" + teacher);
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		Session session = this.sessionFactory.openSession();
		session.update(teacher);
		logger.info("Teacher updated successfully, Teacher Details=" + teacher);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> listTeachers() {
		Session session = this.sessionFactory.openSession();
		List<Teacher> teachers = session.createQuery("from Teacher").list();
		for(Teacher p : teachers){
			logger.info("Teacher List::"+p);
		}
		return teachers;
	}

	@Override
	public Teacher getTeacherById(int id) {
		Session session = this.sessionFactory.openSession();		
		Teacher teacher = (Teacher) session.load(Teacher.class, new Integer(id));
		logger.info("Teacher loaded successfully, Teacher details=" + teacher);
		return teacher;
	}

	@Override
	public void removeTeacher(int id) {
		Session session = this.sessionFactory.openSession();
		Teacher teacher = (Teacher) session.load(Teacher.class, new Integer(id));
		if(null != teacher){
			session.delete(teacher);
		}
		logger.info("Teacher deleted successfully, Teacher details=" + teacher);
	}

}