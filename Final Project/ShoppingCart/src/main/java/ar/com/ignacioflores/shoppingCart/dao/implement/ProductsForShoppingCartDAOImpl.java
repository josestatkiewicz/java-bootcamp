package ar.com.ignacioflores.shoppingCart.dao.implement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ignacioflores.shoppingCart.dao.ProductsForShoppingCartDAO;
import ar.com.ignacioflores.shoppingCart.model.ProductsForShoppingCart;

@Repository
@Transactional
public class ProductsForShoppingCartDAOImpl implements ProductsForShoppingCartDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductsForShoppingCartDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addProductsForShoppingCart(ProductsForShoppingCart productsForShoppingCart) {
		Session session = sessionFactory.getCurrentSession();
		session.save(productsForShoppingCart);
		logger.info("ProductsForShoppingCart saved successfully, ProductsForShoppingCart Details=" + productsForShoppingCart);
	}

	@Override
	public void updateProductsForShoppingCart(ProductsForShoppingCart productsForShoppingCart) {
		Session session = sessionFactory.getCurrentSession();
		session.update(productsForShoppingCart);
		logger.info("ProductsForShoppingCart updated successfully, ProductsForShoppingCart Details=" + productsForShoppingCart);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductsForShoppingCart> listProductsForShoppingCarts() {
		Session session = sessionFactory.getCurrentSession();
		List<ProductsForShoppingCart> productsForShoppingCarts = session.createQuery("from ProductsForShoppingCart").list();
		for(ProductsForShoppingCart productsForShoppingCart : productsForShoppingCarts){
			logger.info("ProductsForShoppingCart List::" + productsForShoppingCart);
		}
		return productsForShoppingCarts;
	}

	@Override
	public ProductsForShoppingCart getProductsForShoppingCartById(int id) {
		Session session = sessionFactory.getCurrentSession();	
		ProductsForShoppingCart productsForShoppingCart = (ProductsForShoppingCart) session.get(ProductsForShoppingCart.class, new Integer(id));
		logger.info("ProductsForShoppingCart loaded successfully, ProductsForShoppingCart details=" + productsForShoppingCart);
		return productsForShoppingCart;
	}

	@Override
	public void removeProductsForShoppingCart(int id) {
		Session session = sessionFactory.getCurrentSession();
		ProductsForShoppingCart productsForShoppingCart = (ProductsForShoppingCart) session.get(ProductsForShoppingCart.class, new Integer(id));
		if(null != productsForShoppingCart){
			session.delete(productsForShoppingCart);
		}
		logger.info("ProductsForShoppingCart deleted successfully, ProductsForShoppingCart details=" + productsForShoppingCart);
	}

}
