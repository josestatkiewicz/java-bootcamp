package ar.com.ignacioflores.shoppingCart.dao.implement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ignacioflores.shoppingCart.dao.ProductsForOfferIdDAO;
import ar.com.ignacioflores.shoppingCart.model.ProductsForOfferId;

@Repository
@Transactional
public class ProductsForOfferIdDAOImpl implements ProductsForOfferIdDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductsForOfferIdDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addProductsForOfferId(ProductsForOfferId productsForOfferId) {
		Session session = sessionFactory.getCurrentSession();
		session.save(productsForOfferId);
		logger.info("ProductsForOfferId saved successfully, ProductsForOfferId Details=" + productsForOfferId);
	}

	@Override
	public void updateProductsForOfferId(ProductsForOfferId productsForOfferId) {
		Session session = sessionFactory.getCurrentSession();
		session.update(productsForOfferId);
		logger.info("ProductsForOfferId updated successfully, ProductsForOfferId Details=" + productsForOfferId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductsForOfferId> listProductsForOfferIds() {
		Session session = sessionFactory.getCurrentSession();
		List<ProductsForOfferId> productsForOfferIds = session.createQuery("from ProductsForOfferId").list();
		for(ProductsForOfferId productsForOfferId : productsForOfferIds){
			logger.info("ProductsForOfferId List::" + productsForOfferId);
		}
		return productsForOfferIds;
	}

	@Override
	public ProductsForOfferId getProductsForOfferIdById(int id) {
		Session session = sessionFactory.getCurrentSession();		
		ProductsForOfferId productsForOfferId = (ProductsForOfferId) session.get(ProductsForOfferId.class, new Integer(id));
		logger.info("ProductsForOfferId loaded successfully, ProductsForOfferId details=" + productsForOfferId);
		return productsForOfferId;
	}

	@Override
	public void removeProductsForOfferId(int id) {
		Session session = sessionFactory.getCurrentSession();
		ProductsForOfferId productsForOfferId = (ProductsForOfferId) session.get(ProductsForOfferId.class, new Integer(id));
		if(null != productsForOfferId){
			session.delete(productsForOfferId);
		}
		logger.info("ProductsForOfferId deleted successfully, ProductsForOfferId details=" + productsForOfferId);
	}

}
