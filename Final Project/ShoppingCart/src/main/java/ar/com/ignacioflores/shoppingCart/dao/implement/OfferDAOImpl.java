package ar.com.ignacioflores.shoppingCart.dao.implement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import ar.com.ignacioflores.shoppingCart.dao.OfferDAO;
import ar.com.ignacioflores.shoppingCart.model.Offer;

@Repository
@Transactional
public class OfferDAOImpl implements OfferDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(OfferDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addOffer(Offer offer) {
		Session session = sessionFactory.getCurrentSession();
		session.save(offer);
		logger.info("Offer saved successfully, Offer Details=" + offer);
	}

	@Override
	public void updateOffer(Offer offer) {
		Session session = sessionFactory.getCurrentSession();
		session.update(offer);
		logger.info("Offer updated successfully, Offer Details=" + offer);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Offer> listOffers() {
		Session session = sessionFactory.getCurrentSession();
		List<Offer> offers = session.createQuery("from Offer").list();
		for(Offer offer : offers){
			logger.info("Offer List::" + offer);
		}
		return offers;
	}

	@Override
	public Offer getOfferById(int id) {
		Session session = sessionFactory.getCurrentSession();	
		Offer offer = (Offer) session.get(Offer.class, new Integer(id));
		logger.info("Offer loaded successfully, Offer details=" + offer);
		return offer;
	}

	@Override
	public void removeOffer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Offer offer = (Offer) session.get(Offer.class, new Integer(id));
		if(null != offer){
			session.delete(offer);
		}
		logger.info("Offer deleted successfully, Offer details=" + offer);
	}

}
