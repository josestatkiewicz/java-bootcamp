package ar.com.ignacioflores.shoppingCart.service;

import java.util.List;

import ar.com.ignacioflores.shoppingCart.model.PayOrder;

public interface PayOrderService{

	public void addPayOrder(PayOrder payOrder);
    public void updatePayOrder(PayOrder payOrder);
    public List<PayOrder> listPayOrders();
    public PayOrder getPayOrderById(int payOrderId);
    public void removePayOrder(int payOrderId);
	
}