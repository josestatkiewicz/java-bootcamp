package ar.com.ignacioflores.shoppingCart.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Product", catalog = "_shoppingcart")
public class Product implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private int idProduct;
	private String productName;
	private float price;
	private String description;
	private String category;
	private Set<ProductsForShoppingCart> productsForShoppingCarts = new HashSet<ProductsForShoppingCart>(0);
	private Set<ProductsForOffer> productsForOffers = new HashSet<ProductsForOffer>(0);

	public Product() {
	}

	

	@Override
	public String toString() {
		return String
				.format("{\n\tidProduct: %s\n\tproductName: %s\n\tprice: %s\n\tdescription: %s\n\tcategory: %s\n}",
						idProduct, productName, price,
						description, category);
	}



	public Product(int idProduct, String productName, float price) {
		this.idProduct = idProduct;
		this.productName = productName;
		this.price = price;
	}

	public Product(int idProduct, String productName, float price,
			String description, String category,
			Set<ProductsForShoppingCart> productsForShoppingCarts,
			Set<ProductsForOffer> productsForOffers) {
		this.idProduct = idProduct;
		this.productName = productName;
		this.price = price;
		this.description = description;
		this.category = category;
		this.productsForShoppingCarts = productsForShoppingCarts;
		this.productsForOffers = productsForOffers;
	}

	@Id
	@Column(name = "idProduct", unique = true, nullable = false)
	public int getIdProduct() {
		return this.idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	@Column(name = "productName", nullable = false, length = 45)
	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "price", nullable = false, precision = 12, scale = 0)
	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Column(name = "description", length = 90)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "category", length = 11)
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public Set<ProductsForShoppingCart> getProductsForShoppingCarts() {
		return this.productsForShoppingCarts;
	}

	public void setProductsForShoppingCarts(
			Set<ProductsForShoppingCart> productsForShoppingCarts) {
		this.productsForShoppingCarts = productsForShoppingCarts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public Set<ProductsForOffer> getProductsForOffers() {
		return this.productsForOffers;
	}

	public void setProductsForOffers(Set<ProductsForOffer> productsForOffers) {
		this.productsForOffers = productsForOffers;
	}

}
