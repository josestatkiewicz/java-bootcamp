package ar.com.ignacioflores.shoppingCart.service.implement;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ignacioflores.shoppingCart.dao.OfferForShoppingCartIdDAO;
import ar.com.ignacioflores.shoppingCart.model.OfferForShoppingCartId;
import ar.com.ignacioflores.shoppingCart.service.OfferForShoppingCartIdService;

@Service
public class OfferForShoppingCartIdServiceImpl implements OfferForShoppingCartIdService, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private OfferForShoppingCartIdDAO offerForShoppingCartIdDAO;

	public void setOfferForShoppingCartIdDAO(OfferForShoppingCartIdDAO offerForShoppingCartIdDAO) {
		this.offerForShoppingCartIdDAO = offerForShoppingCartIdDAO;
	}

	@Override
	@Transactional
	public void addOfferForShoppingCartId(OfferForShoppingCartId offerForShoppingCartId) {
		this.offerForShoppingCartIdDAO.addOfferForShoppingCartId(offerForShoppingCartId);
	}

	@Override
	@Transactional
	public void updateOfferForShoppingCartId(OfferForShoppingCartId offerForShoppingCartId) {
		this.offerForShoppingCartIdDAO.updateOfferForShoppingCartId(offerForShoppingCartId);
	}

	@Override
	@Transactional
	public List<OfferForShoppingCartId> listOfferForShoppingCartIds() {
		return this.offerForShoppingCartIdDAO.listOfferForShoppingCartIds();
	}

	@Override
	@Transactional
	public OfferForShoppingCartId getOfferForShoppingCartIdById(int id) {
		return this.offerForShoppingCartIdDAO.getOfferForShoppingCartIdById(id);
	}

	@Override
	@Transactional
	public void removeOfferForShoppingCartId(int id) {
		this.offerForShoppingCartIdDAO.removeOfferForShoppingCartId(id);
	}

}