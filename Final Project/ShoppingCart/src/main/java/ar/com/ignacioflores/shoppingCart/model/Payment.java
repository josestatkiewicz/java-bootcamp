package ar.com.ignacioflores.shoppingCart.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Payment", catalog = "_shoppingcart")
public class Payment implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer idPayment;
	private PayOrder payOrder;
	private Float amount;
	private Date paymentDate;
	private String paymentType;

	public Payment() {
	}

	@Override
	public String toString() {
		return String
				.format("{\n\tidPayment: %s\n\tpayOrder: %s\n\tamount: %s\n\tpaymentDate: %s\n\tpaymentType: %s\n}",
						idPayment, payOrder, amount,
						paymentDate, paymentType);
	}

	public Payment(PayOrder payOrder) {
		this.payOrder = payOrder;
	}

	public Payment(PayOrder payOrder, Float amount, Date paymentDate,
			String paymentType) {
		this.payOrder = payOrder;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.paymentType = paymentType;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idPayment", unique = true, nullable = false)
	public Integer getIdPayment() {
		return this.idPayment;
	}

	public void setIdPayment(Integer idPayment) {
		this.idPayment = idPayment;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payOrder", nullable = false)
	public PayOrder getPayOrder() {
		return this.payOrder;
	}

	public void setPayOrder(PayOrder payOrder) {
		this.payOrder = payOrder;
	}

	@Column(name = "amount", precision = 12, scale = 0)
	public Float getAmount() {
		return this.amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "paymentDate", length = 10)
	public Date getPaymentDate() {
		return this.paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	@Column(name = "paymentType", length = 11)
	public String getPaymentType() {
		return this.paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

}
