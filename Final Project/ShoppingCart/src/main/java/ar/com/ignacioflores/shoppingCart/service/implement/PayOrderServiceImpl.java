package ar.com.ignacioflores.shoppingCart.service.implement;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ignacioflores.shoppingCart.dao.PayOrderDAO;
import ar.com.ignacioflores.shoppingCart.model.PayOrder;
import ar.com.ignacioflores.shoppingCart.service.PayOrderService;

@Service
public class PayOrderServiceImpl implements PayOrderService, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private PayOrderDAO payOrderDAO;

	public void setPayOrderDAO(PayOrderDAO payOrderDAO) {
		this.payOrderDAO = payOrderDAO;
	}

	@Override
	@Transactional
	public void addPayOrder(PayOrder payOrder) {
		this.payOrderDAO.addPayOrder(payOrder);
	}

	@Override
	@Transactional
	public void updatePayOrder(PayOrder payOrder) {
		this.payOrderDAO.updatePayOrder(payOrder);
	}

	@Override
	@Transactional
	public List<PayOrder> listPayOrders() {
		return this.payOrderDAO.listPayOrders();
	}

	@Override
	@Transactional
	public PayOrder getPayOrderById(int id) {
		return this.payOrderDAO.getPayOrderById(id);
	}

	@Override
	@Transactional
	public void removePayOrder(int id) {
		this.payOrderDAO.removePayOrder(id);
	}

}