package ar.com.ignacioflores.shoppingCart.service.implement;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ignacioflores.shoppingCart.dao.ProductsForOfferIdDAO;
import ar.com.ignacioflores.shoppingCart.model.ProductsForOfferId;
import ar.com.ignacioflores.shoppingCart.service.ProductsForOfferIdService;

@Service
public class ProductsForOfferIdServiceImpl implements ProductsForOfferIdService, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private ProductsForOfferIdDAO productsForOfferIdDAO;

	public void setProductsForOfferIdDAO(ProductsForOfferIdDAO productsForOfferIdDAO) {
		this.productsForOfferIdDAO = productsForOfferIdDAO;
	}

	@Override
	@Transactional
	public void addProductsForOfferId(ProductsForOfferId productsForOfferId) {
		this.productsForOfferIdDAO.addProductsForOfferId(productsForOfferId);
	}

	@Override
	@Transactional
	public void updateProductsForOfferId(ProductsForOfferId productsForOfferId) {
		this.productsForOfferIdDAO.updateProductsForOfferId(productsForOfferId);
	}

	@Override
	@Transactional
	public List<ProductsForOfferId> listProductsForOfferIds() {
		return this.productsForOfferIdDAO.listProductsForOfferIds();
	}

	@Override
	@Transactional
	public ProductsForOfferId getProductsForOfferIdById(int id) {
		return this.productsForOfferIdDAO.getProductsForOfferIdById(id);
	}

	@Override
	@Transactional
	public void removeProductsForOfferId(int id) {
		this.productsForOfferIdDAO.removeProductsForOfferId(id);
	}

}