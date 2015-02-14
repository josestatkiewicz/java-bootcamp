package ar.com.ignacioflores.shoppingCart.service.implement;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ignacioflores.shoppingCart.dao.OfferForShoppingCartDAO;
import ar.com.ignacioflores.shoppingCart.model.OfferForShoppingCart;
import ar.com.ignacioflores.shoppingCart.service.OfferForShoppingCartService;

@Service
public class OfferForShoppingCartServiceImpl implements OfferForShoppingCartService, Serializable {
	
	private static final long serialVersionUID = 1L;

	private OfferForShoppingCartDAO offerForShoppingCartDAO;

	public void setOfferForShoppingCartDAO(OfferForShoppingCartDAO offerForShoppingCartDAO) {
		this.offerForShoppingCartDAO = offerForShoppingCartDAO;
	}

	@Override
	@Transactional
	public void addOfferForShoppingCart(OfferForShoppingCart offerForShoppingCart) {
		this.offerForShoppingCartDAO.addOfferForShoppingCart(offerForShoppingCart);
	}

	@Override
	@Transactional
	public void updateOfferForShoppingCart(OfferForShoppingCart offerForShoppingCart) {
		this.offerForShoppingCartDAO.updateOfferForShoppingCart(offerForShoppingCart);
	}

	@Override
	@Transactional
	public List<OfferForShoppingCart> listOfferForShoppingCarts() {
		return this.offerForShoppingCartDAO.listOfferForShoppingCarts();
	}

	@Override
	@Transactional
	public OfferForShoppingCart getOfferForShoppingCartById(int id) {
		return this.offerForShoppingCartDAO.getOfferForShoppingCartById(id);
	}

	@Override
	@Transactional
	public void removeOfferForShoppingCart(int id) {
		this.offerForShoppingCartDAO.removeOfferForShoppingCart(id);
	}

}