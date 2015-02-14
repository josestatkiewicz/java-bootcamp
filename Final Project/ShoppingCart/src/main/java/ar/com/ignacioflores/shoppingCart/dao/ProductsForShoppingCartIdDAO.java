package ar.com.ignacioflores.shoppingCart.dao;

import java.util.List;

import ar.com.ignacioflores.shoppingCart.model.ProductsForShoppingCartId;

public interface ProductsForShoppingCartIdDAO {

	public void addProductsForShoppingCartId(ProductsForShoppingCartId productsForShoppingCartId);
    public void updateProductsForShoppingCartId(ProductsForShoppingCartId productsForShoppingCartId);
    public List<ProductsForShoppingCartId> listProductsForShoppingCartIds();
    public ProductsForShoppingCartId getProductsForShoppingCartIdById(int productsForShoppingCartIdId);
    public void removeProductsForShoppingCartId(int productsForShoppingCartIdId);
}
