package ar.com.ignacioflores.highSchool.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ignacioflores.highSchool.model.Course;

@Repository
@Transactional
public class CourseDAOImpl implements CourseDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(CourseDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addCourse(Course course) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(course);
		logger.info("Course saved successfully, Course Details=" + course);
	}

	@Override
	public void updateCourse(Course course) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(course);
		logger.info("Course updated successfully, Course Details=" + course);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> listCourses() {
		Session session = this.sessionFactory.openSession();
		List<Course> courses = session.createQuery("from Course").list();
		for(Course course : courses){
			logger.info("Course List::" + course);
		}
		return courses;
	}

	@Override
	public Course getCourseById(int id) {
		Session session = this.sessionFactory.openSession();		
		Course course = (Course) session.load(Course.class, new Integer(id));
		logger.info("Course loaded successfully, Course details=" + course);
		return course;
	}

	@Override
	public void removeCourse(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Course course = (Course) session.load(Course.class, new Integer(id));
		if(null != course){
			session.delete(course);
		}
		logger.info("Course deleted successfully, Course details=" + course);
	}

}
