package ar.com.ignacioflores.shoppingCart.dao;

import java.util.List;

import ar.com.ignacioflores.shoppingCart.model.Payment;

public interface PaymentDAO {

	public void addPayment(Payment payment);
    public void updatePayment(Payment payment);
    public List<Payment> listPayments();
    public Payment getPaymentById(int paymentId);
    public void removePayment(int paymentId);
}
