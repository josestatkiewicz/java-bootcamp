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
@Table(name = "ProductsForShoppingCart", catalog = "_shoppingcart")
public class ProductsForShoppingCart implements java.io.Serializable {

	@Override
	public String toString() {
		return String
				.format("{\n\tid: %s\n\tproduct: %s\n\tshoppingCart: %s\n\tquantity: %s\n\tprice: %s\n}",
						id, product, shoppingCart,
						quantity, price);
	}

	private static final long serialVersionUID = 1L;
	
	private ProductsForShoppingCartId id;
	private Product product;
	private ShoppingCart shoppingCart;
	private Integer quantity;
	private Float price;

	public ProductsForShoppingCart() {
	}

	public ProductsForShoppingCart(ProductsForShoppingCartId id, Product product, ShoppingCart shoppingCart) {
		this.id = id;
		this.product = product;
		this.shoppingCart = shoppingCart;
	}

	public ProductsForShoppingCart(	ProductsForShoppingCartId id, Product product, ShoppingCart shoppingCart, 
									Integer quantity, Float price) {
		this.id = id;
		this.product = product;
		this.shoppingCart = shoppingCart;
		this.quantity = quantity;
		this.price = price;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "shoppingCart", column = @Column(name = "shoppingCart", nullable = false)),
			@AttributeOverride(name = "product", column = @Column(name = "product", nullable = false)) })
	public ProductsForShoppingCartId getId() {
		return this.id;
	}

	public void setId(ProductsForShoppingCartId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product", nullable = false, insertable = false, updatable = false)
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
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
