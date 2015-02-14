package ar.com.ignacioflores.shoppingCart.service;

import java.util.List;

import ar.com.ignacioflores.shoppingCart.model.OfferForShoppingCart;

public interface OfferForShoppingCartService{

	public void addOfferForShoppingCart(OfferForShoppingCart offerForShoppingCart);
    public void updateOfferForShoppingCart(OfferForShoppingCart offerForShoppingCart);
    public List<OfferForShoppingCart> listOfferForShoppingCarts();
    public OfferForShoppingCart getOfferForShoppingCartById(int offerForShoppingCartId);
    public void removeOfferForShoppingCart(int offerForShoppingCartId);
	
}