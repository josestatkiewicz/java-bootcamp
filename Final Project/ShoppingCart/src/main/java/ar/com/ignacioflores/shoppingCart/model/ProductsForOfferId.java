package ar.com.ignacioflores.shoppingCart.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProductsForOfferId implements java.io.Serializable {

	@Override
	public String toString() {
		return String.format("{\n\tproduct: %s\n\toffer: %s\n}",
				product, offer);
	}

	private static final long serialVersionUID = 1L;
	
	private int product;
	private int offer;

	public ProductsForOfferId() {
	}

	public ProductsForOfferId(int product, int offer) {
		this.product = product;
		this.offer = offer;
	}

	@Column(name = "product", nullable = false)
	public int getProduct() {
		return this.product;
	}

	public void setProduct(int product) {
		this.product = product;
	}

	@Column(name = "offer", nullable = false)
	public int getOffer() {
		return this.offer;
	}

	public void setOffer(int offer) {
		this.offer = offer;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ProductsForOfferId))
			return false;
		ProductsForOfferId castOther = (ProductsForOfferId) other;

		return (this.getProduct() == castOther.getProduct())
				&& (this.getOffer() == castOther.getOffer());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getProduct();
		result = 37 * result + this.getOffer();
		return result;
	}

}
