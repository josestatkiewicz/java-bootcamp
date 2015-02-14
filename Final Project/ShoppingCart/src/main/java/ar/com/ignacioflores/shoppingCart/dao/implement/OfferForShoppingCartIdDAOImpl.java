package ar.com.ignacioflores.shoppingCart.dao.implement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ignacioflores.shoppingCart.dao.OfferForShoppingCartIdDAO;
import ar.com.ignacioflores.shoppingCart.model.OfferForShoppingCartId;

@Repository
@Transactional
public class OfferForShoppingCartIdDAOImpl implements OfferForShoppingCartIdDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(OfferForShoppingCartIdDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addOfferForShoppingCartId(OfferForShoppingCartId offerForShoppingCartId) {
		Session session = sessionFactory.getCurrentSession();
		session.save(offerForShoppingCartId);
		logger.info("OfferForShoppingCartId saved successfully, OfferForShoppingCartId Details=" + offerForShoppingCartId);
	}

	@Override
	public void updateOfferForShoppingCartId(OfferForShoppingCartId offerForShoppingCartId) {
		Session session = sessionFactory.getCurrentSession();
		session.update(offerForShoppingCartId);
		logger.info("OfferForShoppingCartId updated successfully, OfferForShoppingCartId Details=" + offerForShoppingCartId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OfferForShoppingCartId> listOfferForShoppingCartIds() {
		Session session = sessionFactory.getCurrentSession();
		List<OfferForShoppingCartId> offerForShoppingCartIds = session.createQuery("from OfferForShoppingCartId").list();
		for(OfferForShoppingCartId offerForShoppingCartId : offerForShoppingCartIds){
			logger.info("OfferForShoppingCartId List::" + offerForShoppingCartId);
		}
		return offerForShoppingCartIds;
	}

	@Override
	public OfferForShoppingCartId getOfferForShoppingCartIdById(int id) {
		Session session = sessionFactory.getCurrentSession();		
		OfferForShoppingCartId offerForShoppingCartId = (OfferForShoppingCartId) session.get(OfferForShoppingCartId.class, new Integer(id));
		logger.info("OfferForShoppingCartId loaded successfully, OfferForShoppingCartId details=" + offerForShoppingCartId);
		return offerForShoppingCartId;
	}

	@Override
	public void removeOfferForShoppingCartId(int id) {
		Session session = sessionFactory.getCurrentSession();
		OfferForShoppingCartId offerForShoppingCartId = (OfferForShoppingCartId) session.get(OfferForShoppingCartId.class, new Integer(id));
		if(null != offerForShoppingCartId){
			session.delete(offerForShoppingCartId);
		}
		logger.info("OfferForShoppingCartId deleted successfully, OfferForShoppingCartId details=" + offerForShoppingCartId);
	}

}
