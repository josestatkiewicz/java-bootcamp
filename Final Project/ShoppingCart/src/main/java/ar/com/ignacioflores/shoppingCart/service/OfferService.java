package ar.com.ignacioflores.shoppingCart.service;

import java.util.List;

import ar.com.ignacioflores.shoppingCart.model.Offer;

public interface OfferService{

	public void addOffer(Offer offer);
    public void updateOffer(Offer offer);
    public List<Offer> listOffers();
    public Offer getOfferById(int offerId);
    public void removeOffer(int offerId);
	
}