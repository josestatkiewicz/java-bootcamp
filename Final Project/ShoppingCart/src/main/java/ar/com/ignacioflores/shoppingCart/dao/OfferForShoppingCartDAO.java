package ar.com.ignacioflores.shoppingCart.dao;

import java.util.List;

import ar.com.ignacioflores.shoppingCart.model.OfferForShoppingCart;

public interface OfferForShoppingCartDAO {

	public void addOfferForShoppingCart(OfferForShoppingCart offerForShoppingCart);
    public void updateOfferForShoppingCart(OfferForShoppingCart offerForShoppingCart);
    public List<OfferForShoppingCart> listOfferForShoppingCarts();
    public OfferForShoppingCart getOfferForShoppingCartById(int offerForShoppingCartId);
    public void removeOfferForShoppingCart(int offerForShoppingCartId);
}
