package ar.com.ignacioflores.shoppingCart.dao.implement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ignacioflores.shoppingCart.dao.PayOrderDAO;
import ar.com.ignacioflores.shoppingCart.model.PayOrder;

@Repository
@Transactional
public class PayOrderDAOImpl implements PayOrderDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(PayOrderDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addPayOrder(PayOrder payOrder) {
		Session session = sessionFactory.getCurrentSession();
		session.save(payOrder);
		logger.info("PayOrder saved successfully, PayOrder Details=" + payOrder);
	}

	@Override
	public void updatePayOrder(PayOrder payOrder) {
		Session session = sessionFactory.getCurrentSession();
		session.update(payOrder);
		logger.info("PayOrder updated successfully, PayOrder Details=" + payOrder);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PayOrder> listPayOrders() {
		Session session = sessionFactory.getCurrentSession();
		List<PayOrder> payOrders = session.createQuery("from PayOrder").list();
		for(PayOrder payOrder : payOrders){
			logger.info("PayOrder List::" + payOrder);
		}
		return payOrders;
	}

	@Override
	public PayOrder getPayOrderById(int id) {
		Session session = sessionFactory.getCurrentSession();	
		PayOrder payOrder = (PayOrder) session.get(PayOrder.class, new Integer(id));
		logger.info("PayOrder loaded successfully, PayOrder details=" + payOrder);
		return payOrder;
	}

	@Override
	public void removePayOrder(int id) {
		Session session = sessionFactory.getCurrentSession();
		PayOrder payOrder = (PayOrder) session.get(PayOrder.class, new Integer(id));
		if(null != payOrder){
			session.delete(payOrder);
		}
		logger.info("PayOrder deleted successfully, PayOrder details=" + payOrder);
	}

}
