package ar.com.ignacioflores.shoppingCart.service;

import java.util.List;

import ar.com.ignacioflores.shoppingCart.model.ShoppingCart;

public interface ShoppingCartService{

	public void addShoppingCart(ShoppingCart shoppingCart);
    public void updateShoppingCart(ShoppingCart shoppingCart);
    public List<ShoppingCart> listShoppingCarts();
    public ShoppingCart getShoppingCartById(int shoppingCartId);
    public void removeShoppingCart(int shoppingCartId);
    public double performDiscountCreditCard(Integer shoppingCartId);
    public double performDiscountPayPal(Integer shoppingCartId);
    public double performDiscountCash(Integer shoppingCartId);
}
	