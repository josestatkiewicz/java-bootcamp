package ar.com.ignacioflores.shoppingCart.service;

import java.util.List;

import ar.com.ignacioflores.shoppingCart.model.ProductsForShoppingCartId;

public interface ProductsForShoppingCartIdService{

	public void addProductsForShoppingCartId(ProductsForShoppingCartId productsForShoppingCartId);
    public void updateProductsForShoppingCartId(ProductsForShoppingCartId productsForShoppingCartId);
    public List<ProductsForShoppingCartId> listProductsForShoppingCartIds();
    public ProductsForShoppingCartId getProductsForShoppingCartIdById(int productsForShoppingCartIdId);
    public void removeProductsForShoppingCartId(int productsForShoppingCartIdId);
}