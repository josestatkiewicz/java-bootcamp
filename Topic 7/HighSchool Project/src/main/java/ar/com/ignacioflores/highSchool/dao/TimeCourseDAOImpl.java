package ar.com.ignacioflores.highSchool.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ar.com.ignacioflores.highSchool.model.TimeCourse;

@Repository
public class TimeCourseDAOImpl implements TimeCourseDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(TimeCourseDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addTimeCourse(TimeCourse timeCourse) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(timeCourse);
		logger.info("TimeCourse saved successfully, TimeCourse Details=" + timeCourse);
	}

	@Override
	public void updateTimeCourse(TimeCourse timeCourse) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(timeCourse);
		logger.info("TimeCourse updated successfully, TimeCourse Details=" + timeCourse);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TimeCourse> listTimeCourses() {
		Session session = this.sessionFactory.getCurrentSession();
		List<TimeCourse> timeCourses = session.createQuery("from TimeCourse").list();
		for(TimeCourse p : timeCourses){
			logger.info("TimeCourse List::"+p);
		}
		return timeCourses;
	}

	@Override
	public TimeCourse getTimeCourseById(int id) {
		Session session = this.sessionFactory.openSession();
		TimeCourse timeCourse = (TimeCourse) session.load(TimeCourse.class, new Integer(id));
		logger.info("TimeCourse loaded successfully, TimeCourse details=" + timeCourse);
		return timeCourse;
	}

	@Override
	public void removeTimeCourse(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		TimeCourse timeCourse = (TimeCourse) session.load(TimeCourse.class, new Integer(id));
		if(null != timeCourse){
			session.delete(timeCourse);
		}
		logger.info("TimeCourse deleted successfully, TimeCourse details=" + timeCourse);
	}

}