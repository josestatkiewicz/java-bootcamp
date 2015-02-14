package ar.com.ignacioflores.shoppingCart.service.implement;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ignacioflores.shoppingCart.dao.OfferDAO;
import ar.com.ignacioflores.shoppingCart.model.Offer;
import ar.com.ignacioflores.shoppingCart.service.OfferService;

@Service
public class OfferServiceImpl implements OfferService, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private OfferDAO offerDAO;

	public void setOfferDAO(OfferDAO offerDAO) {
		this.offerDAO = offerDAO;
	}

	@Override
	@Transactional
	public void addOffer(Offer offer) {
		this.offerDAO.addOffer(offer);
	}

	@Override
	@Transactional
	public void updateOffer(Offer offer) {
		this.offerDAO.updateOffer(offer);
	}

	@Override
	@Transactional
	public List<Offer> listOffers() {
		return this.offerDAO.listOffers();
	}

	@Override
	@Transactional
	public Offer getOfferById(int id) {
		return this.offerDAO.getOfferById(id);
	}

	@Override
	@Transactional
	public void removeOffer(int id) {
		this.offerDAO.removeOffer(id);
	}

}