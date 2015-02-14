package ar.com.ignacioflores.highSchool.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ar.com.ignacioflores.highSchool.model.CoursesForStudentId;

@Repository
public class CoursesForStudentIdDAOImpl implements CoursesForStudentIdDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(CoursesForStudentIdDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addCoursesForStudentId(CoursesForStudentId coursesForStudentId) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(coursesForStudentId);
		logger.info("CoursesForStudentId saved successfully, CoursesForStudentId Details=" + coursesForStudentId);
	}

	@Override
	public void updateCoursesForStudentId(CoursesForStudentId coursesForStudentId) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(coursesForStudentId);
		logger.info("CoursesForStudentId updated successfully, CoursesForStudentId Details=" + coursesForStudentId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CoursesForStudentId> listCoursesForStudentIds() {
		Session session = this.sessionFactory.getCurrentSession();
		List<CoursesForStudentId> coursesForStudentIds = session.createQuery("from CoursesForStudentId").list();
		for(CoursesForStudentId p : coursesForStudentIds){
			logger.info("CoursesForStudentId List::"+p);
		}
		return coursesForStudentIds;
	}

	@Override
	public CoursesForStudentId getCoursesForStudentIdById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		CoursesForStudentId coursesForStudentId = (CoursesForStudentId) session.load(CoursesForStudentId.class, new Integer(id));
		logger.info("CoursesForStudentId loaded successfully, CoursesForStudentId details=" + coursesForStudentId);
		return coursesForStudentId;
	}

	@Override
	public void removeCoursesForStudentId(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		CoursesForStudentId coursesForStudentId = (CoursesForStudentId) session.load(CoursesForStudentId.class, new Integer(id));
		if(null != coursesForStudentId){
			session.delete(coursesForStudentId);
		}
		logger.info("CoursesForStudentId deleted successfully, CoursesForStudentId details=" + coursesForStudentId);
	}

}
