package ar.com.ignacioflores.shoppingCart.dao;

import java.util.List;

import ar.com.ignacioflores.shoppingCart.model.Product;
import ar.com.ignacioflores.shoppingCart.model.ShoppingCart;

public interface ShoppingCartDAO {

	public void addShoppingCart(ShoppingCart shoppingCart);
    public void updateShoppingCart(ShoppingCart shoppingCart);
    public List<ShoppingCart> listShoppingCarts();
    public ShoppingCart getShoppingCartById(int shoppingCartId);
    public void removeShoppingCart(int shoppingCartId);
    public Product getMostExpensiveProduct(Integer shoppingCartId);
    public Product getCheapestProduct(Integer shoppingCartId);
}
