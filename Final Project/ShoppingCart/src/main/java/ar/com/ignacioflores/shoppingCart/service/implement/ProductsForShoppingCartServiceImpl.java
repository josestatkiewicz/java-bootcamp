package ar.com.ignacioflores.shoppingCart.service.implement;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ignacioflores.shoppingCart.dao.ProductsForShoppingCartDAO;
import ar.com.ignacioflores.shoppingCart.model.ProductsForShoppingCart;
import ar.com.ignacioflores.shoppingCart.service.ProductsForShoppingCartService;

@Service
public class ProductsForShoppingCartServiceImpl implements ProductsForShoppingCartService, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private ProductsForShoppingCartDAO productsForShoppingCartDAO;

	public void setProductsForShoppingCartDAO(ProductsForShoppingCartDAO productsForShoppingCartDAO) {
		this.productsForShoppingCartDAO = productsForShoppingCartDAO;
	}

	@Override
	@Transactional
	public void addProductsForShoppingCart(ProductsForShoppingCart productsForShoppingCart) {
		this.productsForShoppingCartDAO.addProductsForShoppingCart(productsForShoppingCart);
	}

	@Override
	@Transactional
	public void updateProductsForShoppingCart(ProductsForShoppingCart productsForShoppingCart) {
		this.productsForShoppingCartDAO.updateProductsForShoppingCart(productsForShoppingCart);
	}

	@Override
	@Transactional
	public List<ProductsForShoppingCart> listProductsForShoppingCarts() {
		return this.productsForShoppingCartDAO.listProductsForShoppingCarts();
	}

	@Override
	@Transactional
	public ProductsForShoppingCart getProductsForShoppingCartById(int id) {
		return this.productsForShoppingCartDAO.getProductsForShoppingCartById(id);
	}

	@Override
	@Transactional
	public void removeProductsForShoppingCart(int id) {
		this.productsForShoppingCartDAO.removeProductsForShoppingCart(id);
	}

}