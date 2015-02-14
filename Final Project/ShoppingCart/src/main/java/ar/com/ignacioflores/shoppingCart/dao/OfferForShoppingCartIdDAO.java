package ar.com.ignacioflores.shoppingCart.dao;

import java.util.List;

import ar.com.ignacioflores.shoppingCart.model.OfferForShoppingCartId;

public interface OfferForShoppingCartIdDAO {

	public void addOfferForShoppingCartId(OfferForShoppingCartId offerForShoppingCartId);
    public void updateOfferForShoppingCartId(OfferForShoppingCartId offerForShoppingCartId);
    public List<OfferForShoppingCartId> listOfferForShoppingCartIds();
    public OfferForShoppingCartId getOfferForShoppingCartIdById(int offerForShoppingCartIdId);
    public void removeOfferForShoppingCartId(int offerForShoppingCartIdId);
}
