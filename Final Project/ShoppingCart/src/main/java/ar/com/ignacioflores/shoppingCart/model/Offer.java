package ar.com.ignacioflores.shoppingCart.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Offer", catalog = "_shoppingcart")
public class Offer implements java.io.Serializable {

	@Override
	public String toString() {
		return String.format(
				"{\n\tidOffer: %s\n\tprice: %s\n\tdescription: %s\n}",
				idOffer, price, description);
	}

	private static final long serialVersionUID = 1L;
	
	private Integer idOffer;
	private Float price;
	private String description;
	private Set<ProductsForOffer> productsForOffers = new HashSet<ProductsForOffer>(0);
	private Set<OfferForShoppingCart> offerForShoppingCarts = new HashSet<OfferForShoppingCart>(0);

	public Offer() {
	}

	public Offer(Float price, String description, Set<ProductsForOffer> productsForOffers, Set<OfferForShoppingCart> offerForShoppingCarts) {
		this.price = price;
		this.description = description;
		this.productsForOffers = productsForOffers;
		this.offerForShoppingCarts = offerForShoppingCarts;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idOffer", unique = true, nullable = false)
	public Integer getIdOffer() {
		return this.idOffer;
	}

	public void setIdOffer(Integer idOffer) {
		this.idOffer = idOffer;
	}

	@Column(name = "price", precision = 12, scale = 0)
	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Column(name = "description", length = 45)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "offer")
	public Set<ProductsForOffer> getProductsForOffers() {
		return this.productsForOffers;
	}

	public void setProductsForOffers(Set<ProductsForOffer> productsForOffers) {
		this.productsForOffers = productsForOffers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "offer")
	public Set<OfferForShoppingCart> getOfferForShoppingCarts() {
		return this.offerForShoppingCarts;
	}

	public void setOfferForShoppingCarts(
			Set<OfferForShoppingCart> offerForShoppingCarts) {
		this.offerForShoppingCarts = offerForShoppingCarts;
	}

}
