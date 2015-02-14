package ar.com.ignacioflores.shoppingCart.service.implement;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ignacioflores.shoppingCart.dao.ProductDAO;
import ar.com.ignacioflores.shoppingCart.model.Product;
import ar.com.ignacioflores.shoppingCart.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private ProductDAO productDAO;

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	@Override
	@Transactional
	public void addProduct(Product product) {
		this.productDAO.addProduct(product);
	}

	@Override
	@Transactional
	public void updateProduct(Product product) {
		this.productDAO.updateProduct(product);
	}

	@Override
	@Transactional
	public List<Product> listProducts() {
		return this.productDAO.listProducts();
	}

	@Override
	@Transactional
	public Product getProductById(int id) {
		return this.productDAO.getProductById(id);
	}

	@Override
	@Transactional
	public void removeProduct(int id) {
		this.productDAO.removeProduct(id);
	}

	@Override
	public List<Product> findProductsByCategory(String category) {
		List<Product> products = productDAO.findProductsByCategory(category);
		return products;
	}
	
	@Override
	public List<Product> findProductsByName(String name) {
		List<Product> products = productDAO.findProductsByName(name);
		return products;
	}

}