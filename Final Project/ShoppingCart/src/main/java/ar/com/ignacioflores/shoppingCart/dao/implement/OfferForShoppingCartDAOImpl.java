package ar.com.ignacioflores.shoppingCart.dao.implement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ignacioflores.shoppingCart.dao.OfferForShoppingCartDAO;
import ar.com.ignacioflores.shoppingCart.model.OfferForShoppingCart;

@Repository
@Transactional
public class OfferForShoppingCartDAOImpl implements OfferForShoppingCartDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(OfferForShoppingCartDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addOfferForShoppingCart(OfferForShoppingCart offerForShoppingCart) {
		Session session = sessionFactory.getCurrentSession();
		session.save(offerForShoppingCart);
		logger.info("OfferForShoppingCart saved successfully, OfferForShoppingCart Details=" + offerForShoppingCart);
	}

	@Override
	public void updateOfferForShoppingCart(OfferForShoppingCart offerForShoppingCart) {
		Session session = sessionFactory.getCurrentSession();
		session.update(offerForShoppingCart);
		logger.info("OfferForShoppingCart updated successfully, OfferForShoppingCart Details=" + offerForShoppingCart);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OfferForShoppingCart> listOfferForShoppingCarts() {
		Session session = sessionFactory.getCurrentSession();
		List<OfferForShoppingCart> offerForShoppingCarts = session.createQuery("from OfferForShoppingCart").list();
		for(OfferForShoppingCart offerForShoppingCart : offerForShoppingCarts){
			logger.info("OfferForShoppingCart List::" + offerForShoppingCart);
		}
		return offerForShoppingCarts;
	}

	@Override
	public OfferForShoppingCart getOfferForShoppingCartById(int id) {
		Session session = sessionFactory.getCurrentSession();	
		OfferForShoppingCart offerForShoppingCart = (OfferForShoppingCart) session.get(OfferForShoppingCart.class, new Integer(id));
		logger.info("OfferForShoppingCart loaded successfully, OfferForShoppingCart details=" + offerForShoppingCart);
		return offerForShoppingCart;
	}

	@Override
	public void removeOfferForShoppingCart(int id) {
		Session session = sessionFactory.getCurrentSession();
		OfferForShoppingCart offerForShoppingCart = (OfferForShoppingCart) session.get(OfferForShoppingCart.class, new Integer(id));
		if(null != offerForShoppingCart){
			session.delete(offerForShoppingCart);
		}
		logger.info("OfferForShoppingCart deleted successfully, OfferForShoppingCart details=" + offerForShoppingCart);
	}

}
