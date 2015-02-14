package ar.com.ignacioflores.shoppingCart.dao.implement;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ignacioflores.shoppingCart.dao.ProductDAO;
import ar.com.ignacioflores.shoppingCart.model.Product;

@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.save(product);
		logger.info("Product saved successfully, Product Details=" + product);
	}

	@Override
	public void updateProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.update(product);
		logger.info("Product updated successfully, Product Details=" + product);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> listProducts() {
		Session session = sessionFactory.openSession();
		List<Product> products = session.createQuery("from Product").list();
		for(Product product : products){
			logger.info("Product List::" + product);
		}
		return products;
	}

	@Override
	public Product getProductById(int id) {
		Session session = sessionFactory.getCurrentSession();	
		Product product = (Product) session.get(Product.class, new Integer(id));
		logger.info("Product loaded successfully, Product details=" + product);
		return product;
	}

	@Override
	public void removeProduct(int id) {
		Session session = sessionFactory.getCurrentSession();
		Product product = (Product) session.get(Product.class, new Integer(id));
		if(null != product){
			session.delete(product);
		}
		logger.info("Product deleted successfully, Product details=" + product);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findProductsByCategory(String category) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Product where category = :category");
		query.setParameter("category", category);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findProductsByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Product where productName like :productName");
		query.setParameter("productName", "%"+name+"%");
		return query.list();
	}	
}
