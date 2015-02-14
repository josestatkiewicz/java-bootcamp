package ar.com.ignacioflores.shoppingCart.dao.implement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ignacioflores.shoppingCart.dao.ProductsForOfferDAO;
import ar.com.ignacioflores.shoppingCart.model.ProductsForOffer;

@Repository
@Transactional
public class ProductsForOfferDAOImpl implements ProductsForOfferDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductsForOfferDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addProductsForOffer(ProductsForOffer productsForOffer) {
		Session session = sessionFactory.getCurrentSession();
		session.save(productsForOffer);
		logger.info("ProductsForOffer saved successfully, ProductsForOffer Details=" + productsForOffer);
	}

	@Override
	public void updateProductsForOffer(ProductsForOffer productsForOffer) {
		Session session = sessionFactory.getCurrentSession();
		session.update(productsForOffer);
		logger.info("ProductsForOffer updated successfully, ProductsForOffer Details=" + productsForOffer);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductsForOffer> listProductsForOffers() {
		Session session = sessionFactory.getCurrentSession();
		List<ProductsForOffer> productsForOffers = session.createQuery("from ProductsForOffer").list();
		for(ProductsForOffer productsForOffer : productsForOffers){
			logger.info("ProductsForOffer List::" + productsForOffer);
		}
		return productsForOffers;
	}

	@Override
	public ProductsForOffer getProductsForOfferById(int id) {
		Session session = sessionFactory.getCurrentSession();	
		ProductsForOffer productsForOffer = (ProductsForOffer) session.get(ProductsForOffer.class, new Integer(id));
		logger.info("ProductsForOffer loaded successfully, ProductsForOffer details=" + productsForOffer);
		return productsForOffer;
	}

	@Override
	public void removeProductsForOffer(int id) {
		Session session = sessionFactory.getCurrentSession();
		ProductsForOffer productsForOffer = (ProductsForOffer) session.get(ProductsForOffer.class, new Integer(id));
		if(null != productsForOffer){
			session.delete(productsForOffer);
		}
		logger.info("ProductsForOffer deleted successfully, ProductsForOffer details=" + productsForOffer);
	}

}
