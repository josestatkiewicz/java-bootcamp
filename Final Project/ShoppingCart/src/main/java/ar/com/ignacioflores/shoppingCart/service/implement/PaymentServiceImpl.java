package ar.com.ignacioflores.shoppingCart.service.implement;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ignacioflores.shoppingCart.dao.PaymentDAO;
import ar.com.ignacioflores.shoppingCart.model.Payment;
import ar.com.ignacioflores.shoppingCart.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private PaymentDAO paymentDAO;

	public void setPaymentDAO(PaymentDAO paymentDAO) {
		this.paymentDAO = paymentDAO;
	}

	@Override
	@Transactional
	public void addPayment(Payment payment) {
		this.paymentDAO.addPayment(payment);
	}

	@Override
	@Transactional
	public void updatePayment(Payment payment) {
		this.paymentDAO.updatePayment(payment);
	}

	@Override
	@Transactional
	public List<Payment> listPayments() {
		return this.paymentDAO.listPayments();
	}

	@Override
	@Transactional
	public Payment getPaymentById(int id) {
		return this.paymentDAO.getPaymentById(id);
	}

	@Override
	@Transactional
	public void removePayment(int id) {
		this.paymentDAO.removePayment(id);
	}

}