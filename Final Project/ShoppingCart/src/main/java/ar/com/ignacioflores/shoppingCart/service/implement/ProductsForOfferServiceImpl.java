package ar.com.ignacioflores.shoppingCart.service.implement;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ignacioflores.shoppingCart.dao.ProductsForOfferDAO;
import ar.com.ignacioflores.shoppingCart.model.ProductsForOffer;
import ar.com.ignacioflores.shoppingCart.service.ProductsForOfferService;

@Service
public class ProductsForOfferServiceImpl implements ProductsForOfferService, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private ProductsForOfferDAO productsForOfferDAO;

	public void setProductsForOfferDAO(ProductsForOfferDAO productsForOfferDAO) {
		this.productsForOfferDAO = productsForOfferDAO;
	}

	@Override
	@Transactional
	public void addProductsForOffer(ProductsForOffer productsForOffer) {
		this.productsForOfferDAO.addProductsForOffer(productsForOffer);
	}

	@Override
	@Transactional
	public void updateProductsForOffer(ProductsForOffer productsForOffer) {
		this.productsForOfferDAO.updateProductsForOffer(productsForOffer);
	}

	@Override
	@Transactional
	public List<ProductsForOffer> listProductsForOffers() {
		return this.productsForOfferDAO.listProductsForOffers();
	}

	@Override
	@Transactional
	public ProductsForOffer getProductsForOfferById(int id) {
		return this.productsForOfferDAO.getProductsForOfferById(id);
	}

	@Override
	@Transactional
	public void removeProductsForOffer(int id) {
		this.productsForOfferDAO.removeProductsForOffer(id);
	}

}