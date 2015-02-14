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
@Table(name = "ProductsForOffer", catalog = "_shoppingcart")
public class ProductsForOffer implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private ProductsForOfferId id;
	private Offer offer;
	private Product product;
	private Integer quantity;

	public ProductsForOffer() {
	}

	public ProductsForOffer(ProductsForOfferId id, Offer offer, Product product) {
		this.id = id;
		this.offer = offer;
		this.product = product;
	}

	@Override
	public String toString() {
		return String
				.format("{\n\tid: %s\n\toffer: %s\n\tproduct: %s\n\tquantity: %s\n}",
						id, offer, product, quantity);
	}

	public ProductsForOffer(ProductsForOfferId id, Offer offer,
			Product product, Integer quantity) {
		this.id = id;
		this.offer = offer;
		this.product = product;
		this.quantity = quantity;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "product", column = @Column(name = "product", nullable = false)),
			@AttributeOverride(name = "offer", column = @Column(name = "offer", nullable = false)) })
	public ProductsForOfferId getId() {
		return this.id;
	}

	public void setId(ProductsForOfferId id) {
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
	@JoinColumn(name = "product", nullable = false, insertable = false, updatable = false)
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(name = "quantity")
	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
