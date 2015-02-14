package ar.com.ignacioflores.shoppingCart.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PayOrder", catalog = "_shoppingcart")
public class PayOrder implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer idPayOrder;
	private ShoppingCart shoppingCart;
	private Float price;
	private String discount;
	private Date orderedDate;
	private Date paidDate;
	private String payStatus;
	private Set<Payment> payments = new HashSet<Payment>(0);

	@Override
	public String toString() {
		return String
				.format("{\n\tidPayOrder: %s\n\tshoppingCart: %s\n\tprice: %s\n\tdiscount: %s\n\torderedDate: %s\n\tpaidDate: %s\n\tpayStatus: %s\n}",
						idPayOrder, shoppingCart, price,
						discount, orderedDate, paidDate, payStatus);
	}
	
	public PayOrder() {
	}

	public PayOrder(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public PayOrder(ShoppingCart shoppingCart, Float price, String discount,
			Date orderedDate, Date paidDate, String payStatus,
			Set<Payment> payments) {
		this.shoppingCart = shoppingCart;
		this.price = price;
		this.discount = discount;
		this.orderedDate = orderedDate;
		this.paidDate = paidDate;
		this.payStatus = payStatus;
		this.payments = payments;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idPayOrder", unique = true, nullable = false)
	public Integer getIdPayOrder() {
		return this.idPayOrder;
	}

	public void setIdPayOrder(Integer idPayOrder) {
		this.idPayOrder = idPayOrder;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shoppingCart", nullable = false)
	public ShoppingCart getShoppingCart() {
		return this.shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	@Column(name = "price", precision = 12, scale = 0)
	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Column(name = "discount", length = 45)
	public String getDiscount() {
		return this.discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "orderedDate", length = 10)
	public Date getOrderedDate() {
		return this.orderedDate;
	}

	public void setOrderedDate(Date orderedDate) {
		this.orderedDate = orderedDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "paidDate", length = 10)
	public Date getPaidDate() {
		return this.paidDate;
	}

	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}

	@Column(name = "payStatus", length = 7)
	public String getPayStatus() {
		return this.payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "payOrder")
	public Set<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}

}
