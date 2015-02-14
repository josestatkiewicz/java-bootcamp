package ar.com.ignacioflores.shoppingCart.service;

import java.util.List;

import ar.com.ignacioflores.shoppingCart.model.ProductsForShoppingCart;

public interface ProductsForShoppingCartService{

	public void addProductsForShoppingCart(ProductsForShoppingCart productsForShoppingCart);
    public void updateProductsForShoppingCart(ProductsForShoppingCart productsForShoppingCart);
    public List<ProductsForShoppingCart> listProductsForShoppingCarts();
    public ProductsForShoppingCart getProductsForShoppingCartById(int productsForShoppingCartId);
    public void removeProductsForShoppingCart(int productsForShoppingCartId);
}