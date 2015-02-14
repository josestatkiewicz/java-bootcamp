package ar.com.ignacioflores.shoppingCart.dao.implement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ignacioflores.shoppingCart.dao.ProductsForShoppingCartIdDAO;
import ar.com.ignacioflores.shoppingCart.model.ProductsForShoppingCartId;

@Repository
@Transactional
public class ProductsForShoppingCartIdDAOImpl implements ProductsForShoppingCartIdDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductsForShoppingCartIdDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addProductsForShoppingCartId(ProductsForShoppingCartId productsForShoppingCartId) {
		Session session = sessionFactory.getCurrentSession();
		session.save(productsForShoppingCartId);
		logger.info("ProductsForShoppingCartId saved successfully, ProductsForShoppingCartId Details=" + productsForShoppingCartId);
	}

	@Override
	public void updateProductsForShoppingCartId(ProductsForShoppingCartId productsForShoppingCartId) {
		Session session = sessionFactory.getCurrentSession();
		session.update(productsForShoppingCartId);
		logger.info("ProductsForShoppingCartId updated successfully, ProductsForShoppingCartId Details=" + productsForShoppingCartId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductsForShoppingCartId> listProductsForShoppingCartIds() {
		Session session = sessionFactory.getCurrentSession();
		List<ProductsForShoppingCartId> productsForShoppingCartIds = session.createQuery("from ProductsForShoppingCartId").list();
		for(ProductsForShoppingCartId productsForShoppingCartId : productsForShoppingCartIds){
			logger.info("ProductsForShoppingCartId List::" + productsForShoppingCartId);
		}
		return productsForShoppingCartIds;
	}

	@Override
	public ProductsForShoppingCartId getProductsForShoppingCartIdById(int id) {
		Session session = sessionFactory.getCurrentSession();		
		ProductsForShoppingCartId productsForShoppingCartId = (ProductsForShoppingCartId) session.get(ProductsForShoppingCartId.class, new Integer(id));
		logger.info("ProductsForShoppingCartId loaded successfully, ProductsForShoppingCartId details=" + productsForShoppingCartId);
		return productsForShoppingCartId;
	}

	@Override
	public void removeProductsForShoppingCartId(int id) {
		Session session = sessionFactory.getCurrentSession();
		ProductsForShoppingCartId productsForShoppingCartId = (ProductsForShoppingCartId) session.get(ProductsForShoppingCartId.class, new Integer(id));
		if(null != productsForShoppingCartId){
			session.delete(productsForShoppingCartId);
		}
		logger.info("ProductsForShoppingCartId deleted successfully, ProductsForShoppingCartId details=" + productsForShoppingCartId);
	}

}
