package ar.com.ignacioflores.shoppingCart.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OfferForShoppingCart", catalog = "_shoppingcart")
public class OfferForShoppingCart implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private OfferForShoppingCartId id;
	private Offer offer;
	private ShoppingCart shoppingCart;
	private Integer quantity;
	private Float price;

	@Override
	public String toString() {
		return String
				.format("{\n\tid: %s\n\toffer: %s\n\tshoppingCart: %s\n\tquantity: %s\n\tprice: %s\n}",
						id, offer, shoppingCart,
						quantity, price);
	}

	public OfferForShoppingCart() {
	}

	public OfferForShoppingCart(OfferForShoppingCartId id, Offer offer,
			ShoppingCart shoppingCart) {
		this.id = id;
		this.offer = offer;
		this.shoppingCart = shoppingCart;
	}

	public OfferForShoppingCart(OfferForShoppingCartId id, Offer offer,
			ShoppingCart shoppingCart, Integer quantity, Float price) {
		this.id = id;
		this.offer = offer;
		this.shoppingCart = shoppingCart;
		this.quantity = quantity;
		this.price = price;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "offer", column = @Column(name = "offer", nullable = false)),
			@AttributeOverride(name = "shoppingCart", column = @Column(name = "shoppingCart", nullable = false)) })
	public OfferForShoppingCartId getId() {
		return this.id;
	}

	public void setId(OfferForShoppingCartId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "offer", nullable = false, insertable = false, updatable = false)
	public Offer getOffer() {
		return this.offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shoppingCart", nullable = false, insertable = false, updatable = false)
	public ShoppingCart getShoppingCart() {
		return this.shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	@Column(name = "quantity")
	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Column(name = "price", precision = 12, scale = 0)
	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

}
