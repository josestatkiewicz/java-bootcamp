package ar.com.ignacioflores.shoppingCart.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProductsForShoppingCartId implements java.io.Serializable {

	@Override
	public String toString() {
		return String.format("{\n\tshoppingCart: %s\n\tproduct: %s\n}",
				shoppingCart, product);
	}

	private static final long serialVersionUID = 1L;
	
	private int shoppingCart;
	private int product;

	public ProductsForShoppingCartId() {
	}

	public ProductsForShoppingCartId(int shoppingCart, int product) {
		this.shoppingCart = shoppingCart;
		this.product = product;
	}

	@Column(name = "shoppingCart", nullable = false)
	public int getShoppingCart() {
		return this.shoppingCart;
	}

	public void setShoppingCart(int shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	@Column(name = "product", nullable = false)
	public int getProduct() {
		return this.product;
	}

	public void setProduct(int product) {
		this.product = product;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ProductsForShoppingCartId))
			return false;
		ProductsForShoppingCartId castOther = (ProductsForShoppingCartId) other;

		return (this.getShoppingCart() == castOther.getShoppingCart())
				&& (this.getProduct() == castOther.getProduct());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getShoppingCart();
		result = 37 * result + this.getProduct();
		return result;
	}

}
