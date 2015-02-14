package ar.com.ignacioflores.shoppingCart.dao;

import java.util.List;

import ar.com.ignacioflores.shoppingCart.model.ProductsForOfferId;

public interface ProductsForOfferIdDAO {

	public void addProductsForOfferId(ProductsForOfferId productsForOfferId);
    public void updateProductsForOfferId(ProductsForOfferId productsForOfferId);
    public List<ProductsForOfferId> listProductsForOfferIds();
    public ProductsForOfferId getProductsForOfferIdById(int productsForOfferIdId);
    public void removeProductsForOfferId(int productsForOfferIdId);
}
