package ar.com.ignacioflores.highSchool.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ar.com.ignacioflores.highSchool.model.CoursesForStudent;
import ar.com.ignacioflores.highSchool.model.CoursesForStudentId;

@Repository
public class CoursesForStudentDAOImpl implements CoursesForStudentDAO{

	private static final Logger logger = LoggerFactory.getLogger(StudentDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public void addCoursesForStudent(CoursesForStudent coursesForStudent) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(coursesForStudent);
		logger.info("CoursesForStudent saved successfully, CoursesForStudent Details="+coursesForStudent);	
	}

	@Override
	public void updateCoursesForStudent(CoursesForStudent coursesForStudent) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(coursesForStudent);
		logger.info("CoursesForStudent updated successfully, CoursesForStudent Details="+coursesForStudent);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CoursesForStudent> listCoursesForStudent() {
		Session session = this.sessionFactory.getCurrentSession();
		List<CoursesForStudent> coursesForStudents = session.createQuery("from CoursesForStudent").list();
		for(CoursesForStudent coursesForStudent : coursesForStudents){
			logger.info("CoursesForStudent List::" + coursesForStudent);
		}
		return coursesForStudents;
	}

	@Override
	public CoursesForStudent getCoursesForStudentById(CoursesForStudentId coursesForStudentId) {
		Session session = this.sessionFactory.getCurrentSession();		
		CoursesForStudent coursesForStudent = (CoursesForStudent) session.load(CoursesForStudent.class, coursesForStudentId);
		logger.info("CoursesForStudent loaded successfully, CoursesForStudent details=" + coursesForStudent);
		return coursesForStudent;
	}

	@Override
	public void removeCoursesForStudent(CoursesForStudentId coursesForStudentId) {
		Session session = this.sessionFactory.getCurrentSession();
		CoursesForStudent coursesForStudent = (CoursesForStudent) session.load(CoursesForStudent.class, coursesForStudentId);
		if(null != coursesForStudent){
			session.delete(coursesForStudent);
		}
		logger.info("CoursesForStudent deleted successfully, CoursesForStudent details=" + coursesForStudent);
	}
	
}
