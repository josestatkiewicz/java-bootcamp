package ar.com.ignacioflores.highSchool.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ar.com.ignacioflores.highSchool.model.CriticsStudents;

@Repository
public class CriticsStudentsDAOImpl implements CriticsStudentsDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(CriticsStudentsDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CriticsStudents> listCriticsStudentss() {
		Session session = this.sessionFactory.getCurrentSession();
		List<CriticsStudents> criticsStudentss = session.createQuery("from CriticsStudents").list();
		for(CriticsStudents p : criticsStudentss){
			logger.info("CriticsStudents List::"+p);
		}
		return criticsStudentss;
	}

	@Override
	public CriticsStudents getCriticsStudentsById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		CriticsStudents criticsStudents = (CriticsStudents) session.load(CriticsStudents.class, new Integer(id));
		logger.info("CriticsStudents loaded successfully, CriticsStudents details=" + criticsStudents);
		return criticsStudents;
	}
}