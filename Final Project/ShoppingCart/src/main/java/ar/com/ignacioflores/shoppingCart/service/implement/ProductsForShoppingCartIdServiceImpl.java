package ar.com.ignacioflores.shoppingCart.service.implement;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ignacioflores.shoppingCart.dao.ProductsForShoppingCartIdDAO;
import ar.com.ignacioflores.shoppingCart.model.ProductsForShoppingCartId;
import ar.com.ignacioflores.shoppingCart.service.ProductsForShoppingCartIdService;

@Service
public class ProductsForShoppingCartIdServiceImpl implements ProductsForShoppingCartIdService, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private ProductsForShoppingCartIdDAO productsForShoppingCartIdDAO;

	public void setProductsForShoppingCartIdDAO(ProductsForShoppingCartIdDAO productsForShoppingCartIdDAO) {
		this.productsForShoppingCartIdDAO = productsForShoppingCartIdDAO;
	}

	@Override
	@Transactional
	public void addProductsForShoppingCartId(ProductsForShoppingCartId productsForShoppingCartId) {
		this.productsForShoppingCartIdDAO.addProductsForShoppingCartId(productsForShoppingCartId);
	}

	@Override
	@Transactional
	public void updateProductsForShoppingCartId(ProductsForShoppingCartId productsForShoppingCartId) {
		this.productsForShoppingCartIdDAO.updateProductsForShoppingCartId(productsForShoppingCartId);
	}

	@Override
	@Transactional
	public List<ProductsForShoppingCartId> listProductsForShoppingCartIds() {
		return this.productsForShoppingCartIdDAO.listProductsForShoppingCartIds();
	}

	@Override
	@Transactional
	public ProductsForShoppingCartId getProductsForShoppingCartIdById(int id) {
		return this.productsForShoppingCartIdDAO.getProductsForShoppingCartIdById(id);
	}

	@Override
	@Transactional
	public void removeProductsForShoppingCartId(int id) {
		this.productsForShoppingCartIdDAO.removeProductsForShoppingCartId(id);
	}

}