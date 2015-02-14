package ar.com.ignacioflores.shoppingCart.model;

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

@Entity
@Table(name = "ShoppingCart", catalog = "_shoppingcart")
public class ShoppingCart implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer idShoppingCart;
	private User user;
	private Float amount;
	private String shoppingCartStatus;
	private Set<PayOrder> payOrders = new HashSet<PayOrder>(0);
	@Override
	public String toString() {
		return String
				.format("{\n\tidShoppingCart: %s\n\tuser: %s\n\tamount: %s\n\tshoppingCartStatus: %s\n}",
						idShoppingCart, user, amount,
						shoppingCartStatus);
	}

	private Set<OfferForShoppingCart> offerForShoppingCarts = new HashSet<OfferForShoppingCart>(0);
	private Set<ProductsForShoppingCart> productsForShoppingCarts = new HashSet<ProductsForShoppingCart>(0);

	public ShoppingCart() {
	}

	public ShoppingCart(User user, Float amount, String shoppingCartStatus,
						Set<PayOrder> payOrders,
						Set<OfferForShoppingCart> offerForShoppingCarts,
						Set<ProductsForShoppingCart> productsForShoppingCarts) {
		this.user = user;
		this.amount = amount;
		this.shoppingCartStatus = shoppingCartStatus;
		this.payOrders = payOrders;
		this.offerForShoppingCarts = offerForShoppingCarts;
		this.productsForShoppingCarts = productsForShoppingCarts;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idShoppingCart", unique = true, nullable = false)
	public Integer getIdShoppingCart() {
		return this.idShoppingCart;
	}

	public void setIdShoppingCart(Integer idShoppingCart) {
		this.idShoppingCart = idShoppingCart;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "amount", precision = 12, scale = 0)
	public Float getAmount() {
		return this.amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	@Column(name = "shoppingCartStatus", length = 13)
	public String getShoppingCartStatus() {
		return this.shoppingCartStatus;
	}

	public void setShoppingCartStatus(String shoppingCartStatus) {
		this.shoppingCartStatus = shoppingCartStatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "shoppingCart")
	public Set<PayOrder> getPayOrders() {
		return this.payOrders;
	}

	public void setPayOrders(Set<PayOrder> payOrders) {
		this.payOrders = payOrders;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "shoppingCart")
	public Set<OfferForShoppingCart> getOfferForShoppingCarts() {
		return this.offerForShoppingCarts;
	}

	public void setOfferForShoppingCarts(
			Set<OfferForShoppingCart> offerForShoppingCarts) {
		this.offerForShoppingCarts = offerForShoppingCarts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "shoppingCart")
	public Set<ProductsForShoppingCart> getProductsForShoppingCarts() {
		return this.productsForShoppingCarts;
	}

	public void setProductsForShoppingCarts(
			Set<ProductsForShoppingCart> productsForShoppingCarts) {
		this.productsForShoppingCarts = productsForShoppingCarts;
	}

}
