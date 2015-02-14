package ar.com.ignacioflores.shoppingCart.dao.implement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ignacioflores.shoppingCart.dao.PaymentDAO;
import ar.com.ignacioflores.shoppingCart.model.Payment;

@Repository
@Transactional
public class PaymentDAOImpl implements PaymentDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(PaymentDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addPayment(Payment payment) {
		Session session = sessionFactory.getCurrentSession();
		session.save(payment);
		logger.info("Payment saved successfully, Payment Details=" + payment);
	}

	@Override
	public void updatePayment(Payment payment) {
		Session session = sessionFactory.getCurrentSession();
		session.update(payment);
		logger.info("Payment updated successfully, Payment Details=" + payment);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Payment> listPayments() {
		Session session = sessionFactory.getCurrentSession();
		List<Payment> payments = session.createQuery("from Payment").list();
		for(Payment payment : payments){
			logger.info("Payment List::" + payment);
		}
		return payments;
	}

	@Override
	public Payment getPaymentById(int id) {
		Session session = sessionFactory.getCurrentSession();		
		Payment payment = (Payment) session.get(Payment.class, new Integer(id));
		logger.info("Payment loaded successfully, Payment details=" + payment);
		return payment;
	}

	@Override
	public void removePayment(int id) {
		Session session = sessionFactory.getCurrentSession();
		Payment payment = (Payment) session.get(Payment.class, new Integer(id));
		if(null != payment){
			session.delete(payment);
		}
		logger.info("Payment deleted successfully, Payment details=" + payment);
	}

}
