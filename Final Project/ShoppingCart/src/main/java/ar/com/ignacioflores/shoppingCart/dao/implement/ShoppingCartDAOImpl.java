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

import ar.com.ignacioflores.shoppingCart.dao.ShoppingCartDAO;
import ar.com.ignacioflores.shoppingCart.model.Product;
import ar.com.ignacioflores.shoppingCart.model.ShoppingCart;

@Repository
@Transactional
public class ShoppingCartDAOImpl implements ShoppingCartDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(ShoppingCartDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addShoppingCart(ShoppingCart shoppingCart) {
		Session session = sessionFactory.getCurrentSession();
		session.save(shoppingCart);
		logger.info("ShoppingCart saved successfully, ShoppingCart Details=" + shoppingCart);
	}

	@Override
	public void updateShoppingCart(ShoppingCart shoppingCart) {
		Session session = sessionFactory.getCurrentSession();
		session.update(shoppingCart);
		logger.info("ShoppingCart updated successfully, ShoppingCart Details=" + shoppingCart);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShoppingCart> listShoppingCarts() {
		Session session = sessionFactory.getCurrentSession();
		List<ShoppingCart> shoppingCarts = session.createQuery("from ShoppingCart").list();
		for(ShoppingCart shoppingCart : shoppingCarts){
			logger.info("ShoppingCart List::" + shoppingCart);
		}
		return shoppingCarts;
	}

	@Override
	public ShoppingCart getShoppingCartById(int id) {
		Session session = sessionFactory.getCurrentSession();	
		ShoppingCart shoppingCart = (ShoppingCart) session.get(ShoppingCart.class, new Integer(id));
		logger.info("ShoppingCart loaded successfully, ShoppingCart details=" + shoppingCart);
		return shoppingCart;
	}

	@Override
	public void removeShoppingCart(int id) {
		Session session = sessionFactory.getCurrentSession();
		ShoppingCart shoppingCart = (ShoppingCart) session.get(ShoppingCart.class, new Integer(id));
		if(null != shoppingCart){
			session.delete(shoppingCart);
		}
		logger.info("ShoppingCart deleted successfully, ShoppingCart details=" + shoppingCart);
	}

	@Override
	public Product getMostExpensiveProduct(Integer shoppingCartId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Product P "
										+ "where (P.idProduct = select distinct PFSC.product "
										+ "						from ProductsForShoppingCart PFSC "
										+ "						where PFSC.shoppingCart = :shoppingCart and (PFSC.price / PFSC.quantity = select max(PFSC2.price/PFSC.quantity) "
										+ "																								 from ProductsForShoppingCart PFSC2));");
		query.setParameter("shoppingCart", shoppingCartId);
		return (Product) query.list().get(0);
	}
	
	@Override
	public Product getCheapestProduct(Integer shoppingCartId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Product P "
				+ "where (P.idProduct = select distinct PFSC.product "
				+ "						from ProductsForShoppingCart PFSC "
				+ "						where PFSC.shoppingCart = :shoppingCart and (PFSC.price / PFSC.quantity = select min(PFSC2.price/PFSC.quantity) "
				+ "																								  from ProductsForShoppingCart PFSC2));");
query.setParameter("shoppingCart", shoppingCartId);
return (Product) query.list().get(0);
	}

}
