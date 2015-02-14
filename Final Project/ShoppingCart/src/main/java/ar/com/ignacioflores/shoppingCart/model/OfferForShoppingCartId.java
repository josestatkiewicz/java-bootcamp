package ar.com.ignacioflores.shoppingCart.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OfferForShoppingCartId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private int offer;
	private int shoppingCart;

	public OfferForShoppingCartId() {
	}

	@Override
	public String toString() {
		return String.format("{\n\toffer: %s\n\tshoppingCart: %s\n}",
				offer, shoppingCart);
	}

	public OfferForShoppingCartId(int offer, int shoppingCart) {
		this.offer = offer;
		this.shoppingCart = shoppingCart;
	}

	@Column(name = "offer", nullable = false)
	public int getOffer() {
		return this.offer;
	}

	public void setOffer(int offer) {
		this.offer = offer;
	}

	@Column(name = "shoppingCart", nullable = false)
	public int getShoppingCart() {
		return this.shoppingCart;
	}

	public void setShoppingCart(int shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OfferForShoppingCartId))
			return false;
		OfferForShoppingCartId castOther = (OfferForShoppingCartId) other;

		return (this.getOffer() == castOther.getOffer())
				&& (this.getShoppingCart() == castOther.getShoppingCart());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getOffer();
		result = 37 * result + this.getShoppingCart();
		return result;
	}

}
