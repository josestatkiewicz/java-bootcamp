package ar.com.ignacioflores.shoppingCart.dao;

import java.util.List;

import ar.com.ignacioflores.shoppingCart.model.ProductsForShoppingCart;

public interface ProductsForShoppingCartDAO {

	public void addProductsForShoppingCart(ProductsForShoppingCart productsForShoppingCart);
    public void updateProductsForShoppingCart(ProductsForShoppingCart productsForShoppingCart);
    public List<ProductsForShoppingCart> listProductsForShoppingCarts();
    public ProductsForShoppingCart getProductsForShoppingCartById(int productsForShoppingCartId);
    public void removeProductsForShoppingCart(int productsForShoppingCartId);
}
